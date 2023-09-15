#pragma once
#include <string>
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