LOCAL_PATH := $(call my-dir)
#-------------------- walterexam -------------------------
include $(CLEAR_VARS)

LOCAL_C_INCLUDES += $(LOCAL_PATH)/util

LOCAL_MODULE    := walterexam
LOCAL_SRC_FILES := exam/walterexam.cpp exam/echo_service.cpp

include $(BUILD_EXECUTABLE)
#-------------------- waltertest -------------------------
include $(CLEAR_VARS)

LOCAL_C_INCLUDES += $(LOCAL_PATH)/util

LOCAL_MODULE    := waltertest

LOCAL_SRC_FILES := test/waltertest.cpp util/TinyServer.cpp util/TinyClient.cpp


include $(BUILD_EXECUTABLE)
#-------------------- msgbus.so -------------------------
include $(CLEAR_VARS)

LOCAL_C_INCLUDES += $(LOCAL_PATH)/util

LOCAL_MODULE    := msgbus
LOCAL_SRC_FILES := msgbus.cpp
LOCAL_LDLIBS := -ldl -llog

include $(BUILD_SHARED_LIBRARY)

#-------------------- libgtd.so -------------------------
include $(CLEAR_VARS)

LOCAL_C_INCLUDES += $(LOCAL_PATH)/util

LOCAL_MODULE    := gtd
LOCAL_SRC_FILES := gtd.cpp util/TinyUtil.cpp util/Observer.cpp
LOCAL_LDLIBS := -ldl -llog

include $(BUILD_SHARED_LIBRARY)
