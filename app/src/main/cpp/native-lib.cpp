//
// Created by Pravin Divraniya on 12/11/2017.
//
#include <jni.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_pravin_mvvmdiexample_view_activity_BaseActivity_getApiKey(
        JNIEnv* pEnv,
        jclass jclazz) {
    return pEnv->NewStringUTF("Your_API_KEY");
}