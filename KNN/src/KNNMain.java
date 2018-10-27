import java.io.File;
import java.io.IOException;

public class KNNMain {
	public static void main(String[] args) throws IOException {
		
		 File trainFile= new File("train.txt");
		 File testFile= new File("test.txt");
		 Reader reader= new Reader(trainFile, testFile)	;
		 reader.readTrainFile();
		 reader.readTestFile();
		 KNNClass KNN= new KNNClass(reader);
		 KNN.getTestResults();
		 KNN.checkAccuracy();
		 
	}
}
