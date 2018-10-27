import java.awt.Graphics;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class Main  extends JFrame {
	public static Graphics G;
	
	public Main(){
		setTitle("Canvas");
		setSize(900, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@SuppressWarnings("unused")
	public void paint(Graphics g)
	{
		 G=g;
		 	House h1 = new House(100, 100, 100, 100);
			House h2 = new House(700,400,100,150);
			House h3 = new House(750,150,50,70);
			House h4 = new House(450, 400, 100,150);
			
			
			Tree t1 = new Tree(45, 80, 120);
			Tree t2 = new Tree(255, 80, 120);
			Tree t3 = new Tree(700, 110, 90);
			Tree t4 = new Tree(650, 400, 100);
			Tree t5 = new Tree(850, 150, 50);
		//	Tree t6 = new Tree(720, 110, 90);
			//Tree t7 = new Tree(400, 350, 150);
			
			
			//River r2 = new River(0, 500, 600, 0,100, 600, 700, 0);
			//r2.DrawShape();
			River r = new River();
			
		


	}
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Main object = new Main();
		
		
	}
}
