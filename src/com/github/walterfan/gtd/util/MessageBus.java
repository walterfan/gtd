package com.github.walterfan.gtd.util;

//javah -o jni/msgbus.h -classpath bin/classes com.github.walterfan.git.util.MessageBus
public class MessageBus {
	private static final String libName = "msgbus";
	
	static {
		System.loadLibrary(libName);
	}
	
	public static native int sendMessage(String jsonMsg);
	
	public static void onMessage(String jsonMsg) {
		System.out.println(jsonMsg);
	}

}
