package org.iit.firstdemo;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Consumer implements Runnable {
        
        final Buffer sharedLocation;
        final Random r = new Random();
        
        public Consumer(Buffer a) {
                
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
                        
                        int value = sharedLocation.read();
                        System.out.printf("\tc read %d",value);
                        sum +=value;
                        System.out.printf("\tc sum %d\n",sum);
                }
                
                System.out.println("\nConsumer had done reading ");
        }     
}