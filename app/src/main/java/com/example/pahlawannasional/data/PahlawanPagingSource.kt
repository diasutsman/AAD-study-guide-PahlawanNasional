package com.example.pahlawannasional.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pahlawannasional.data.responses.Pahlawan
import kotlin.math.max
import kotlin.math.min

private const val STARTING_KEY = 0
private const val TAG = "PahlawanPagingSource"

/**
 * Specify how to retrieve data in incremental chunks.
 */
class PahlawanPagingSource(private val pahlawan: List<Pahlawan>) : PagingSource<Int, Pahlawan>() {

    override fun getRefreshKey(state: PagingState<Int, Pahlawan>): Int? {
        // Get the anchor position
        val anchorPosition = state.anchorPosition ?: return null
        // Get the item that is closest to the anchor position
        val pahlawan = state.closestItemToPosition(anchorPosition) ?: return null
        // From closest item go up by page size / 2
        return ensureValidKey(key = pahlawan.id - (state.config.pageSize / 2))
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pahlawan> {
        // use the STARTING_KEY if we're on the first page
        val start = params.key ?: STARTING_KEY

        // Specify how many items to load per load() call.
        // the end is limited to the size of the list.
        val range = start.until(min(start + params.loadSize, pahlawan.size))
        Log.d(TAG, "load size: ${params.loadSize}")
        Log.d(TAG, "load: $range")
        return LoadResult.Page(
            data = pahlawan.slice(range),
            // if it is the start of the list, we don't need to load for the previous page
            prevKey = when (start) {
                STARTING_KEY -> null
                else -> ensureValidKey(key = range.first - params.loadSize)
            },
            // if the data is limited, we can say there is no next page
            // by checking if the current key is the last key in the list
            nextKey = when (params.key) {
                range.last + 1 -> null
                else -> ensureValidKey(key = range.last + 1)
            }
        )
    }

    private fun ensureValidKey(key: Int) = max(key, STARTING_KEY)
}