import java.util.ArrayList;


public class Tree {
	FileReaderClass f= new FileReaderClass();
	
	public void buildTree( Node root) {
		
		ArrayList<Record> bestLeft= new ArrayList<>();
		ArrayList<Record> bestRight= new ArrayList<>();
		int bestAttribute = -1;
		int bestAttributeValue=-1;
		double bestGain = 0;
		for(int i=0; i<root.getData().size(); i++){
			
		}

		root.setEntropy(Entropy.calculateEntropy(root.getData()));
		//System.out.println(root.getEntropy());
		if(root.getEntropy() == 0) {
			return ;
		}
	//	System.out.println("muna");
		
		for(int i = 0; i < FileReaderClass.numberOfAttributes-1 ; i++) {
			ArrayList<Integer> usedAttributes = new ArrayList<Integer>();
			
			
			double lentropy = 0;
			double rentropy = 0;
			//int index=0;
			for(int j = 0; j <root.getData().size(); j++) {
				if(!isAttributeUsed( usedAttributes, root.getData().get(j).getAttributes().get(i).getValue()))
				{
					
					ArrayList<Double> entropies = new ArrayList<Double>();
					ArrayList<Integer> setSizes = new ArrayList<Integer>();
					usedAttributes.add( root.getData().get(j).getAttributes().get(i).getValue());
					ArrayList<Record> leftsubset = lsubset(root, i, root.getData().get(j).getAttributes().get(i).getValue());
					//System.out.println(leftsubset.get(0));
					ArrayList<Record> rightsubset = rsubset(root, i, root.getData().get(j).getAttributes().get(i).getValue());
					
					setSizes.add(leftsubset.size());
					setSizes.add(rightsubset.size());
					
					if(leftsubset.size() != 0 && rightsubset.size() !=0) {
						lentropy = Entropy.calculateEntropy(leftsubset);
						rentropy = Entropy.calculateEntropy(rightsubset);
						entropies.add(lentropy);
						entropies.add(rentropy);
					
				
					double gain = Entropy.calculateGain(root.getEntropy(), entropies, setSizes, root.getData().size());
				//	System.out.println(gain+" "+i+" "+root.getData().get(j).getAttributes().get(i).getValue());
					if(gain > bestGain) {
						bestAttribute = i;
						bestGain = gain;
						bestAttributeValue= root.getData().get(j).getAttributes().get(i).getValue();
						bestLeft= leftsubset;
						bestRight= rightsubset;
						
					}
					}
					
				
				}
				
			}
	
			
		}
	//	System.out.println(bestAttribute+" "+ bestAttributeValue);
		root.setBestAttribute(bestAttribute);
		root.setBestAttributeValue(bestAttributeValue);
		Node left= new Node();
		left.setData(bestLeft);
		left.setParent(root);
		root.setLeftChild(left);
		Node right= new Node();
		right.setData(bestRight);
		right.setParent(root);
		root.setRighttChild(right);
		
		buildTree(left);
		buildTree(right);
		}
	
		public void printTree(Node root, ArrayList<Attribute> attributes)
		{	
	//		System.out.println(attributes.get(root.getBestAttribute()).getName()+" "+attributes.get(root.getBestAttribute()).getDiscreteAttributes().get(root.getBestAttributeValue()).getName());
			if(root.leftChild!=null)
				printTree(root.leftChild, attributes);
			if(root.rightChild!=null)
				printTree(root.rightChild, attributes);			
		}
		
		public void print(Node root){
			if(root.leftChild!=null)
				print(root.leftChild);
			if(root.leftChild==null && root.rightChild==null){
				System.out.println(root.getData().size());
				for(int i=0; i<root.getData().size(); i++)
				{
					
					System.out.println(root.getData().get(i).getAttributes().get(4).getName());
				}
			}
			if(root.rightChild!=null)
				print(root.rightChild);
		}
		
		
		
		public ArrayList<Record> lsubset(Node root, int attr, int value) {
			ArrayList<Record> subset = new ArrayList<Record>();
			
			for(int i = 0; i < root.getData().size(); i++) {
				Record record = root.getData().get(i);
				
				if(record.getAttributes().get(attr).getValue() <= value) {
					subset.add(record);
				}
			}
			return subset;
		}
		
		public ArrayList<Record> rsubset(Node root, int attr, int value) {
			ArrayList<Record> subset = new ArrayList<Record>();
			
			for(int i = 0; i < root.getData().size(); i++) {
				Record record = root.getData().get(i);
				
				if(record.getAttributes().get(attr).getValue() > value) {
					subset.add(record);
				}
			}
			return subset;
		}
		
		public ArrayList<Record> subset(Node root, int attr, int value) {
			ArrayList<Record> subset = new ArrayList<Record>();
			
			for(int i = 0; i < root.getData().size(); i++) {
				Record record = root.getData().get(i);
				
				if(record.getAttributes().get(attr).getValue() == value) {
					subset.add(record);
				}
			}
			return subset;
		}
		
		public boolean isAttributeUsed(ArrayList<Integer> used, int attribute) {
			if(used.contains(attribute)) {
				return true;
			}
			else {
				return false;
			}
		}
		
		
		public void Search(Node root, Record testRecord){
			if(root.leftChild==null && root.rightChild==null){
				System.out.println(root.getData().get(0).getAttributes().get(4).getName());
				return;
			}
			if(testRecord.getAttributes().get(root.getBestAttribute()).getValue()<=root.getBestAttributeValue())
			{
				Search(root.leftChild,testRecord);
				
			}
			else Search(root.rightChild,testRecord);
				
		
			
		}
		
		
}
