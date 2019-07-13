#include <jni.h>
#include <string>
#include <iostream>

#include <boost/scoped_ptr.hpp>
#include <android/log.h>

using namespace std;

#define LOGD(...) ((void)__android_log_print(ANDROID_LOG_DEBUG, "TTGG", __VA_ARGS__))

int c_main(void);
int start_logger(const char *app_name);

// https://github.com/yuanhy0055/rcVLC/blob/master/Vlc_01/jni/yyomxil.cpp
jint JNI_OnLoad(JavaVM* vm, void* reserved)
{
    JNIEnv* env;
    if (vm->GetEnv(reinterpret_cast<void**>(&env), JNI_VERSION_1_6) != JNI_OK) {
        return -1;
    }
    start_logger("TTGG");
    return JNI_VERSION_1_6;
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_ag_ndktest_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {

    c_main();

    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

class CMyClass
{
public:
    explicit CMyClass()
    {
        cout << "CMyClass Construction function !" << endl;
    }

    ~CMyClass()
    {
        cout << "CMyClass Destruct function" << endl;
    }

    void MyFunc(void){

        cout << "Do Something...." << endl;
    }
};

void Function1(void)
{
    //boost::scoped_ptr是一个简单的智能指针，它
    //能保证离开作用域后对象被自动释放，能避免由于
    //忘记释放而导致的内存泄漏。
    //验证运行的正确性是：打印：Now, Quit Function ...
    //之后，打印：CMyClass Destruct function
    boost::scoped_ptr<CMyClass> spMyClass(new CMyClass());
    spMyClass->MyFunc();
    cout << "Now, Quit Function ..." << endl;
}

int c_main(void)
{
    cout << "boost demo test start ..." << endl;
    Function1();
    cout << "boost demo test end ..." << endl;

//    while (1) {
//        sleep(1);
//    }

    return 0;
}