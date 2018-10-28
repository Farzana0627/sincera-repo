package collage.iit.org;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Collage {
		public static void main(String[] args) throws IOException {
			
			String fileName="/home/muna/Desktop/muna1.jpg";
			ImageReader inputImage1= new ImageReader(fileName);
			fileName= "/home/muna/Desktop/muna2.jpg";
			ImageReader inputImage2= new ImageReader(fileName);
			fileName="/home/muna/Desktop/muna3.jpg";
			ImageReader inputImage3= new ImageReader(fileName);
			fileName= "/home/muna/Desktop/muna4.jpg";
			ImageReader inputImage4= new ImageReader(fileName);
			System.out.println(""+ inputImage1.type	);
			
			
			ImageBlender blendedImage= new ImageBlender();
			try{
				BufferedImage bi= blendedImage.blendImages(inputImage1, inputImage2);
			
				File outputFile= new File("saved.png");
				ImageIO.write(bi, "jpg", outputFile);
			}
			catch(IOException e){}
			/*	/*
			System.out.println(""+ inputImage3.type	);
			SkinDetector skinDetector= new SkinDetector();
			BufferedImage newImage= skinDetector.getImposedPicture(inputImage1, inputImage2);
			File outputFile= new File("saved.png");
			ImageIO.write(newImage, "png", outputFile);*/
			
		/*	try{
			ImageOverlapper image= new ImageOverlapper();
			BufferedImage bi= image.OverLapperMethod(inputImage1, inputImage2);
			File outputFile= new File("saved.png");
			ImageIO.write (bi, "png", outputFile);
			}catch(IOException e){}
		
			try{
				ImageOverlapper image= new ImageOverlapper();
				BufferedImage bi=image.getBorderedImage(inputImage1);
			File outputFile= new File("saved.png");
			ImageIO.write (bi, "png", outputFile);
			}catch(IOException e){}
				*/
		}
		
}
