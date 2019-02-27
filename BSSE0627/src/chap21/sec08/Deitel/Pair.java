package chap21.sec08.Deitel;

public class Pair<F,S> {
	F first;
	S second;
	
	F getFirst()
	{
		return first;
	}
	void setFirst(F data)
	{
		first=data;
	}
	S getSecond()
	{
		return second;
	}
	void setSecond(S data)
	{
		second=data;
	}
	
}
