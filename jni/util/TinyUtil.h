#ifndef __TINY_UTIL_H__
#define __TINY_UTIL_H__

#include <cstddef>
#include <cstdint>
#include <string>
#include <vector>

#define RET_ERR 1
#define RET_OK 0

using namespace std;

#define ERR_RETURN(ret,fmt, ...) \
    do { \
        if (!ret) {\
            fprintf(stderr, "%s:%d:%s(): " fmt, __FILE__, \
                                __LINE__, __func__, __VA_ARGS__); \
            return ret;\
        }\
    } while (0)


#ifndef FALSE
    #define FALSE 0
#endif // FALSE

#ifndef TRUE
    #define TRUE 1
#endif // TRUE

#define DEFAULT_BACK_LOG 1024


#ifndef CERR
#define CERR std::cerr <<"\n["<<time(NULL)<<"]\t"<< __FILE__ << "," << std::dec << __LINE__ << " : "
#endif

#ifndef COUT
#define COUT std::cout <<"\n["<<time(NULL)<<"]\t"<< __FILE__ << "," << std::dec << __LINE__ << " : "
#endif

#ifndef ASSERT
#define ASSERT(condition) { \
    if(!(condition)) \
    { \
        std::cerr << "ASSERT FAILED: " << #condition << " @ "; \
        std::cerr << __FILE__ << " (" << __LINE__ << ")" << std::endl; \
    }}
#endif

#ifndef ASSERT_RET
#define ASSERT_RET(condition, retval) { \
    if(!(condition)) \
    { \
        std::cerr << "ASSERT FAILED: " << #condition << " @ "; \
        std::cerr << __FILE__ << " (" << __LINE__ << ")" << std::endl; \
        return retval;\
    }}
#endif

#ifndef ASSERT_RET_VOID
#define ASSERT_RET_VOID(condition) { \
    if(!(condition)) \
    { \
        std::cerr << "ASSERT FAILED: " << #condition << " @ "; \
        std::cerr << __FILE__ << " (" << __LINE__ << ")" << std::endl; \
        return;\
    }}
#endif

#ifndef SAFE_DELETE
#define SAFE_DELETE(p) \
    do \
    { \
        if(NULL != p) \
        { \
            delete p; \
            p = NULL; \
        } \
    } while(0)
#endif

#ifndef SAFE_DELETE_ARRAY
#define SAFE_DELETE_ARRAY(p) \
    do \
    { \
        if(NULL != p) \
        {\
            delete [] p; \
            p = NULL; \
        } \
    } while(0)
#endif

#ifndef SAFE_ADDREF
#define SAFE_ADDREF(p) if(p)\
    {\
        p->AddReference();\
    }

#endif

#ifndef SAFE_RELEASE
#define SAFE_RELEASE(p) \
    do \
    { \
        if(NULL != p) \
        { \
            p->ReleaseReference(); \
            p = NULL; \
        } \
    } while(0)
#endif

namespace wfan {

	int file2msg(const char* filename,string& msg);

	int file2msg(const char* filename,char *msg);

	int RetrieveFiles(const char* szFolder, vector<string>& files);

	string UpperCase( const string& p_string );

	string LowerCase( const string& p_string );

}

#endif
