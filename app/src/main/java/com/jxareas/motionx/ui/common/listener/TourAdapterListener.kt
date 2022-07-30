package com.jxareas.motionx.ui.common.listener

import com.jxareas.motionx.domain.model.Tour
import com.jxareas.motionx.ui.common.events.OnClick

@FunctionalInterface
fun interface TourAdapterListener : OnClick<Tour>