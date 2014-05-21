LOCAL_PATH := $(call my-dir)
#-------------------- walterexam -------------------------
include $(CLEAR_VARS)

LOCAL_C_INCLUDES += $(LOCAL_PATH)/util

LOCAL_MODULE    := walterexam
LOCAL_SRC_FILES := exam/echo_service.cpp

include $(BUILD_EXECUTABLE)
#-------------------- waltertest -------------------------
include $(CLEAR_VARS)

LOCAL_C_INCLUDES += $(LOCAL_PATH)/util

LOCAL_MODULE    := walter
LOCAL_SRC_FILES := test/waltertest.cpp

include $(BUILD_EXECUTABLE)
#-------------------- libgtd.so -------------------------
include $(CLEAR_VARS)

LOCAL_C_INCLUDES += $(LOCAL_PATH)/util

LOCAL_MODULE    := gtd
LOCAL_SRC_FILES := gtd.cpp util/TinyUtil.cpp
LOCAL_LDLIBS := -ldl -llog

include $(BUILD_SHARED_LIBRARY)
