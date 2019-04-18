package prims.iit.org;



public class Edge {
	Node node1, node2;
	int weight=0;
	public Edge(Node n1, Node n2)  {

		// TODO Auto-generated constructor stub
	
		node1=n1;
		node2=n2;
	
	}
	public void setEdgeWeight(int w) {
		weight=w;
		
	}
	
	
	
	
}
