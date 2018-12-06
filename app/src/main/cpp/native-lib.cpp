//
// Created by Pravin Divraniya on 12/11/2017.
//
#include <jni.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_clarion_mvvmdiexample_view_activity_BaseActivity_getApiKey(
        JNIEnv* pEnv,
        jclass jclazz) {
    return pEnv->NewStringUTF("743ba4a259034e3ca6a3e7de37786ecd");
}