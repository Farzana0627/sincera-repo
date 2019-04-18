package prims.iit.org;

import java.util.ArrayList;
import java.util.List;



public class Node {
	String Name;
    Node Parent;
    int Key;
    List <Node> Neighbours;
	

    public Node(String name){
        Name= name;
        Neighbours=new ArrayList<>();
        Key= 99999;
        Parent=null;
    }
    
   
}