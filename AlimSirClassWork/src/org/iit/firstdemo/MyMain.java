package org.iit.firstdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyMain {
        
        public static void main(String[] args) {
                
                
                //Buffer b = new UnsynchronizedBuffer();
                //Buffer b =new BlockingBuffer();
                Buffer b = new SynchronizedBuffer();
                
                Producer p = new Producer(b);
                
                Consumer c = new Consumer(b);
                
                System.out.println("\t value \t sum \t read \t sum\n");
                
                ExecutorService e = Executors.newCachedThreadPool();
                e.execute(p);
                e.execute(c);
        }
        
}