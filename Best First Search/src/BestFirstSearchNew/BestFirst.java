package BestFirstSearchNew;

import java.util.ArrayList;
import java.util.Stack;

public class BestFirst
{
	public static void main(String[] args)
	{
		
		Node A = new Node("A", 366);
		Node B = new Node("B", 0);
		Node C = new Node("C", 160);
		Node D = new Node("D", 242);
		Node E = new Node("E", 161);
		Node F = new Node("F", 176);
		Node G = new Node("G", 77);
		Node H = new Node("H", 151);
		Node I = new Node("I", 266);
		Node L = new Node("L", 244);
		Node M = new Node("M", 241);
		Node N = new Node("N", 234);
		Node O = new Node("O", 380);
		Node P = new Node("P", 100);
		Node R = new Node("R", 193);
		Node S = new Node("S", 253);
		Node T = new Node("T", 329);
		Node U = new Node("U", 80);
		Node V = new Node("V", 199);
		Node Z = new Node("Z", 374);
		
		A.AddAdjacent(S, 140);
		A.AddAdjacent(Z, 75);
		A.AddAdjacent(T, 118);
		
		B.AddAdjacent(F, 211);
		B.AddAdjacent(G, 90);
		B.AddAdjacent(P, 101);
		B.AddAdjacent(U, 85);
		
		C.AddAdjacent(D, 120);
		C.AddAdjacent(P, 138);
		C.AddAdjacent(R, 146);
		
		D.AddAdjacent(C, 120);
		D.AddAdjacent(M, 75);
		
		E.AddAdjacent(H, 86);
		
		F.AddAdjacent(B, 211);
		F.AddAdjacent(S, 99);
		
		G.AddAdjacent(B, 90);
		
		H.AddAdjacent(E, 86);
		H.AddAdjacent(U, 98);
		
		I.AddAdjacent(N, 87);
		I.AddAdjacent(V, 92);
		
		L.AddAdjacent(M, 70);
		L.AddAdjacent(T, 111);
		
		M.AddAdjacent(L, 70);
		M.AddAdjacent(D, 75);
		
		N.AddAdjacent(I, 87);
		
		O.AddAdjacent(S, 151);
		O.AddAdjacent(Z, 71);
		
		P.AddAdjacent(B, 101);
		P.AddAdjacent(C, 138);
		P.AddAdjacent(R, 97);
		
		R.AddAdjacent(C, 146);
		R.AddAdjacent(P, 97);
		R.AddAdjacent(S, 80);
		
		S.AddAdjacent(A, 140);
		S.AddAdjacent(F, 99);
		S.AddAdjacent(O, 151);
		S.AddAdjacent(R, 80);
		
		T.AddAdjacent(A, 118);
		T.AddAdjacent(L, 111);
		
		U.AddAdjacent(B, 85);
		U.AddAdjacent(H, 98);
		U.AddAdjacent(V, 142);
		
		V.AddAdjacent(I, 92);
		V.AddAdjacent(U, 142);
		
		Z.AddAdjacent(A, 75);
		Z.AddAdjacent(O, 71);
		
	
		Stack<Node> path = new Stack<>();
		ArrayList<Node> unChecked = new ArrayList<>();
		Node start = A;
		start.parent = null;
		start.isVisited = true;
	
		unChecked.add(start);
		
		while(unChecked.size() > 0)
		{
			for(int i=0; i<start.adjacentList.size(); i++)
			{
				if(!start.adjacentList.get(i).isVisited)
				{
					start.adjacentList.get(i).parent = start;
					unChecked.add(start.adjacentList.get(i));
				
				}
			}
			unChecked.remove(start);
			
			start = BestFirst.cheapestFinder(unChecked);
	
			start.isVisited = true;
			if(start.heuristic == 0)
				break;
		}
		
		path.add(start);
		
		while(start.parent != null)
		{
			start = start.parent;
			path.add(start);
		}
		System.out.println("Best First Search:");
		while(!path.isEmpty()) System.out.print(path.pop().name+"\t");
		
	}
	
	public static Node cheapestFinder(ArrayList<Node> nodes)
	{
		Node cheapest = nodes.get(0);
		if(nodes.size() == 1)
			return nodes.get(0);
		
		for(int i=1; i<nodes.size(); i++)
		{
			if(nodes.get(i).heuristic < cheapest.heuristic)
			{
				cheapest = nodes.get(i);
			}
		}
		
		return cheapest;
	}
}