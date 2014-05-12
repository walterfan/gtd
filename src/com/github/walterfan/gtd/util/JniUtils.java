package com.github.walterfan.gtd.util;

import java.nio.ByteBuffer;

public class JniUtils {
	
	static {
		System.loadLibrary("jniutils");
	}
	
	public static native void log(String tag, String msg);
	
	public static native void copy(ByteBuffer dst, float[] src, int offset, int len);
}
