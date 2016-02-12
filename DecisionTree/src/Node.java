import java.util.ArrayList;


public class Node {
	private Node parent;
	public Node leftChild;
	public Node rightChild;
	private ArrayList<Record> data;
	private double entropy;
	private int bestAttribute;
	private int bestAttributeValue;

	

	public Node() {
		this.data = new ArrayList<Record>();
		setEntropy(0.0);
		setParent(null);
		setLeftChild(null);
		setRighttChild(null);

		
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getParent() {
		return parent;
	}
	public void setBestAttribute(int attr) {
		this.bestAttribute = attr;
	}

	public int getBestAttribute() {
		return this.bestAttribute;
	}
	
	public void setBestAttributeValue(int attrVal) {
		this.bestAttributeValue = attrVal;
	}

	public int getBestAttributeValue() {
		return this.bestAttributeValue;
	}


	public void setData(ArrayList<Record> data) {
		this.data = data;
	}

	public ArrayList<Record> getData() {
		return data;
	}

	public void setEntropy(double entropy) {
		this.entropy = entropy;
	}

	public double getEntropy() {
		return entropy;
	}

	public void setLeftChild(Node child) {
		this.leftChild = child;
	}

	public void setRighttChild(Node child) {
		this.rightChild = child;
	}
	public Node getLeftChild() {
		return this.leftChild;
	}

	public Node getRighttChild() {
		return this.rightChild;
	}



}
