package com.tbib.base_app_utils

import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.format

 actual class Strings
{
    actual fun get(id: StringResource, args: List<Any>): String
    {
        return if(args.isEmpty())
        {
            StringDesc.Resource(id).localized()
        }
        else
        {
            id.format(*args.toTypedArray()).localized()
        }
    }
}