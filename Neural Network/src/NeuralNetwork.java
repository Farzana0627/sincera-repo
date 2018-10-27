/*
public class NeuralNetwork {
	private static double input1=0.0;
	private static double input2=0.0;
	private static double actual_result=0.0;
	private static double weight1=0.3;
	private static double weight2=-0.1;
	private static double threshold=0.2;
	private static double learningRate=0.1;
	//private static double[] expected={0.0,0.0,0,1.0};
	public static void main(String[] args) {
		
		
		printResult();
		
	}
	
	
	public static double getActualResult(){
		if(input1==0.0 && input2==0.0) actual_result=0.0;
		else if(input1==0.0 && input2==1.0) actual_result=0.0;
		else if(input1==1.0 && input2==0.0) actual_result=0.0;
		else actual_result=1.0;
		return actual_result;
	}
	
	public static void printResult() {
		input1=0.0;
		input2=0.0;
		System.out.println(""+ recursion(weight1,weight2));
		input1=0.0;
		input2=1.0;
		System.out.println(""+ recursion(weight1,weight2));
		input1=1.0;
		input2=0.0;
		System.out.println(""+ recursion(weight1,weight2));
		input1=1.0;
		input2=1.0;
		System.out.println(""+ recursion(weight1,weight2));
	}
	
	public static double recursion(double w1, double w2){
		double actual_result= getActualResult();
		double output=input1*w1+input2*w2;
		if(output<threshold){
			weight1=w1;
			weight2=w2;
			System.out.println("Weight1: "+weight1+" Weight2: "+weight2);
		
			return actual_result;
		}
		double error= actual_result-output;
		w1=Math.round((w1+ input1*error*learningRate)*10)/10;
		w2=Math.round((w2+ input2*error*learningRate)*10)/10;
		return recursion(w1,w2);
	}
}
*/