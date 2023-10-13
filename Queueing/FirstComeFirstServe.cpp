#include "FirstComeFirstServe.h"
#include <algorithm>

void FirstComeFirstServe::process()
{
	add(Process("P1", 7));
	add(Process("P2", 5));
	add(Process("P3", 3));
	add(Process("P4", 1));
	add(Process("P5", 2));
	add(Process("P6", 1));

	sort_as_per_arrival_time();
	calc_waiting_time();
	calc_turnaround_time();

	print();
}
