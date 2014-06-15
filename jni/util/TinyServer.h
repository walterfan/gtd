/*
 * TinyServer.h
 *
 *  Created on: 2014Äê6ÔÂ14ÈÕ
 *      Author: walter_2
 */

#ifndef TINYSERVER_H_
#define TINYSERVER_H_

#include <stdint.h>

typedef enum {
	TRANSPORT_TCP = 1,
	TRANSPORT_UDP = 2,
	TRANSPORT_TLS = 3,
	TRANSPORT_DTLS = 6
} TRANSPORT_PROTOCOL;

typedef enum {
	APP_ECHO,
	APP_TIME,
	APP_HTTP,
	APP_SIP,
	APP_XMPP,
	APP_WEB_SOCKET,
	APP_RTP,
	APP_FTP,
	APP_TELNET
} APP_PROTOCOL;


typedef enum {
	OPT_HOST,
	OPT_PORT
} APP_OPTION;


class ITinyServer {
public:
	virtual ~ITinyServer() {};

	virtual void SetOption(int optionKey, void* optionValue) = 0;
	virtual void* GetOption(int optionKey) = 0;

	virtual int Init(TRANSPORT_PROTOCOL trptType, APP_PROTOCOL appType) = 0;
	virtual int Start() = 0;
	virtual int Run() = 0;
	virtual int Stop() = 0;
	virtual int Clean() = 0;
};


class TinyServer: public ITinyServer
{
public:
	TinyServer();
	virtual ~TinyServer();

	virtual void SetOption(int optionKey, void* optionValue) ;
	virtual void* GetOption(int optionKey) ;

	virtual int Init(TRANSPORT_PROTOCOL trptType, APP_PROTOCOL appType);
	virtual int Start();
	virtual int Run();
	virtual int Stop();
	virtual int Clean();
private:
	TRANSPORT_PROTOCOL m_trptType;
	APP_PROTOCOL m_appType;
	int m_nPort;
};

#endif /* TINYSERVER_H_ */
