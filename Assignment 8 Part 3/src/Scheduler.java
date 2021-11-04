// Starter file for Assignment 8 (CIS 2168, Fall 21).

import java.io.*;
import java.util.*;

public class Scheduler {
    private int n;              // number of workers (threads)
    private int[] jobDurations;

    private int[] assignedWorker;  // assignedWorker[i]: which worker is assigned to job i?
    private long[] startTime;      // startTime[i]: when will job i begin?

    // Constructor: initializes this Scheduler from a local filename
    public Scheduler(String filename) {
        try {
            Scanner scanner = new Scanner(new FileInputStream(new File(filename)));
            n = scanner.nextInt();      // number of workers (threads)
            int m = scanner.nextInt();  // number of jobs
            jobDurations = new int[m];
            for (int i = 0; i < m; ++i)
                jobDurations[i] = scanner.nextInt();  // read job duration data
        }
        catch (IOException ioe) { throw new IllegalArgumentException("Could not open " + filename, ioe); }
    }

    // Assign jobs to workers (threads).
    // (assignedWorker[i] gets job i; startTime[i] is when the i-th job starts)
    private void assign() {
        assignedWorker = new int[jobDurations.length];
        startTime = new long[jobDurations.length];
        long[] readyTime = new long[n];
        PriorityQueue<Worker> pq = new PriorityQueue<>();

        // Create a PQ of workers
        for(int i=0; i<n; i++) {
            pq.offer(new Worker(i, 0));
        }

        // For each job, extract the worker, update the worker[i]'s info, and offer it back to the PQ
        for(int i=0; i<jobDurations.length; i++) {
            Worker worker = pq.poll();
            long duration = jobDurations[i];
            assignedWorker[i] = worker.index;
            startTime[i] = worker.readyTime;
            pq.offer(new Worker(assignedWorker[i], worker.readyTime + duration));
        }
    }

    public static void main(String[] args){
        Scheduler scheduler = new Scheduler("test1.txt");
        scheduler.assign();

        assert scheduler.startTime.length == scheduler.assignedWorker.length;
        for (int i = 0; i < scheduler.startTime.length; i++)
            System.out.println("Assigned Worker: " + scheduler.assignedWorker[i] + " " + "Start Time: " + scheduler.startTime[i]);
    }

    /****** Code below this line is not used in the above solution ******/
    // private helper class (you may delete this nested class if you have no use for it)
    private class Worker implements Comparable<Worker> {
        int index;       // worker identifier (thread index)
        long readyTime;  // when the worker is available to process a job
        private Worker (int index, long readyTime) { this.index = index; this.readyTime = readyTime; }
        public int compareTo(Worker that) {
            if (this.readyTime < that.readyTime) return -1;
            if (this.readyTime > that.readyTime) return +1;
            return this.index - that.index; // if ready at the same time, prefer lower index
        }
    }
}
