package com.upperlucky.customviewanimatorkt

import android.content.res.Resources
import android.util.TypedValue

/**
 * created by yunKun.wen on 2020/9/4
 * desc:
 */

val Float.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )

val Int.dp
    get() = this.toFloat().dp