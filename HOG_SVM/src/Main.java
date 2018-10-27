/*import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.Size;
import org.opencv.core.TermCriteria;
import org.opencv.ml.CvSVM;
import org.opencv.ml.CvSVMParams;

import org.opencv.objdetect.HOGDescriptor;

public class Main {
	public static void main(String[] args) throws IOException {
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat train_data = new Mat(0, 100 * 100, CvType.CV_32FC1);
	//	Mat trainingImages = new Mat(0, 100 * 100, CvType.CV_32FC1);
		List<Integer> trainingLabels = new ArrayList<>();
		String[] arrayofclasses= new File("H://Workspace//HOG_SVM//Taka").list();
		int i=0, j=0;
		
		for(i=0; i<arrayofclasses.length; i++){
			String classname= "H://Workspace//HOG_SVM//Taka//"+arrayofclasses[i];
			String[] arrayoffiles= new File(classname).list();
			
			
			for(j=0; j< arrayoffiles.length; j++){
				
				trainingLabels.add(i);
				String inputfilename="H://Workspace//HOG_SVM//Taka//"+arrayofclasses[i]+"//"+arrayoffiles[j];
				File file= new File(inputfilename);
				BufferedImage bi= ImageIO.read(file);
				
				BufferedImage resizedImage= new BufferedImage(100,100,bi.getType());
			    Graphics2D g2d = resizedImage.createGraphics();
			    g2d.drawImage(bi, 0, 0, 100, 100, null);
			    g2d.dispose();
			    
				byte[] pixels = ((DataBufferByte) resizedImage.getRaster().getDataBuffer()).getData();
				int type= CvType.CV_8UC3;
				Size ImageSize= new Size(resizedImage.getHeight(), resizedImage.getWidth());
				Mat imgToProcess= new Mat(100,100,type);
				System.out.println(imgToProcess.size().height+" "+imgToProcess.size().width);
				imgToProcess.put(0, 0, pixels);			
				
				Size size= new Size(10, 10); 
				
				HOGDescriptor hog=  new HOGDescriptor(ImageSize, size, size, size, 36);
				MatOfFloat descriptors = new MatOfFloat();
			    hog.compute(imgToProcess, descriptors);
			    
				try
				{
				    String filename= "myfile1.txt";
				    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
				    BufferedWriter bw= new BufferedWriter(fw);
				    
			
				   fw.write(i+" ");
				   Mat MatOfDescriptors= new Mat(descriptors.size(), CvType.CV_32FC1);
				   descriptors.convertTo(MatOfDescriptors, CvType.CV_32FC1);
				   train_data.push_back(MatOfDescriptors);
				   List<Float> list= new ArrayList<>();
				   list= descriptors.toList();
				   for(int k=0; k<list.size(); k++ ){
				    	
				    		bw.write((k+1)+":"+Math.sqrt(list.get(k))+" ");
				    }	
				    bw.newLine();
				    bw.close();
				}
				catch(IOException ioe)
				{
				    System.err.println("IOException: " + ioe.getMessage());
				}
			}
		}
		
		/* 	Integer[] array = trainingLabels.toArray(new Integer[trainingLabels.size()]);
		 	Mat labels = new Mat(trainingLabels.size(), 1, CvType.CV_32SC1);
		    int[] trainLabels = new int[array.length];
		    for (int h = 0; h < array.length; h++) {
		        trainLabels[h] = array[h];
		    }

		    for (int h = 0; h < trainingLabels.size(); h++) {
		        labels.put(h, 1, trainLabels[h]);
		    }
		    
			CvSVMParams params = new CvSVMParams();
		    params.set_svm_type(CvSVM.C_SVC);
		    params.set_kernel_type(CvSVM.LINEAR);
		    params.set_gamma(0.1);
		    params.set_C(1);
		    Size data = train_data.size();
		    Size label = labels.size();


		    CvSVM svmClassifier = new CvSVM();
		    svmClassifier.train(train_data, labels, new Mat(), new Mat(), params);
		    svmClassifier.save("test.xml");
		    
		SVM svm= SVM.create();
		Mat response_data= new Mat(train_data.size(), CvType.CV_32FC1);
		svm.train(train_data, 100, response_data);
/*		svm.predict(train_data);*/


