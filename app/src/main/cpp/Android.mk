LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

BOOST_INCLUDE_PATH	:= E:/PWB/yyboostlib/x86_64/include/boost-1_68
BOOST_LIB_PATH		:= E:/PWB/yyboostlib/x86_64/lib

LOCAL_MODULE    := ndk-test-lib
LOCAL_SRC_FILES := main.cpp \
                   android_buf.cpp

LOCAL_C_INCLUDES	:= $(BOOST_INCLUDE_PATH)
LOCAL_LDFLAGS += -fPIE
LOCAL_LDLIBS +=  -llog -ldl
LOCAL_LDLIBS += -L$(BOOST_LIB_PATH) -lboost_system-clang-mt-x64-1_68 -lboost_thread-clang-mt-x64-1_68

include $(BUILD_SHARED_LIBRARY)