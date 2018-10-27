package neural.network;

import java.util.Scanner;

public class Algorithm {
	private static double error= -2; 
	private static double input1= 0; 
	private static double input2= 0; 
	private static final double learningRate=.1;
	//private static boolean expected=true;
	public static void main(String[] args) {
		
		Scanner scr= new Scanner(System.in);
		System.out.println("Enter input1:");
		input1= scr.nextDouble();
		System.out.println("Enter input2:");
		input2= scr.nextDouble();
		scr.close();
		recursion(.6,.4);
		
		
		
	}
	
	
	public static void recursion(double w1, double w2){
		if((w1*input1+w2*input2)<0){
			System.out.println("weight1="+w1+"weight2="+w2);
			return;
		}
		w1=w1+(error*w1*input1*learningRate);
		w2=w2+(error*w2*input1*learningRate);
		recursion(w1,w2);
	}
}
