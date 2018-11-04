package BestFirstSearchNew;
import java.util.ArrayList;

public class Node
{
	String name;
	Node parent;
	boolean isVisited;
	int heuristic;
	ArrayList<Integer> adjacentCost;
	ArrayList<Node> adjacentList;
	
	public Node(String name, int heuristic)
	{
		this.name = name;
		this.heuristic = heuristic;
		this.isVisited = false;
		adjacentList = new ArrayList<>();
		adjacentCost = new ArrayList<>();
	}
	
	public void AddAdjacent(Node node, int cost)
	{
		this.adjacentList.add(node);
		this.adjacentCost.add(cost);
	}
}