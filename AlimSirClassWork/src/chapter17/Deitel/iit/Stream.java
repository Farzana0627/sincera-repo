package chapter17.Deitel.iit;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Stream {
	public static void main(String[] args) throws FileNotFoundException {
		System.setOut(new PrintStream(new FileOutputStream(new File("test/abc.txt")) ));
		
	// "/" indicates root in linux . "drive character:\\ "- root in windows
		
		System.out.println("muna");// prints in file
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out) ));
		System.out.println("muna");// prints in console
		
	}
}
