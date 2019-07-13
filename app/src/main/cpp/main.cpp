#include <jni.h>
#include <string>
#include <iostream>

#include <boost/scoped_ptr.hpp>
#include <android/log.h>

using namespace std;

#define LOGD(...) ((void)__android_log_print(ANDROID_LOG_DEBUG, "TTGG", __VA_ARGS__))

int c_main(void);
int start_logger(const char *app_name);
void Function1(void);

// https://github.com/yuanhy0055/rcVLC/blob/master/Vlc_01/jni/yyomxil.cpp
jint JNI_OnLoad(JavaVM* vm, void* reserved)
{
    JNIEnv* env;
    if (vm->GetEnv(reinterpret_cast<void**>(&env), JNI_VERSION_1_6) != JNI_OK) {
        return -1;
    }
    start_logger("TTGG");
    c_main();
    return JNI_VERSION_1_6;
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_ag_ndktest_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {

    //c_main();

    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}


int c_main(void)
{
    cout << "========== c_main =========" << endl;
    cout << "boost demo test start ..." << endl;
    Function1();
    cout << "boost demo test end ..." << endl;

    return 0;
}