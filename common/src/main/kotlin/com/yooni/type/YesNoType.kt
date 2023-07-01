package com.yooni.type

enum class YesNoType {
    Y, N;

    fun convertToBoolean(): Boolean {
        return this == Y
    }
}