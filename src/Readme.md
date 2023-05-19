# Rate Limiter
### Problem Statement
Create a rate limiter program using a sliding window which allows/blocks request based on
timestamps. Program will receive sequence of timestamps via arguments. For each timestamp it has
to output allowed/blocked based on the sliding window.
Sliding window to have 2 configurations,

R: maximum number of requests allowed in sliding window\
S: sliding window time period in seconds

### Example
Let's consider R = 2 and S = 5. This means that a maximum of 2 requests are allowed within the previous 5 seconds.

Given a sequence of timestamps: 1, 2, 4, 5, 6, 7, 8, 9, we can analyze each timestamp:

- Timestamp 1: It is allowed because there are no previous requests within the sliding window. The sliding window is empty: [].
- Timestamp 2: It is allowed because there is only one previous request within the sliding window (timestamp 1). The sliding window contains [1].
- Timestamp 4: It is blocked because there are already two requests within the sliding window (timestamps 1 and 2). The sliding window contains [1, 2].
- Timestamp 5: It is blocked for the same reason as the previous timestamp. The sliding window still contains [1, 2].
- Timestamp 6: It is blocked because there are already two requests within the sliding window (timestamps 4 and 5). The sliding window still contains [1, 2].
- Timestamp 7: It is allowed because there is only one previous request within the sliding window (timestamp 6). The sliding window contains [2].
- Timestamp 8: It is allowed because there is only one previous request within the sliding window (timestamp 7). The sliding window contains [7].
- Timestamp 9: It is blocked because there are already two requests within the sliding window (timestamps 7 and 8). The sliding window contains [7, 8].

The program should provide the output "allowed" or "blocked" for each timestamp, based on the sliding window's configuration and the number of requests within the given time period.

### Solution Explanation

**Language** : JAVA

**Version**: Java Version "18.0.2"

A function is defined findRateLimit which intakes three parameters timeStampSequence as Array, maximumNumberOfRequests as Integer and slidingWindowPeriod as Integer. 
An integer variable is named as index to check whether the element will be present in the sliding window or not. A for each loop is used to iterate through the elements 
of the timeStampsSequence array. An if-else condition is used check if the index is less than the maximumNumberOfRequests, than the number can be allowed to the sliding window
and printed as "Allowed" or else it blocked from the sliding window and output is printed as "Blocked". Each time of the for each loop the index is updated by 1 and an if condition
is checked whenever the index is equals to the slidingWindowPeriod it will be equal to zero.

**Pseudo Code**

Start\
  getInput maxmimumNumberOfRequests\
  getInput slidingWindowPeriod\
  getInput timeStampSequence\
  index = 0\
  loop timeStamp in timeStampSequence:\
    if index == slidingWindowPeriod\
        i = 0\
    if index < maximumNumberOfRequests\
        print timeStamp "Allowed"\
    else\
        print timeStamp "Allowed"\
  index = index + 1\
End



### Test Cases

**Test Case 1:**

2\
5\
1 2 4 5 6 7 8 9\
1 Allowed\
2 Allowed\
4 Blocked\
5 Blocked\
6 Blocked\
7 Allowed\
8 Allowed\
9 Blocked

**Test Case 2:**

1\
10\
1 2 3 5 7 9 13 46 78 56\
1 Allowed\
2 Blocked\
3 Blocked\
5 Blocked\
7 Blocked\
9 Blocked\
13 Blocked\
46 Blocked\
78 Blocked\
56 Blocked

**Test Case 3:**

0\
1\
1 7 9 21 30 45 48 51\
1 Blocked\
7 Blocked\
9 Blocked\
21 Blocked\
30 Blocked\
45 Blocked\
48 Blocked\
51 Blocked

**Test Case 4:**

5\
1\
1 8 16 20 35 40 41 42 45\
1 Allowed\
8 Allowed\
16 Allowed\
20 Allowed\
35 Allowed\
40 Allowed\
41 Allowed\
42 Allowed\
45 Allowed

**Test Case 5 :**

4\
8\
1 12 13 42 50 56 57 68 69 70 123\
1 Allowed\
12 Allowed\
13 Allowed\
42 Allowed\
50 Blocked\
56 Blocked\
57 Blocked\
68 Blocked\
69 Allowed\
70 Allowed\
123 Allowed




