import java.util.Scanner;

public class AndOperation {
	private static Scanner scr;
	public static double threshold = 0.2;
	public static double learningRate = 0.1;
	public static int iterationNumber=1;
	public static void main(String args[])
	{
		scr = new Scanner(System.in);
		
		
		int[][] inputArray = {{0,0},{0,1},{1,0},{1,1}};
		double[] weightArray = new double[2];
		int expectedResult[] = {0,0,0,1};
		
		System.out.println("Enter the weights (AND gate):");
		weightArray[0] = scr.nextDouble();
		weightArray[1] = scr.nextDouble();
		
		int input[] = new int[2];
		
		System.out.println();
		System.out.println("WEIGHTS AND ERROR IN EACH ITERATION:");
		for(int i=0; i<inputArray.length; i++)
		{
			for(int j=0; j<2; j++)
			{
				input[j] = inputArray[i][j];
			}
			changeWeight(input, weightArray, expectedResult[i]);
		}
	
	}
	
	public static int getActualResult(int x[] , double w[])
	{
		double result = 0;
		for(int i = 0; i<x.length; i++)
		{
			result = result + x[i] * w[i];
		}
		if(result>=threshold)
			return 1;
		else
			return 0;
		
	}
	
	
	
	
	
	public static void changeWeight(int[] inputs, double[] weights, int expectedR)
	{
		int actualR = getActualResult(inputs, weights);
		double error = expectedR-actualR;
		if(error==0){
			System.out.println("ITERATION:"+" "+iterationNumber);
			for(int i=0; i<weights.length; i++)
				System.out.println("weight"+""+(i+1)+": "+weights[i]);
			System.out.println("Error: "+error);
			return;
		}	
		System.out.println("ITERATION:"+" "+iterationNumber);
		for(int i=0; i<weights.length; i++)
			System.out.println("weight"+""+(i+1)+": "+weights[i]);
		System.out.println("Error: "+error);
		System.out.println();
		
			
		iterationNumber++;
		for(int i=0; i<inputs.length; i++)
		{
			weights[i] = weights[i] + error * inputs[i] * learningRate;
			weights[i] = Math.round (weights[i] * 10.0) / 10.0;
		
		}
		changeWeight(inputs, weights, expectedR);
		
		
	}
}
