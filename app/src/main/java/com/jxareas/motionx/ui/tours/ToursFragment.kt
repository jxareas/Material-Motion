package com.jxareas.motionx.ui.tours

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jxareas.motionx.R

class ToursFragment : Fragment() {

    companion object {
        fun newInstance() = ToursFragment()
    }

    private lateinit var viewModel: ToursViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_tours, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ToursViewModel::class.java)
        // TODO: Use the ViewModel
    }

}