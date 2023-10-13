#pragma once
#include <vector>
#include "Process.h"
class Scheduler {

public:
	std::vector<Process> queue;
public:
	void add(Process process);
	void sort_as_per_arrival_time();
	void calc_waiting_time();
	void calc_turnaround_time();

	void print();
	virtual void process() = 0;

};