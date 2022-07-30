package com.jxareas.motionx.ui.common.events

import android.view.View

@FunctionalInterface
interface OnClick<T> {
    fun onArtworkClicked(view : View, item : T)
}