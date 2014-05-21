# Introduction
  * It's my first Android application for test and demo of what I learned and thought


# Suppose
  * ADT(Android Development Tool) is installed in d:/opt/adt/sdk
  * NDK(Native Development Tool) is installed in d:/opt/adt/ndk
 
# ADT tips
1. set ADT_PROJECT_PATH=d:/opt/adt/sdk
2. read file:///D:/opt/adt/sdk/docs/index.html  firstly

# NDK tips
1. set NDK_PROJECT_PATH=d:/opt/adt/ndk
2. read file:///D:/opt/adt/ndk/documentation.html firstly

# Cygwin tips
  * vim /etc/profile 
  >  
	ADT_ROOT=/cygdrive/d/opt/adt/sdk
	NDK_ROOT=/cygdrive/d/opt/adt/ndk
	PATH="/usr/local/bin:/usr/bin:${NDK_ROOT}:${PATH}"

  * vim ~/.bashrc 
  >   
	alias ll='ls -l'
	alias gtd='cd /home/walter/source/gtd' 

# FAQ
  * How to execute the executable ndk binary
    * adb push libs/armeabi-v7a/waltertest /data/tmp/waltertest'
    * adb shell chmod 777 /data/tmp/waltertest' 
    * adb shell /data/tmp/waltertest 