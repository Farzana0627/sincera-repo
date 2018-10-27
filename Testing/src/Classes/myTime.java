package Classes;

public class myTime {
	public int hour, min, second;
	public myTime(int hour, int min, int second)
	{
		this.hour= hour;
		this.min=min;
		this.second= second;
	}
	public String toString()
	{
		StringBuilder sb= new StringBuilder();
		sb.append(hour+":"+ min+ ":"+ second);
		return sb.toString();
		
	}
}
