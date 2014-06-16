#ifndef __GTD_H__
#define __GTD_H__

#include <jni.h>

#include <android/log.h>

#define  APP_TAG    "GTD"
#define  DEBUG_TRACE(...)  __android_log_print(ANDROID_LOG_DEBUG, APP_TAG, __VA_ARGS__)
#define  INFO_TRACE(...)  __android_log_print(ANDROID_LOG_INFO, APP_TAG, __VA_ARGS__)
#define  ERROR_TRACE(...)  __android_log_print(ANDROID_LOG_ERROR, APP_TAG, __VA_ARGS__)



#ifdef __cplusplus
extern "C" {
#endif

	const char* get_version();

	const char* get_app_name();

#ifdef __cplusplus
}
#endif

#endif
