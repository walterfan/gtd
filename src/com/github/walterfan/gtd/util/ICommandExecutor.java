package com.github.walterfan.gtd.util;

public interface ICommandExecutor {
	//wrap command into bytes and send it to c++
	int execute(byte[] command);
}
