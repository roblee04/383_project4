import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;


public class Main { 

    // Customer Structure
    static class Job {
        String pid; // char in hexadecimal
        int size; // 5, 11, 17 or 31 Mb
        int service_time; // random num between 1 - 5
        int arrival_time; // not sure
        Job next; // the next job to be worked on

        Job(String pid, int size, int service_time, int arrival_time) {
            this.pid = pid; // name in hexidecimal, ex. FF, 2A, 33, encapsulate 150 jobs range
            this.size = size;
            this.service_time = service_time;
            this.arrival_time = arrival_time;
        }

        public int getArrival() {
		return this.arrival_time;
	}
    }

    public static void main(String[] args) {
        ArrayList<Job> job_list = new ArrayList<Job>();

        long seed = (System.currentTimeMillis());
        int num_jobs = 150;
        System.out.println(seed);

        job_list = generate_jobs(num_jobs, seed);
        graph(job_list);
        // for(int i = 0; i < num_jobs; i++) {
        //     System.out.println(job_list.get(i).pid + " service: " + job_list.get(i).service_time);
        // }

    }

    // System.currentTimeMillis() to generate random numbers
    public static ArrayList<Job> generate_jobs(int num_jobs, long seed) {

        ArrayList<Job> job_list = new ArrayList<Job>();
        Random generator = new Random(seed);

        int[] sizes = {5, 11, 17, 31};

        int count = 0;
        // add all jobs to the array list
        for (int i = 0; i < num_jobs; i++) {

            // hexadecimal pid logic
            String pid = Integer.toHexString(i);
            if (i < 16) {
                // add zero to the front
                pid = "0" + pid;
            }
            // generating random other things
            int size = sizes[(generator.nextInt(4))];
            int service_time = generator.nextInt(1, 6);
            int arrival_time = generator.nextInt(100); // how long?
            Job new_job = new Job(pid, size, service_time, arrival_time);
            job_list.add(new_job);
        }
        // want to sort by arrival time, not correct
        Collections.sort(job_list, Comparator.comparing(Job::getArrival));
        
        return job_list;

        // make one new job / node
    } 

    public static void graph(ArrayList<Job> job_list) {

        String header = "PID | ";
        for(int i = 0; i < 101; i++) {
            if( ((double)i%10) == 0) {
                header += String.valueOf(i/10);
            }
            else {
                header += "-";
            }
        }
        System.out.println(header);

        for(Job j : job_list) {
            // System.out.println("pid: " + j.pid); 

            String out = "";
            for(int i = 0; i < j.arrival_time; i++) {
                out += " ";
            }
            for(int i = 0; i < j.service_time; i++) {
                out += "_";
            }

            // System.out.println("pid: " + j.pid + " | size: " + j.size + " | serv: " + j.service_time + " | arr: " + j.arrival_time);
            System.out.println(" " +j.pid + " | " + out);
        }
        System.out.println("\n" + job_list.size() + " jobs");
    }

}