package org.iit.firstdemo;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleArray {
        
        final int[] a ;
        int writeIndex = 0;
       static final Random r = new Random();
        
        public SimpleArray(int size) {
                a = new int[size];
        }
        
        public synchronized void add(int value) {
                
                int position = writeIndex;
                
                try {
                        Thread.sleep(r.nextInt(500));
                } catch (InterruptedException ex) {
                        Logger.getLogger(SimpleArray.class.getName()).log(Level.SEVERE, null, ex);
                }
                a[position]=value;
                
                System.out.println(Thread.currentThread().getName()+" wrote "+ value +" in position "+ (writeIndex));
                
                System.out.println("Next write position "+writeIndex);
                
                writeIndex++;
                
        }
        
        /**
         *
         * @return
         */
        @Override
        public  String toString() {
                
                return  "Content Of Array: "+Arrays.toString(a);
        }

}