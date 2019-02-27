package collage.iit.org;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

import javax.imageio.ImageIO;

public class Collage {
		public static void main(String[] args) throws IOException {
			String fileName="/home/muna/Desktop/muna1.jpg";
			File imgPath= new File (fileName);
			BufferedImage image1= ImageIO.read(imgPath);
			fileName= "/home/muna/Desktop/muna2.jpg";
			imgPath= new File (fileName);
			BufferedImage image2= ImageIO.read(imgPath);
			//fileName= "/home/muna/Desktop/muna3.png";
			imgPath= new File (fileName);
			BufferedImage image3= ImageIO.read(imgPath);
			//fileName= "/home/muna/Desktop/muna4.png";
			imgPath= new File (fileName);
			BufferedImage image4= ImageIO.read(imgPath);
			//fileName= "/home/muna/Desktop/muna5.png";
			imgPath= new File (fileName);
			BufferedImage image5= ImageIO.read(imgPath);
			
			CollageOperator Operator= new CollageOperator();
			
			
			try{
				//BufferedImage newImage= Operator.getBorderedImage(image4);
				double transparencyLimit=40;
				BufferedImage newImage= Operator.fullBlend(image2, image1,transparencyLimit);
			//	BufferedImage newImage= Operator.getCenteredImage(image1, image2, image3, image4, image5);
			//	BufferedImage newImage= Operator.blendFourImages(image1, image2, image3, image4);
			
				
			//	BufferedImage newImage = Operator.blendTwoImages(image1, image2);
				File outputFile= new File("saved.png");
				ImageIO.write(newImage, "png", outputFile);
			}
			catch(IOException e){}
		}

}