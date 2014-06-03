#include <android/log.h>
#include <string.h>
#include <stdio.h>

#include "msgbus.h"

const char* TAG = "MSGBUS";

JNIEXPORT jint JNICALL Java_com_github_walterfan_gtd_util_MessageBus_sendMessage
  (JNIEnv *jenv, jclass jcls, jstring jstr) {
	const char* szMsg = jenv->GetStringUTFChars(jstr, 0);
	printf("sendMessage: %s\n", szMsg);
	//__android_log_print(ANDROID_LOG_VERBOSE, TAG, szMsg);

	jenv->ReleaseStringUTFChars(jstr, szMsg);
	return 0;
}
