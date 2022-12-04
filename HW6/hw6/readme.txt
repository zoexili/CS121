Programming Assignment: Traveling Salesperson Problem


/**********************************************************************
 * All teammates' names                                               *
 **********************************************************************/
Li Xi

/**********************************************************************
 * Approximate number of hours to complete this assignment            *
 **********************************************************************/

Number of hours for 1st TEAMMATE's NAME: 10 hours

Number of hours for 2nd TEAMMATE's NAME:


/**********************************************************************
 *  Explain how you implemented the nearest insertion heuristic.      *
 **********************************************************************/

First, I used a if-else loop to help determine if the first node is null or not null. If it is null, 
then I create the first node, add the point into the first node, and create a circular link back to the first
node. If the first node is not null, I create a new node and add the new point into the new node. Then I use
a do-while loop to calculate the distance between the new node and each existing node in the tour. By comparing
the distances calculated, I insert the new node after the existing node which has the closest distance to the 
new node. 


/**********************************************************************
 *  Explain how you implemented the smallest insertion heuristic.     *
 *  It's sufficient to list only the differences between this         *
 *  heuristic and the nearest insertion heuristic.                    *
 **********************************************************************/

Different from the nearest insertion heuristic, in the do-while loop, I need to insert the new node after 
each existing node and calculate the distance between the previous node and the new node and the distance 
between the following node and the new node. I add these two distances up and get a total. Then I compare
this total distance to the original distance between the previous node and the following node of the new 
node before the insertion. I insert the new node after one existing node when the compared difference is the
smallest among all. In the end of the do, I need to carefully remove the new node and restore the modified tour 
to be the original one. Therefore, the next do will be performed based on the original tour object. 


/**********************************************************************
 *  First, explain why it is better to use a linked list instead of   *
 *  an array. Second, explain what is the advantage of using a        *
 *  *circularly* linked list instead of a normal linked list.         *
 **********************************************************************/

1. A linked list can enforce a circular relationship among its elements, while an array cannot. 
Also, a linked list's size does not need to be initialized, which makes it more flexible than array. 
For example, it is easier to insert elements into linked list than array. 

2. A circular linked list has a fixed size and allows the program to efficiently and repeatedly visit each node 
in the list. It also prevents null node to occur. Here, the traveling sales problem needs a circular linked
list to solve rather than a normal linked list. 



/**********************************************************************
 *  In the table below, fill in the lengths that are computed by the  *
 *  two heuristics (nearest neighbor and smallest increase) that we   *
 *  ask you to implement.                                             *
 **********************************************************************/

data file      nearest neighbor     smallest increase
-----------------------------------------------------
tsp10.txt         1566.1363             1655.7462
tsp100.txt	  7389.9297		4887.2190	
tsp1000.txt	  27868.7106		17265.6282

/**********************************************************************
 *  Do two timing analyses. Estimate the running time (in seconds)    *
 *  of each heuristic as a function of n, using expressions of the    *
 *  form: a * n^b, where b is an integer.                             *
 *                                                                    *
 *  Explain how you determined each of your answers.                  *
 *                                                                    *
 *  To get your data points, run the two heuristics for n = 1,000,    *
 *  and repeatedly double n until the execution time exceeds 60       *
 *  seconds.                                                          *
 *                                                                    *
 *  You may use TSPTimer to help do this, as per the checklist.       *
 *  If you do so, execute it with the -Xint option. This turns off    *
 *  various compiler optimizations, which helps normalize and         *
 *  stabilize the timing data that you collect.                       *
 *                                                                    *
 *  (If n = 1,000 takes over 60 seconds, your code is too slow, and   *
 *  must have a bug)                                                  *
 **********************************************************************/

n            nearest time   log Ratio (b)       smallest time   log Ratio (b)
--------------------------------------------------------------------------------
1000		0.062                   	0.251		
2000		0.203	     1.71	        1.905		2.92
4000		0.751        1.89            	3.922		1.04
8000		2.954        1.98               16.003		2.03
16000		11.704       1.99               60.146		1.91
32000		47.725       2.03               234.784		1.96
64000		224.968      2.24			
...

b is approximately 2. 
Running time = aN ^ 2 for both nearest insertion and smallest insertion. Therefore, The order of growth of time 
is quadratic. InsertNearest and InsertSmallest methods both contain a do-while loop and if-else loop. 
These loops cost time to run and estimate. 

/**********************************************************************
 *  Did you receive help from classmates, past CSCI 121 students, or
 *  anyone else? If so, please list their names.  ("A Sunday lab TA"
 *  or "Office hours on Thursday" is ok if you don't know their name.)
 **********************************************************************/

Yes or no?
Yes. Thursday Professor Office Hour

/**********************************************************************
 *  Did you encounter any serious problems? If so, please describe.
 **********************************************************************/

Yes or no?
No

/***********************************************************************
 ***   Do you attest that this work is your own, in accordance with  ***
 ***   the statement on academic integrity in the syllabus?          ***
 ***********************************************************************/

Yes or no? 
Yes


/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/

