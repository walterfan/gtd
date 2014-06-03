/*
 * Event.h
 *
 *  Created on: 2014Äê5ÔÂ28ÈÕ
 *      Author: walter_2
 */

#ifndef EVENT_H_
#define EVENT_H_

typedef unsigned long HANDLE;

typedef unsigned int Event_Type;

enum {
	READ_EVENT = 01,
	ACCEPT_EVENT = 01,
	WRITE_EVENT = 02,
	TIMEOUT_EVENT = 04,
	SIGNAL_EVENT = 010,
	CLOSE_EVENT = 020

};

class Event_Handler {
public:
	virtual void handle_event(HANDLE handle, Event_Type et) = 0;

	virtual HANDLE get_handle() const = 0;

	virtual ~Event_Handler();
};

#endif /* EVENT_H_ */
