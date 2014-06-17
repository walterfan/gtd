/*
 * TinyTimer.h
 *
 *  Created on: 2004-6-15
 *      Author: walter
 */

#ifndef __TINY_TIMER_H__
#define __TINY_TIMER_H__

#include <stdint.h>

typedef enum {
	MICRO_SECOND,
	MILLI_SECOND,
	SECOND,
	MINUTE,
	HOUR,
	DAY,
	WEEK,
	MONTH,
	YEAR
} TimeUnit;

class CTinyTimer {
public:
	CTinyTimer();
	virtual ~CTinyTimer();

	void Reset();

	void Begin(int64_t beginTime = 0);
	void End(int64_t endTime = 0);
	void SetDeadline(int64_t deadline);

	static TimeUnit GetDefaultTimeUnit();

	int64_t GetDuration(TimeUnit timeUnit = MILLI_SECOND);
	int64_t GetTimeNow(TimeUnit timeUnit = MILLI_SECOND);
	int64_t GetTimeLeft(TimeUnit timeUnit = MILLI_SECOND);
	int64_t GetTimeCost(TimeUnit timeUnit = MILLI_SECOND);
private:
	int64_t m_initTime;
	int64_t m_startTime;
	int64_t m_endTime;
	int64_t m_deadline;
	static TimeUnit ms_default_time_unit;

};


#endif /* __TINY_TIMER_H__ */
