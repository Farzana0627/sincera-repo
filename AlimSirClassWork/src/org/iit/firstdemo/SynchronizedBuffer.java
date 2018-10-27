package org.iit.firstdemo;


import java.util.logging.Level;
import java.util.logging.Logger;
import org.iit.firstdemo.Buffer;

public class SynchronizedBuffer implements Buffer {
        
        private int buffer = -1; // shared by producer and consumer threads 
        private boolean occupied = false; // whether the buffer is occupied 

        /**
         *
         * @param value
         */
        @Override
        public synchronized void write(int value) {
                
                while( occupied) {
                        
                        //System.out.println( "Producer tries to write." );
                        //displayState( "Buffer full. Producer waits." ); 
                        try {
                                wait();
                        } catch (InterruptedException ex) {
                                Logger.getLogger(SynchronizedBuffer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
                buffer = value;
                
                occupied = true;
                
                displayState( "Producer writes " + buffer ); 
                
                notifyAll(); // tell waiting thread(s) to enter runnable state
        }

        @Override
        public synchronized int read() {
                
                while( !occupied) {
                        
                        //System.out.println( "Consumer tries to read." );
                        //displayState( "Buffer empty. Consumer waits." );
                        try {
                                wait();
                        } catch (InterruptedException ex) {
                                Logger.getLogger(SynchronizedBuffer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
                
                occupied = false;
                
                displayState( "Consumer reads " + buffer ); 
                
                notifyAll();
                
                return  buffer;
                
        }
        
         public void displayState( String operation ) {
                 
                 System.out.printf( "%-40s%d\t\t%b\n\n", operation, buffer, occupied ); 
         }

        
        
        
}