: ndk build script
: - Walter Fan 
@echo off

set DEST_DIR=/data/local/walter

for %%c in (waltertest walterexam) do (
	echo * execute %%c:
	adb shell su -c "%DEST_DIR%/%%c"
)


