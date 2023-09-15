// OSScheduling.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include "FirstComeFirstServe.h"
#include "ShortestJobFirst.h"



int main()
{
	/*FirstComeFirstServe scheduler = FirstComeFirstServe();
	scheduler.process(); */

	ShortestJobFirst scheduler = ShortestJobFirst();
	scheduler.process();
}



