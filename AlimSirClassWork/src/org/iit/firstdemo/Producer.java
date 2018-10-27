package org.iit.firstdemo;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer implements Runnable {
        
        final Buffer sharedLocation;
        final Random r = new Random();
        
        public Producer(Buffer a) {
                
                sharedLocation = a;
        }

        @Override
        public void run() {     
               
                int sum = 0;
                for(int i=1; i<10; i++) {
                        
                        try {
                                Thread.sleep(r.nextInt(3000));
                        } catch (InterruptedException ex) {
                                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        sharedLocation.write(i);
                        System.out.printf("\tp write %d ",i);
                        sum +=i;
                        System.out.printf("\tp sum %d \n",sum);
                }
                
                System.out.println("\nProducer had done producing ");
        }     
}