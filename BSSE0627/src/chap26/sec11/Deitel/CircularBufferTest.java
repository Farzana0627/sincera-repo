package chap26.sec11.Deitel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CircularBufferTest {

	public static void main(String[] args) {
	
		CircularBuffer cb  = new CircularBuffer();
		
		producer p = new producer(cb);
		
		consumer c = new consumer(cb);
		
		cb.displayState("Initial");
		ExecutorService e = Executors.newCachedThreadPool();
		
		e.execute(p);
		e.execute(c);
		
		e.shutdown();
		
		
		

	}

}
