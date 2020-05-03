package com.makentoshe.specialtestapplication

import android.content.Context
import androidx.core.content.res.use

open class Builder(private val context: Context) {

    open var hash: String? = null
        get() = field ?: retrieveStyleAttribute(context)

    companion object {
        private fun retrieveStyleAttribute(context: Context): String {
            val attrs = intArrayOf(android.R.attr.text)
            context.obtainStyledAttributes(R.style.AppTheme, attrs).use { typedArray ->
                return typedArray.getString(0)!!
            }
        }
    }
}