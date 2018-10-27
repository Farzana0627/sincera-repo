

public class Tree extends Shape{
		int x,y,height;
	
	public Tree(int x, int y,int height)
	{
		this.x = x;
		this.y = y;
		this.height = height;
		
		DrawShape();
	}
	
	@Override
	public void BuildShape() 
	{
		shapes.add(new Line(x, y, x, y+height));
		shapes.add(new Line(x-(height/4), y+(height/4), x+(height/4), y-(height/4)));
		shapes.add(new Line(x+(height/4), y+(height/4), x-(height/4), y-(height/4)));
		shapes.add(new Line(x, y, x, y-(height/3)));
		shapes.add(new Line(x-(height/4), y, x+(height/4), y));
		
	}/*private Rectangle trunk;
	private Leaves lf;
	private boolean finished;

	private int x1,y1,x2,y2,x3,y3,x4,y4,x5,y5,x6,y6,x7,y7,x8,y8;
	public Tree(int x1,int y1,int x2, int y2,int x3,int y3,int x4,int y4,int x5,int y5,int x6, int y6,int x7,int y7,int x8,int y8 )
	{
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		this.x3=x3;
		this.y3=y3;
		this.x4=x4;
		this.y4=y4;
		this.x5=x5;
		this.x5=x5;
		this.y6=y6;
		this.y6=y6;
		this.x7=x7;
		this.y7=y7;
		this.x8=x8;
		this.y8=y8;
	
	}
	
	public void BuildShape()
	{
		
		lf= new Leaves(x1,y1,x2,y2,x3,y3,x4,y4);
		trunk= new Rectangle(x5, y5, x6, y6, x7, y7, x8, y8);
		shapes.add(trunk);
		shapes.add(lf);
		
	}*/
}
