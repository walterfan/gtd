
#include "TinyTimer.h"
#include <stdio.h>
#include <netdb.h>
#include <time.h>

typedef int64_t(CTinyTimer::*PMF)(TimeUnit);

int64_t get_host_name(const char* dname)
{
	int64_t ret = 0;
	CTinyTimer* pTimer = new CTinyTimer();
	PMF pmf = &CTinyTimer::GetTimeCost;
	printf("member function pointer: %p\n",  pmf);
	struct hostent * ent = gethostbyname(dname);
	ret = pTimer->GetTimeCost();
	printf("The name is %s, time cost %lld ms\n", ent->h_name, ret);
	delete pTimer;
	return ret;

}

char* get_cur_time(char* buffer, int len=30)
{
	time_t rawtime;
	struct tm * timeinfo;

	time(&rawtime );
	timeinfo = localtime(&rawtime );

	strftime (buffer,30,"%x %X\0",timeinfo);
	return buffer;

}

int main(int argc, char* argv[])
{
	char str[30] = {'\0'};
    printf("# [%s] WalterTest\n", get_cur_time(str));

    printf("static function pointer: %p\n",  CTinyTimer::GetDefaultTimeUnit);
    printf("member function pointer: %p\n",  &CTinyTimer::GetTimeCost);
    get_host_name("www.sina.com.cn");
    printf("# [%s] byebye\n", get_cur_time(str));
    return 0;
}
