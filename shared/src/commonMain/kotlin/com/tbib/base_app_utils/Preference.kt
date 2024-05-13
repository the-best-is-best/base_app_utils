package com.tbib.base_app_utils


expect fun KMMContext.putInt(key: String, value: Int)

expect fun KMMContext.getInt(key: String, default: Int? = null): Int

expect fun KMMContext.putString(key: String, value: String)

expect fun KMMContext.getString(key: String): String?

expect fun KMMContext.putBool(key: String, value: Boolean)

expect fun KMMContext.getBool(key: String, default: Boolean? = null): Boolean

expect fun KMMContext.remove(key: String)
