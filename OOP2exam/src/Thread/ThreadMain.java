package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadMain {
	public static void main(String[] args) {
        
        Buffer Numbers = new Storage();
        
        Counter c = new Counter(Numbers);
        
        Printer p = new Printer(Numbers);
        
        System.out.println("\t Stored \t Printed\n");
        
        ExecutorService e = Executors.newCachedThreadPool();
        e.execute(c);
        e.execute(p);
}

}
