package com.jxareas.motionx.ui.tours

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jxareas.motionx.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToursFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tours, container, false)
    }

}