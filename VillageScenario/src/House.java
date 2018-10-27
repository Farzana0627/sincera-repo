
public class House extends Shape{
int x1,y1,x2,y2,x3,y3,x4,y4,height,width;
	
	public House (int x1,int y1, int height, int width) {
		
		this.x1=x1;
		this.y1=y1;
		
		this.height = height;
		this.width = width;
		
		DrawShape();
		
	}

	@Override
	public void BuildShape() 
	{
		shapes.add(new Rectangle(x1,y1,height,width));
		shapes.add(new Rectangle(x1+width/3,y1+height/3,(height/3)*2,(width/3)));
		shapes.add(new Line(x1+width/3+(width/3)/2, y1+height/3,x1+width/3+(width/3)/2, y1+height));
		shapes.add(new Triangle(x1-25, y1, x1+25+width, y1, x1+width/2, y1-50));
		
	}/*private Rectangle r1,r2;
	private Triangle t;
	private int x1,y1,x2,y2,x3,y3,x4,y4,x5,y5,x6,y6,x7,y7,x8,y8, x9,y9;
	public House(int x1,int y1,int x2, int y2,int x3,int y3,int x4,int y4,int x5,int y5,int x6, int y6,int x7,int y7,int x8,int y8, int x9, int y9 )
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
		this.x9=x9;
		this.y9=y9;
	
	}
	
	public void BuildShape()
	{
		t=new Triangle(x1, y1, x2, y2, x3, y3);
		r1= new Rectangle(x2, y2, x3, y3, x4, y4, x5, y5);
		r2= new Rectangle(x6, y6, x7, y7, x8, y8, x9, y9);
		shapes.add(t);
		shapes.add(r1);
		shapes.add(r2);
	}*/
}
