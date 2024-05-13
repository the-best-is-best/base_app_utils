package com.tbib.base_app_utils


class KMMPreference {

    fun put(key: String, value: Int) {
        UtilsStaticVar.context!!.putInt(key, value)
    }

    fun put(key: String, value: String) {
        UtilsStaticVar.context!!.putString(key, value)
    }

    fun put(key: String, value: Boolean) {
        UtilsStaticVar.context!!.putBool(key, value)
    }

    fun getInt(key: String, default: Int? = null): Int = UtilsStaticVar.context!!.getInt(key, default)


    fun getString(key: String): String? = UtilsStaticVar.context!!.getString(key)


    fun getBool(key: String, default: Boolean? = null): Boolean =
        UtilsStaticVar.context!!.getBool(key, default)

    fun remove(key: String) {
        UtilsStaticVar.context!!.remove(key)
    }

}
