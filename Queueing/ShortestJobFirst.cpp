#include "ShortestJobFirst.h"

void ShortestJobFirst::sort_as_per_burst_time()
{
	for (int j = 0; j < queue.size(); j++) {
		for (int i = j; i < queue.size(); i++) {
			if (queue[j].arival_time == queue[i].arival_time
				&& queue[j].burst_time > queue[i].burst_time) {
				Process temp = queue[j];
				queue[j] = queue[i];
				queue[i] = temp;
			}
		}
	}

}

void ShortestJobFirst::process()
{
	add(Process("P1", 7,5));
	add(Process("P2", 5,5));
	add(Process("P3", 3,4));
	add(Process("P4", 1,4));
	add(Process("P5", 2,0));
	add(Process("P6", 1,2));

	sort_as_per_arrival_time();
	sort_as_per_burst_time();
	calc_waiting_time();
	calc_turnaround_time();
	

	print();
}
