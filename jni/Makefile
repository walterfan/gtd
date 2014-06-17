# Walter created on 5/1/2012
USER_DEPTH=.

CXX = g++
AR  = ar

BASE_DIR=.
BIN_DIR = ../bin/linux
LIB_DIR = ../libs
SRC_DIR = ./util
TEST_DIR = ./test

PLATFORM = cygwin

UNAME_S := $(shell uname -s)
ifeq ($(UNAME_S),Linux)
    PLATFORM = linux
endif


LD_FLAGS = -lpthread -lc -lm -lz -ldl

C_FLAGS =  -DLINUX -D_XOPEN_SOURCE=500 -D_BSD_SOURCE -Wall -g 

INC_FLAGS = -I. \
	-I./util -I./test \
	-I./exam 

CXX_FLAGS = -Wall -g $(INC_FLAGS)
#-Qy -rdynamic

# appllication
WF_TEST = $(BIN_DIR)/waltertest.exe

WF_TEST_OBJS = $(TEST_DIR)/waltertest.o \
	$(SRC_DIR)/TinyTimer.o

all: waltertest

waltertest:$(WF_TEST)

$(WF_TEST):$(WF_TEST_OBJS) 
	@if [ ! -d $(BIN_DIR) ]; then mkdir -p $(BIN_DIR); fi
	$(CXX) $(CXX_FLAGS) -o $@ $^ $(LD_FLAGS)

$(SRC_DIR)/%.o:$(SRC_DIR)/%.cpp
	@if [ ! -d $(BIN_DIR) ]; then mkdir -p $(BIN_DIR); fi
	$(CXX) $(CXX_FLAGS) -c $< -o $@
	
$(TEST_DIR)/%.o:$(TEST_DIR)/%.cpp
	@if [ ! -d $(BIN_DIR) ]; then mkdir -p $(BIN_DIR); fi
	$(CXX) $(CXX_FLAGS) -c $< -o $@
	
clean:
	rm -f $(SRC_DIR)/*.o $(TEST_DIR)/*.o $(WF_TEST)
