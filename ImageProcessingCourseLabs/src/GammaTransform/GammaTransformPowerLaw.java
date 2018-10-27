package GammaTransform;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GammaTransformPowerLaw {
	public static BufferedImage bi;
	public static double gamma=2.5;
	public static double c=1;
		
	public static void main(String[] args) throws IOException {
		File file= new File("gammaorg.png");
		bi= ImageIO.read(file);
		gammaTransMethod();
		ImageIO.write(bi, "png", new File("gammapow.png"));
	}
		
		//Make the gamma transformation
		public static void gammaTransMethod() throws IOException{
			
			for(int i = 0; i <bi.getHeight(); i++){
				for (int j = 0; j < bi.getWidth(); j++) {
					Color color= new Color(bi.getRGB(i, j));
					int blue = (int)(c*(255*Math.pow(color.getBlue()/255.0, gamma)));
					int green = (int)(c*(255*Math.pow(color.getGreen()/255.0, gamma)));
					int red = (int)(c*(255*Math.pow(color.getRed()/255.0, gamma)));
					color= new Color(red, green, blue);
					bi.setRGB(i, j,color.getRGB());
					
				}
			}
		}
	}


