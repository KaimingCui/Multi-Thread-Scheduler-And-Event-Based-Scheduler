# Multi-Thread-Scheduler and Event-based-Scheduler

## Objective

This project requires me to implments a multi-threads scheduler to gain hands-on experience creating, throttling, and evaluating a scheduler.For this project I read in a data file “FloridaCounties.csv” which contains about 75,000 records. And treat each record as a task to be scheduled. 

There are two types of scheduler I implemented. One is thread-per-request scheduler that uses parallel techs. Another is a scheduler based on event and event listener.

I also analyze the latency and throughput of various schedulers.

## What the project will do

### Client
To simulate multiple clients I preload the data from FloridaCounties.csv into a single client. The client must store the client data in a single data structure in which each record is stored as a single string variable (i.e. perhaps an array or linked list of strings). I am not allowed to preprocess the data into its constituent parts. However I need to read the first record from the string, which for simulation purposes contains a “wait” number. This number ranges from 0 to 5 and represents the number of seconds I should wait before attempting to pass the next job to the scheduler. Note: Many jobs have wait time of 0. In this case (to simplify the problem) I must just pass the jobs consecutively with no deliberate wait time.

The client must run on its own thread throughout the entire simulation. I should not start up the simulation until the client object is loaded i.e. all records are read in and stored.

The client is responsible for passing the entire string to the scheduler. Each such request is called a ‘job’.

### Server

The webserver processes data for house sales in Florida counties. As this is a simulation, the tasks are deliberately “made up”. You can imagine that in practice these tasks would perform useful services;

Before discussing the scheduler, I will describe each of the tasks to be completed for EACH job. The tasks are dependent upon the data in the comma delimited housing string. The field names for attributes in this string are as follows:

![GitHub](https://github.com/KaimingCui/multiThreadScheduler/blob/master/1.png)

It doesn’t actually matter whether you understand the meaning of each field, because our tasks are deliberately rather contrived.

In general, you will need one or more agents to perform each task type. Note: I’m using the term agent loosely – you could think of this as a service with multiple threads, a static function, a runtime agent etc etc etc, however you want to set up the task. You should think about concurrency issues though in designing your solution. The scheduler will be responsible for making sure each task gets completed.

### Task 1: Object Creation

Create an object from the record. Remember that there are multiple ways to create an object. Please think about this carefully. Task 1 has the following steps:
1. Take the house string as input, parse and tokenize it (or however you want to do this)
2. Create an object that contains all of the attributes extracted from the job string.
3. Provide getters for any fields you’ll need to access – as per requirements in other tasks.

### Task 2: Stateless Counter (pretty useless actually!)

1. Take a house object as input.
2. Count from 0 to eq_site_limit
3. Count from 0 to fl_site_limit
4. Count from 0 to hu_site_limit
5. Count from 0 to fl_site_limit
6. Return nothing

### Task 3: Vicinity Computer


1. Compute the distance from point 30.0000 Latitude and -81.0000 Longitude to the coordinates of the house depicted in fields point_latitude and point_longitude (think Pythagorus).
2. Return nothing

### Task 4: Tally by Type (stateful)
1. Simulate access to a persistent data store by use of a shared data structure. To simulate remote database accesses add 1 second of wait time to each update.
2. Tally by type i.e. increment counter for each type i.e. Residence:Wood or Residence:Masonry (found in fields “line” and “construction”).
3. Think BASE, i.e. basicallyavailable, soft state, eventually consistent.
4. At the end of the simulation PRINT the contents of this data structure to a file or screen.

### Task 5: Register expensive houses

1. If eq_site_license >= 800,000 simulate registering the house with a remote service.
2. In lieu of registration details – wait 10 seconds.

## Scheduler

### Scheduler # 1: Simple thread-per-request scheduler. multi thread.

Requirements:

1. As each job arrives the scheduler (using one thread per request) will ensure all tasks are completed for each job.
2. Tasks are completed in different orders depending on the point_granularity (PG) field as follows:

PG=1: T1, T2, T3, T4, T5

PG=2: T1, T3, T4, T5, T2

PG=3: T1, T5, T4, T3, T2 

PG=4: T1, T4, T2, T5, T3 

PG=5: T1, T2, T5, T3, T4 

PG=7: T1, T3, T2, T5, T4 (There are no jobs for PG=6)

#### Explain my program

Scheduler uses Executor thread pool. (Here I use fixed thread pool because I know how many threads in the pool is proper for this project)

The Starter has the main function which is the entrance of whole program. Client and Scheduler work in their own thread,they are Asynchronous.Everytime the scheduler receive a request from cilent, it will create a record (Record class represents data structure from the csv file) and then send the record to a Job thread that is created by thread pool and run it. One Job thread is responsible for one request. The job thread will create Tasks object and call its function. Here, Job thread will call tasks function in different orders based on the field PG of record.

### Scheduler #2: Event Based scheduler using design patterns

Starter Class has main function, it is the entrance of the program. 
Client and Scheduler work in their own threads, they are Asynchronous. 
Client read csv file and send the rows one by one. 
Scheduler receive request from cilent and then create a string that contains one row from csv file. 
Scheduler then uses event source to generate a event with flag "NewEvent" and the string received from the client.
event listener notices the event and catch the event. Listener will decide what is the next state for this event (run task 1 or 2 or ...). Listener call cooresponding state function to finish task. 
After the task is finished, it will generate new event with flag that represents next state.
Listener catch the new event again and then do same work. 





