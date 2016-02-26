package UserInterFace;

import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import features.Bilateral;
import features.Blur;
import features.Brightness;
import features.CartoonFilter;
import features.ColorReduction;
import features.Contrast;
import features.Dilation;
import features.EdgeDetector;
import features.Erosion;
import features.GammaTransform;
import features.GaussianFilter;
import features.GlassFilter;
import features.Greyscale;
import features.HSV;
import features.MedianFilter;
import features.MirrorImage;
import features.OilPaint;
import features.PencilSketch;
import features.PhotoNegative;
import features.Posterization;
import features.Sepia;
import features.Sharpen;
import features.SobelEdgeDetector;
import features.Solarize;
import features.Swirl;
import features.Warhol;

public class GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	File file;
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 860);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JLabel lblInput = new JLabel("Input");
		lblInput.setBounds(58, 12, 216, 216);
		frame.getContentPane().add(lblInput);
		
		final JLabel lblOutput = new JLabel("Output");
		lblOutput.setBounds(321, 12, 216, 216);
		frame.getContentPane().add(lblOutput);
		
		final JFileChooser fileDialog = new JFileChooser();
		JButton showFileDialogButton = new JButton("Open File");
		showFileDialogButton.setSize(108, 40);
		showFileDialogButton.setLocation(58, 229);
		showFileDialogButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            int returnVal = fileDialog.showOpenDialog(frame);
	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	                file = fileDialog.getSelectedFile();
	                try {
	                	
						BufferedImage img = ImageIO.read(file);
						BufferedImage resized = resizedIcon(img, lblInput.getWidth(), lblInput.getHeight());
						lblInput.setIcon(new ImageIcon(resized));
						frame.getContentPane().add(lblInput);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
	            
	           
	         }
	      });
		
		frame.getContentPane().add(showFileDialogButton);
		
		JButton btnBilateral = new JButton("Bilateral");
		btnBilateral.setBounds(581, 49, 142, 25);
		frame.getContentPane().add(btnBilateral);
		
		JButton btnBlur = new JButton("Blur");
		btnBlur.setBounds(581, 87, 142, 25);
		frame.getContentPane().add(btnBlur);
		
		JButton btnBrightness = new JButton("Brightness");
		btnBrightness.setBounds(581, 125, 142, 25);
		frame.getContentPane().add(btnBrightness);
		
		JButton btnCartoon = new JButton("Cartoon Filter");
		btnCartoon.setBounds(581, 163, 142, 25);
		frame.getContentPane().add(btnCartoon);
				
		JButton btnColorReduction = new JButton("Color Reduction");
		btnColorReduction.setBounds(581, 201, 142, 25);
		frame.getContentPane().add( btnColorReduction);
		
		JButton btnContrast = new JButton("Contrast");
		btnContrast.setBounds(581, 239, 142, 25);
		frame.getContentPane().add(btnContrast);
		
		JButton btnDilation = new JButton("Dilation");
		btnDilation.setBounds(581, 277, 142, 25);
		frame.getContentPane().add(btnDilation);
		
		JButton btnHorizontalEdge = new JButton("Horizontal Edge");
		btnHorizontalEdge.setBounds(581, 315, 142, 25);
		frame.getContentPane().add(btnHorizontalEdge);
		
		JButton btnVerticalEdge = new JButton("Vertical Edge");
		btnVerticalEdge.setBounds(581, 353, 142, 25);
		frame.getContentPane().add(btnVerticalEdge);
		
		JButton btnErosion= new JButton("Erosion");
		btnErosion.setBounds(581, 391,142, 25);
		frame.getContentPane().add(btnErosion);
		
		JButton btnGammaTransform = new JButton("Gamma Transform");
		btnGammaTransform.setBounds(581, 429, 142, 25);
		frame.getContentPane().add(btnGammaTransform);
		
		JButton btnGaussian = new JButton("Gaussian");
		btnGaussian.setBounds(581, 467, 142, 25);
		frame.getContentPane().add(btnGaussian );
		
		JButton btnGlass = new JButton("Glass Filter");
		btnGlass.setBounds(581, 505, 142, 25);
		frame.getContentPane().add(btnGlass);
		
		JButton btnGreyScale = new JButton("Grey Scale");
		btnGreyScale.setBounds(581, 543,142, 25);
		frame.getContentPane().add(btnGreyScale);
		
		JButton btnHSV = new JButton("HSV");
		 btnHSV.setBounds(751, 49, 142, 25);
		frame.getContentPane().add( btnHSV );	
			
		JButton btnVerticalFlip = new JButton("Vertical Flip");
		btnVerticalFlip.setBounds(751,87, 142, 25);
		frame.getContentPane().add(btnVerticalFlip);
		
		JButton btnHorizontalFlip = new JButton("Horizontal Flip");
		btnHorizontalFlip.setBounds(751,125,142, 25);
		frame.getContentPane().add(btnHorizontalFlip);
		
		JButton btnOil = new JButton("Oil Paint");
		btnOil.setBounds(751, 163,142, 25);
		frame.getContentPane().add(btnOil);
		
		JButton btnSketch = new JButton("Pencil Sketch");
		btnSketch.setBounds(751, 201, 142, 25);
		frame.getContentPane().add(btnSketch);
		
		JButton btnNegative = new JButton("Negative");
		btnNegative.setBounds(751, 239, 142, 25);
		frame.getContentPane().add(btnNegative);

		JButton btnPosterization = new JButton("Posterization");
		btnPosterization.setBounds(751, 277, 142, 25);
		frame.getContentPane().add(btnPosterization);
		

		JButton btnMedian = new JButton("Median");
		btnMedian.setBounds(751, 315,142, 25);
		frame.getContentPane().add(btnMedian);
		
		JButton btnSepia = new JButton("Sepia");
		btnSepia.setBounds(751, 353, 142, 25);
		frame.getContentPane().add(btnSepia);
		
		
		JButton btnSharpen = new JButton("Sharpen");
		btnSharpen.setBounds(751, 391,142, 25);
		frame.getContentPane().add(btnSharpen);
		
		JButton btnSobel = new JButton("Sobel");
		btnSobel.setBounds(751,429, 142, 25);
		frame.getContentPane().add(btnSobel);

		JButton btnSolarize = new JButton("Solarize");
		btnSolarize.setBounds(751, 467, 142, 25);
		frame.getContentPane().add(btnSolarize);

		JButton btnSwirl = new JButton("Swirl");
		btnSwirl.setBounds(751, 505, 142, 25);
		frame.getContentPane().add(btnSwirl);

		JButton btnWarhol = new JButton("Warhol");
		btnWarhol.setBounds(751, 543, 142, 25);
		frame.getContentPane().add(btnWarhol);
		
		
		
		
		
		
		//posteraization actiojnh listener
		btnBilateral.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Bilateral image = new Bilateral(file);
				
				
					image.BilateralMethod();
					
					File file2 = new File("output.bmp");
					
					BufferedImage img = ImageIO.read(file2);
					BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
					lblOutput.setIcon(new ImageIcon(resized));
					frame.getContentPane().add(lblOutput);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	
		btnBlur.addActionListener(new ActionListener() {
		
		@Override
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				try {
					Blur image = new Blur(file);
				
					String str = JOptionPane.showInputDialog("Input blur type: soft:1 strong;2 motion:3");
					int type = Integer.parseInt(str);
					if(type==1)
					image.SoftBlur();
					else if(type==2)
						image.StrongBlur();
					else if(type==3)
						image.MotionBlur();
					else JOptionPane.showInputDialog("Wrong input!! Try again!!");
					
					File file2 = new File("output.bmp");
				
					BufferedImage img = ImageIO.read(file2);
					BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
					lblOutput.setIcon(new ImageIcon(resized));
					frame.getContentPane().add(lblOutput);
				
				} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			}
		});
	
		btnBrightness.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				Brightness image = new Brightness(file);
				String str = JOptionPane.showInputDialog("Input mod value (1-100)");
				int modVal = Integer.parseInt(str);
				image.brighten(modVal);	
				File file2 = new File("output.bmp");
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	
	btnCartoon.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				CartoonFilter image = new CartoonFilter(file);
				image.cartoon();
				
				File file2 = new File("output.bmp");
				
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	
	btnColorReduction.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				ColorReduction image = new ColorReduction(file);
				File file2 = new File("output.bmp");
				
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	
	btnContrast.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				Contrast image = new Contrast(file);
				String str = JOptionPane.showInputDialog("Input mod value (-128 to +128)");
				int modVal = Integer.parseInt(str);
				image.contrastCorrection(modVal);
				File file2 = new File("output.bmp");
				
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	
	
	btnDilation.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				Dilation image = new Dilation(file);
				String str = JOptionPane.showInputDialog("Input mod value (-128 to +128)");
				int modVal = Integer.parseInt(str);
				File file2 = new File("output.bmp");
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	
	btnHorizontalEdge.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				EdgeDetector image = new EdgeDetector(file);
				image.getHorizontalEdges();
				File file2 = new File("output.bmp");
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	
	btnVerticalEdge.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				EdgeDetector image = new EdgeDetector(file);
				image.getVerticalEdges();
				File file2 = new File("output.bmp");
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	
	btnErosion.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				Erosion image = new Erosion(file);
				File file2 = new File("output.bmp");
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	
	btnGammaTransform.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				GammaTransform image = new GammaTransform(file);
				File file2 = new File("output.bmp");
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	
	btnGaussian.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				GaussianFilter image = new GaussianFilter(file);
				File file2 = new File("output.bmp");
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	
	btnGlass.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				GlassFilter image = new GlassFilter(file);
				String str= JOptionPane.showInputDialog("Enter percent: (1-100)");
				int percent= Integer.parseInt(str);
				image.glassFilter(percent);
				File file2 = new File("output.bmp");
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	btnGreyScale.addActionListener(new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				Greyscale image = new Greyscale(file);
				
				File file2 = new File("output.bmp");
				
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
			
				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}					
		}		
	});
	
	btnHSV.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				HSV image = new HSV(file);	
				File file2 = new File("output.bmp");
				
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
			
				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}	
		}
	});
	
	btnVerticalFlip.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				MirrorImage image = new MirrorImage(file);
				image.getVerticalMirrorImage();
				File file2 = new File("output.bmp");
				
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
			
				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}	
		}	
	});
	
	btnHorizontalFlip.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				MirrorImage image = new MirrorImage(file);
				image.getHorizontalMirrorImage();
				File file2 = new File("output.bmp");
				
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
			
				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}	
		}
	});
	
	btnOil.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				OilPaint image = new OilPaint(file);
				File file2 = new File("output.bmp");
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
			
				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}	
	});
	btnSketch.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				PencilSketch postar = new PencilSketch(file);			
				File file2 = new File("output.bmp");
				
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
		
		//negative ActionListener
	btnNegative.addActionListener(new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				PhotoNegative neg = new PhotoNegative(file);
				File file2 = new File("output.bmp");
					
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
					
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
		
	btnPosterization.addActionListener(new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				Posterization image = new Posterization(file);
				String str= JOptionPane.showInputDialog("Enter mod value: (1-100)");
				int modValue= Integer.parseInt(str);
				image.Posterize(modValue);
				File file2 = new File("output.bmp");
				
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
					
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	
	btnMedian.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				MedianFilter image = new MedianFilter(file);
				File file2 = new File("output.bmp");
				
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	//listener for sepia
	btnSepia.addActionListener(new ActionListener() {
			
			@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Sepia sepia = new Sepia(file);
					
				File file2 = new File("output.bmp");
					
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
		
		
	btnSharpen.addActionListener(new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Sharpen image = new Sharpen(file);
				String str = JOptionPane.showInputDialog("Normal Sharpening: 1 Subtle sharp: 2 Edged Sharp:3");
				int type = Integer.parseInt(str);
				if(type==1){
					image.SharpeningMethod();
				}
				else if(type==2){
					image.subtleSharp();
				}
				else image.EdgedSharpen();
					
				File file2 = new File("output.bmp");
					
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
		//btnGreyScale actionlistener
		
		
	btnSobel.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
				
			try {
				SobelEdgeDetector image = new SobelEdgeDetector(file);
				File file2 = new File("output.bmp");
					
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
				
					
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
				
		}		
				
	});
			
	btnSolarize.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
				
			try {
				Solarize image = new Solarize(file);
				String bstr = JOptionPane.showInputDialog("Blue threshold: (0-255)");
				int bthreshold = Integer.parseInt(bstr);
				String gstr = JOptionPane.showInputDialog("Green threshold: (0-255)");
				int gthreshold = Integer.parseInt(gstr);
				String rstr = JOptionPane.showInputDialog("Red threshold: (0-255)");
				int rthreshold = Integer.parseInt(rstr);
				image.solarizeMethod(bthreshold, gthreshold, rthreshold);
				File file2 = new File("output.bmp");
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
					
						
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
					
		}		
					
	});
			
	btnSwirl.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
						
			try {
				Swirl image = new Swirl(file);
		
				File file2 = new File("output.bmp");
							
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
						
							
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}		
						
	});
					
	btnWarhol.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
							
			try {
				Warhol image = new Warhol(file);
				String str = JOptionPane.showInputDialog("Enter the mod value: (1-255)");
				int modValue = Integer.parseInt(str);
				image.WarholEffect(modValue);
				File file2 = new File("output.bmp");
								
				BufferedImage img = ImageIO.read(file2);
				BufferedImage resized = resizedIcon(img, lblOutput.getWidth(), lblOutput.getHeight());
				lblOutput.setIcon(new ImageIcon(resized));
				frame.getContentPane().add(lblOutput);
							
								
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
							
		}		
							
	});
					
	}
	
	public BufferedImage resizedIcon (BufferedImage buffer, int w, int h) {
		BufferedImage resized = new BufferedImage(w, h, buffer.getType());
		
		Graphics2D g = resized.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
			    RenderingHints.VALUE_INTERPOLATION_BILINEAR); 
		g.drawImage(buffer, 0, 0, w, h, 0, 0, buffer.getWidth(), buffer.getWidth(),null);
		g.dispose();
		return resized;
	}
}
