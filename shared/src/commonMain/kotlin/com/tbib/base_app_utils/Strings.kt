package com.tbib.base_app_utils

import dev.icerock.moko.resources.StringResource

 expect class Strings {
    fun get(id: StringResource, args: List<Any>): String
}