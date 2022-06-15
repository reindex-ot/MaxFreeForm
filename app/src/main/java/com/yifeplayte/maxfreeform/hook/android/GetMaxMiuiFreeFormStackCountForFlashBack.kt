package com.yifeplayte.maxfreeform.hook.android

import com.github.kyuubiran.ezxhelper.utils.findMethod
import com.github.kyuubiran.ezxhelper.utils.hookMethod
import com.yifeplayte.maxfreeform.hook.BaseHook
import de.robv.android.xposed.XposedBridge


object GetMaxMiuiFreeFormStackCountForFlashBack : BaseHook() {
    override fun init() {
        try {
            findMethod("com.android.server.wm.MiuiFreeFormStackDisplayStrategy") {
                name == "getMaxMiuiFreeFormStackCountForFlashBack"
            }.hookMethod {
                after { param ->
                    param.result = 256
                }
            }
            XposedBridge.log("MaxFreeForm: Hook getMaxMiuiFreeFormStackCountForFlashBack success!")
        } catch (e: Throwable) {
            XposedBridge.log("MaxFreeForm: Hook getMaxMiuiFreeFormStackCountForFlashBack failed!")
        }

    }

}
