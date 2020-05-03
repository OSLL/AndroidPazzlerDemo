package com.makentoshe.specialtestapplication

import android.content.Context

open class AnswerBuilder(context: Context) : Builder(context) {
    override var hash: String? = null
        get() = super.hash
        set(value) {
            field = BuildConfig.HASH
        }
}