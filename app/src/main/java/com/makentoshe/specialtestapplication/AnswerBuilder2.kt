package com.makentoshe.specialtestapplication

data class AnswerBuilder2(val hash: String) {
    fun build() = hash.apply {
        return this
    }
}