package io.supercharge.hiltexample.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.supercharge.hiltexample.BR
import io.supercharge.hiltexample.R
import io.supercharge.hiltexample.main.model.CounterViewModel

@AndroidEntryPoint
class CounterFragment : Fragment() {

    private val viewModel: CounterViewModel by viewModels()

    private var binding: ViewDataBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_counter,
            container,
            false
        )
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.run {
            lifecycleOwner = this@CounterFragment
            setVariable(BR.vm, viewModel)
            executePendingBindings()
        }
    }
}
