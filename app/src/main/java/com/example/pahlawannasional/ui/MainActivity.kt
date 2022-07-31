package com.example.pahlawannasional.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.pahlawannasional.data.PahlawanRepository
import com.example.pahlawannasional.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private var _adapter: PahlawanAdapter? = null
    private val adapter get() = _adapter as PahlawanAdapter

    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(PahlawanRepository(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        _adapter = PahlawanAdapter()

        binding.apply {
            rvHomePahlawan.adapter = adapter
            fabUp.setOnClickListener {
                rvHomePahlawan.scrollToPosition(0)
            }
        }

        viewModel.pahlawan.observe(this) {
            lifecycleScope.launch {
                adapter.submitData(it)
            }
        }

    }
}