package org.iit.firstdemo;

public class ArrayWriter implements Runnable{
        
        final SimpleArray array;
        final int startValue;
        
        public  ArrayWriter(SimpleArray array, int startValue) {
                
                this.array =array;
                this.startValue = startValue;
        }

        @Override
        public void run() {
                
                for(int i=startValue; i< startValue+3; i++)
                {
                        array.add(i);
                }
                
        }
        
      
}
        
        
        
       
        
