/*import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.Size;
import org.opencv.ml.SVM;
import org.opencv.objdetect.HOGDescriptor;

public class Hog_svm {
public static void main(String[] args) throws IOException {
	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	File file= new File("10_001.jpg");
	BufferedImage bi= ImageIO.read(file);
	
	BufferedImage resizedImage= new BufferedImage(100,100,bi.getType());
    Graphics2D g2d = resizedImage.createGraphics();
    g2d.drawImage(bi, 0, 0, 100, 100, null);
    g2d.dispose();
    
	byte[] pixels = ((DataBufferByte) resizedImage.getRaster().getDataBuffer()).getData();
	Size size= new Size(10, 10); 
	int type= CvType.CV_8UC3;
	Mat imgToProcess= new Mat(100, 100, type);
	imgToProcess.put(0, 0, pixels);
	
	Size ImageSize= new Size(resizedImage.getHeight(), resizedImage.getWidth());
	HOGDescriptor hog=  new HOGDescriptor(ImageSize, size, size, size, 18);
	MatOfFloat descriptors = new MatOfFloat();
    hog.compute(imgToProcess, descriptors);
  //  System.out.print(descriptors.dump());
    
    SVM svm;
    
    descriptors=hog.get_svmDetector();
    
    System.out.println(descriptors);


}
}
*/