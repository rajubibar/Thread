
package com.java.cisco.myapp.mutex;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Mutex extends Thread {
    private static int j = 0;
    private static final Semaphore mutex = new Semaphore(1, true);

    @Override
    public void run() {
        try {
            while (!mutex.tryAcquire(100, TimeUnit.MILLISECONDS)) {
                System.out.println("Thread waiting.");
            }
        }
        catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
            return;
        }

        try {
            for (int i = 1; i <= 10; i++) { // Start of Critical section
                j += i;                     //

            }
            System.out.println(j);       // End of Critical section
            // Should add on 55 to j if one thread is running through the CS
        }
        finally {
            mutex.release(); // Thread that has finished the CS sets the mutex to 0.
        }
    }
}