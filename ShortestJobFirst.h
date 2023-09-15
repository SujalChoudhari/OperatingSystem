#pragma once
#include "Scheduler.h"

class ShortestJobFirst: public Scheduler
{
public:
	void sort_as_per_burst_time();


	// Inherited via Scheduler
	virtual void process() override;

};

