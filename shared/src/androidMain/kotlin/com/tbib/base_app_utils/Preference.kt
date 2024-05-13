package com.tbib.base_app_utils

const val SP_NAME = "sb_shared_pref"

actual fun KMMContext.putInt(key: String, value: Int) {
    getSpEditor().putInt(key, value).apply()

}

actual fun KMMContext.getInt(key: String, default: Int?): Int {
    return getSp().getInt(key, default ?: 0)
}

actual fun KMMContext.putString(key: String, value: String) {
    getSpEditor().putString(key, value).apply()
}

actual fun KMMContext.getString(key: String): String? {
    return getSp().getString(key, null)
}

actual fun KMMContext.putBool(key: String, value: Boolean) {
    getSpEditor().putBoolean(key, value).apply()
}

actual fun KMMContext.getBool(key: String, default: Boolean?): Boolean {
    return getSp().getBoolean(key, default ?: false)
}

actual fun KMMContext.remove(key: String) {
    getSpEditor().remove(key).apply()

}

private fun KMMContext.getSp() = getSharedPreferences(SP_NAME, 0)

private fun KMMContext.getSpEditor() = getSp().edit()
