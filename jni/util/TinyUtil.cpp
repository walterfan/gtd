#include "TinyUtil.h"
#include <string>
#include <cctype>
#include <cstdlib>
#include <iostream>
#include <fstream>
#include <sstream>
#include <sys/types.h>
#include <dirent.h>
#include <errno.h>

namespace wfan {

int file2msg(const char* filename,string& msg)
{
    ifstream ifile(filename);
    if(!ifile)
    {
        cout<<"Unable to read "<<filename<<endl;
        return RET_ERR;
    }
    ostringstream buf;
    char ch;
    while ( buf && ifile.get( ch ))
        buf.put( ch );
    ifile.close();
    msg=buf.str();
    return RET_OK;
}

int file2msg(const char* filename,char *msg)
{
    ifstream ifile(filename);
    if(!ifile)
    {
        cout<<"Unable to read "<<filename<<endl;
        return -1;
    }
    ostringstream buf;
    char ch;
    while ( buf && ifile.get( ch ))
    buf.put( ch );
    strcpy(msg, buf.str().c_str());
    return 0;
}

int RetrieveFiles(const char* szFolder, vector<string>& files)
{
  struct dirent* direntp;
  DIR* dirp = opendir(szFolder);

  if(NULL == dirp) {
    return -1;
  }

  while( NULL != (direntp = readdir(dirp))) {
    string file = direntp->d_name;
    if(".." == file || "." == file)
        continue;
    files.push_back(file);
  }

  while((-1 == closedir(dirp)) && (errno == EINTR));

  return files.size();
}

string UpperCase( const string& p_string )
{
    string str = p_string;

    for( size_t i = 0; i < str.size(); i++ )
    {
        str[i] = toupper( str[i] );
    }
    return str;
}

string LowerCase( const string& p_string )
{
    string str = p_string;

    for( size_t i = 0; i < str.size(); i++ )
    {
        str[i] = tolower( str[i] );
    }
    return str;
}


}//--end of namespace wfan
