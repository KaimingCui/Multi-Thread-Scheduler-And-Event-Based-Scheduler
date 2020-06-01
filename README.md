# multiThreadScheduler

## Objective

This project requires me to implments a multi-threads scheduler to gain hands-on experience creating, throttling, and evaluating a scheduler.For this project I read in a data file “FloridaCounties.csv” which contains about 75,000 records. And treat each record as a task to be scheduled. 

There are two types of scheduler I implemented. One is thread-per-request scheduler another is a scheduler based on event and event listener.

I also analyze the latency and throughput of various schedulers.

## What the project will do

### Client
To simulate multiple clients I preload the data from FloridaCounties.csv into a single client. The client must store the client data in a single data structure in which each record is stored as a single string variable (i.e. perhaps an array or linked list of strings). I am not allowed to preprocess the data into its constituent parts. However I need to read the first record from the string, which for simulation purposes contains a “wait” number. This number ranges from 0 to 5 and represents the number of seconds I should wait before attempting to pass the next job to the scheduler. Note: Many jobs have wait time of 0. In this case (to simplify the problem) I must just pass the jobs consecutively with no deliberate wait time.

The client must run on its own thread throughout the entire simulation. I should not start up the simulation until the client object is loaded i.e. all records are read in and stored.

The client is responsible for passing the entire string to the scheduler. Each such request is called a ‘job’.

### Server

The webserver processes data for house sales in Florida counties. As this is a simulation, the tasks are deliberately “made up”. You can imagine that in practice these tasks would perform useful services;

Before discussing the scheduler, I will describe each of the tasks to be completed for EACH job. The tasks are dependent upon the data in the comma delimited housing string. The field names for attributes in this string are as follows:



