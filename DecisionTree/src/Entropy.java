import java.util.ArrayList;

public class Entropy {
	public static double calculateEntropy(ArrayList<Record> data) {
		double entropy = 0;
		
		if(data.size() == 0) {
			// nothing to do
			return 0;
		}
		int NoOfAttributes=data.get(0).getAttributes().size();
	
		for(int i = 0; i < FileReaderClass.decisionValues; i++) {
			int count = 0;
			for(int j = 0; j < data.size(); j++) {
				Record record = data.get(j);
				//System.out.println(record.getAttributes().get(4).getValue());
				//if(i==0)System.out.println(record.getAttributes().get(4).getName()+""+record.getAttributes().get(4).getValue());
				if(record.getAttributes().get(NoOfAttributes-1).getValue() == i) {
					count++;
				}
				
			}
			//System.out.println(count);
			
			double probability = count / (double)data.size();
		//	if(count==data.size() || count==0) return 0;
			if(count > 0) {
				entropy += -probability * (Math.log(probability) / Math.log(2));
			}
			
		}
		
		return entropy;
	}
	
	public static double calculateGain(double rootEntropy, ArrayList<Double> subEntropies, ArrayList<Integer> setSizes, int data) {
		double gain = rootEntropy; 
		
		for(int i = 0; i < subEntropies.size(); i++) {
			gain += -((setSizes.get(i) / (double)data) * subEntropies.get(i));
		}
		
		return gain;
	}
}
