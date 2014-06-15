/*
 * TinyServer.cpp
 *
 *  Created on: 2014Äê6ÔÂ14ÈÕ
 *      Author: walter_2
 */

#include <TinyServer.h>

TinyServer::TinyServer():m_trptType(TRANSPORT_TCP), m_appType(APP_ECHO), m_nPort(0) {
	// TODO Auto-generated constructor stub

}

TinyServer::~TinyServer() {
	// TODO Auto-generated destructor stub
}

int TinyServer::Init(TRANSPORT_PROTOCOL trptType, APP_PROTOCOL appType)
{
	return 0;
}
