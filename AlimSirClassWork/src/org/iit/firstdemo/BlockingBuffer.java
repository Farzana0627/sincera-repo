package org.iit.firstdemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BlockingBuffer implements Buffer {

        final ArrayBlockingQueue b ;
        
        public  BlockingBuffer() {
                b = new ArrayBlockingQueue<Integer>(1);
        }
        
        @Override
        public void write(int a) {
                try {
                        b.put(a);
                } catch (InterruptedException ex) {
                        Logger.getLogger(BlockingBuffer.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        @Override
        public int read() {
                
                int value = 0;
                try {
                        value = (int) b.take();
                } catch (InterruptedException ex) {
                        Logger.getLogger(BlockingBuffer.class.getName()).log(Level.SEVERE, null, ex);
                }
                return value;
        }
        
        
}