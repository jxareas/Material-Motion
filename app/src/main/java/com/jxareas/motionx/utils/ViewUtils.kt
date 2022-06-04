package com.jxareas.motionx.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

inline infix fun<reified VB : ViewBinding> ViewGroup.bind(
    crossinline bindingInflater : LayoutInflater.(parent : ViewGroup, attachToParent : Boolean) -> VB
) : VB = LayoutInflater.from(context).let { inflater ->
    bindingInflater.invoke(inflater, this, false)
}