#pragma once
#include <vector>
#include <iostream>
class Process {

public:
	std::string name;
	int burst_time;
	int arival_time;
	int waiting_time = 0;
	int turnaround_time = 0;

public:
	Process()
		:name("P0"), burst_time(0), arival_time(0) {}
	Process(std::string name, int burst_time)
		:name(name),burst_time(burst_time),arival_time(0){}
	Process(std::string name, int burst_time,int arival_time)
		:name(name), burst_time(burst_time), arival_time(arival_time) {}
};

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

class FirstComeFirstServe :public Scheduler
{
public:

	// Inherited via Scheduler
	virtual void process() override;
};

