package com.example.pahlawannasional.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pahlawannasional.data.responses.Pahlawan
import kotlin.math.max
import kotlin.math.min

private const val STARTING_KEY = 0

/**
 * Specify how to retrieve data in incremental chunks.
 */
class PahlawanPagingSource(private val pahlawan: List<Pahlawan>) : PagingSource<Int, Pahlawan>() {
    override fun getRefreshKey(state: PagingState<Int, Pahlawan>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val pahlawan = state.closestItemToPosition(anchorPosition) ?: return null
        return ensureValidKey(key = pahlawan.id - (state.config.pageSize / 2))
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pahlawan> {

        val start = params.key ?: STARTING_KEY

        val range = start.until(min(start + params.loadSize, pahlawan.size))

        return LoadResult.Page(
            data = pahlawan.slice(range),
            prevKey = when (start) {
                STARTING_KEY -> null
                else -> ensureValidKey(key = range.first - params.loadSize)
            },
            nextKey = range.last + 1
        )
    }

    private fun ensureValidKey(key: Int) = max(key, STARTING_KEY)
}