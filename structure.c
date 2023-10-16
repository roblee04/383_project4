
I was thinking of breaking down this project into a 3 components:

    1. Workload
    2. Simulator
    3. Algorithms


Workload
    - Similar to proj2 / scheduling generate_jobs(), 
    but we have to return an ordered linked list of jobs

    struct node {
        // details of one job, job is equivalent to node
        int pid; // int or char?, maybe in hex?
        int size; // 5, 11, 17 or 31 Mb
        int service_time; // random num between 1 - 5
        int arrival_time; // not sure
        node next = null; // the next job to be worked on

    }

    generate_jobs()
    - return an LL of jobs ordered by arrival_time
    - use the same seeds for all Algorithms

    logic 
    - generate new jobs into an array 
    - sort array by arrival_time
    - Make head / dummy node, insert all nodes from the ordered array
    - return head 

    graph()
    - graph arrival_time and service_time to make sure there are many overlapping areas / contention
    - try to import functionality from proj2

Simulator
    - essentially what the main class should do
    - run for 100 page references

    Linked_List = generate_jobs(); // store LL
    graph(Linked_List);            // contention check

    paging_algorithm(Linked_List) // paging_algorithm can be generic name for FIFO, LRU, LFU, MFU, randompick
    output()                      // output results if not already outputted


Algorithms
    - use the same 5 seeds 
    - always generate 150 jobs


    Locality of Reference
    - basically, every 100 msec, a random page at index IDX is looked up in disk
        - lookup time is 100 msec
    - pages IDX, IDX - 1, and IDX + 1 are stored in cache memory, 
        - lookup time is 0 msec?

    - maybe can be represented as set, to deal with duplicates

    - generate  <time-stamp in seconds, process Name, page-referenced, Page-in-memory, which process/page number will be evicted if needed>

    

