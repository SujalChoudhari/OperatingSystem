#pragma once
#include <vector>
#include <iostream>
#include "Process.h"
#include "Scheduler.h"
class FirstComeFirstServe :public Scheduler
{
public:

	// Inherited via Scheduler
	virtual void process() override;
};

