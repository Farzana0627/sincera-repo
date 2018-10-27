package org.iit.firstdemo;

public class UnsynchronizedBuffer implements Buffer {
        
        private int value = -1;
        
        @Override
        public void write(int a) {
                value = a;
               
        }

        @Override
        public int read() {
                return value;
        }
        
}