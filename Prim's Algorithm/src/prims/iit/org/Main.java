package prims.iit.org;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Prims p= new Prims();
		p.MST();
		Kruskal k= new Kruskal();
		k.MST();
	}
}
