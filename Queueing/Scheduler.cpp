#include "Process.h"
#include <algorithm>
#include <iostream>
#include "Scheduler.h"

void Scheduler::add(Process process)
{
	queue.push_back(process);
}

void Scheduler::sort_as_per_arrival_time()
{
	std::sort(queue.begin(), queue.end(), [](const Process& p1, const Process& p2) {
		return p1.arival_time < p2.arival_time;
		});

}

void Scheduler::calc_waiting_time()
{
	queue[0].waiting_time = 0;

	for (int i = 1; i < queue.size(); i++) {
		int time = 0;
		for (int j = 0; j < i; j++) {
			time += queue[j].burst_time;
		}

		queue[i].waiting_time = time - queue[i].arival_time;
		queue[i].waiting_time = queue[i].waiting_time <= 0 ? 0 : queue[i].waiting_time;
	}
}

void Scheduler::calc_turnaround_time()
{
	for (int i = 0; i < queue.size(); i++) {
		queue[i].turnaround_time = queue[i].burst_time + queue[i].waiting_time;
	}
}

void Scheduler::print()
{
	std::cout << "Name\tAT\tBT\tWT\tTAT\n";
	for (int i = 0; i < queue.size(); i++) {
		std::cout << queue[i].name << "\t" << queue[i].arival_time << "\t" << queue[i].burst_time << "\t" << queue[i].waiting_time << "\t" << queue[i].turnaround_time << "\n";
	}
}