: ndk build script
: - Walter Fan 
@echo off

set DEST_DIR=/data/local/walter
set LIB_DIR=../libs/armeabi-v7a

echo # create %DEST_DIR% 

adb shell su -c "mkdir %DEST_DIR%"

if not exist jni/msgbus.h (
	echo # generate jni header file
	cd ..
	javah -o jni/msgbus.h -classpath bin/classes com.github.walterfan.git.util.MessageBus
	cd jni
)

if not exist %LIB_DIR% (
	goto :eof
)

echo -- build begin --
call ndk-build

for %%c in (libgtd.so libmsgbus.so  waltertest walterexam) do (
	echo * deploy %%c and chmod
	adb push %LIB_DIR%/%%c %DEST_DIR%
	adb shell su -c "chmod 755 %DEST_DIR%/%%c"
)




