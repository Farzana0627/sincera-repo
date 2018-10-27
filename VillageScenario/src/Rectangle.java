public class Rectangle extends Shape{
int x1,x2,x3,x4,y1,y2,y3,y4,height,width;
	
	public Rectangle(int x1,int y1, int height, int width)
	{
		this.x1=x1;
		this.y1=y1;
		
		this.height = height;
		this.width = width;
		
		DrawShape();
	}

	@Override
	public void BuildShape() {
		shapes.add(new Line(x1,y1,x1+width,y1));
		shapes.add(new Line(x1+width,y1,x1+width,y1+height));
		shapes.add(new Line(x1+width,y1+height,x1,y1+height));
		shapes.add(new Line(x1,y1,x1,y1+height));
	}/*private int x1,y1,x2,y2,x3,y3,x4,y4;
	public Rectangle(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4 )
	{
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		this.x3=x3;
		this.y3=y3;
		this.x4=x4;
		this.y4=y4;
	}
	
	public void BuildShape()
	{
		System.out.println(x1+" "+ y1+" "+ x2+" "+ y2);
		System.out.println(x3+" "+ y3+" "+ x4+" "+ y4);
		Line l1= new Line (x1,y1,x2,y2);
		Line l2= new Line (x2,y2,x3,y3);
		Line l3= new Line (x3,y3,x4,y4);
		Line l4= new Line (x4,y4,x1,y1);
		shapes.add(l1);
		shapes.add(l2);
		shapes.add(l3);
		shapes.add(l4);
	}*/
}
