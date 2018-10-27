/*
import java.util.Scanner;

public class NeuralNet {
	private static Scanner sc;

	public static void main(String args[])
	{
		sc = new Scanner(System.in);
		double[] inputArray = new double[2];
		double[] weightArray = new double[2];
		inputArray[0] = 10;
		weightArray[0] = .4;
		inputArray[1] = 9;
		weightArray[1] = .6;
		int expectedResult = -1;
		
		
		double [] finalWeights = manipulateWeight(inputArray, weightArray, expectedResult);
		
		
		printWeights(finalWeights);
		
	
	}
	
	public static int getActualResult(double x[] , double w[])
	{
		double result = 0;
		for(int i = 0; i<x.length; i++)
		{
			result = result + x[i] * w[i];
		}
		if(result<0)
			return -1;
		else
			return 1;
		
	}

	
	public static double[] manipulateWeight(double[] inputs, double[] weights, int expectedR)
	{
		int actualR = getActualResult(inputs, weights);
		double err = err(expectedR, actualR);
		double learningRate = 0.01;
		if(err==0)
		{
			
			return weights;
		}
		else{
			for(int i=0; i<inputs.length; i++)
			{
				weights[i] = weights[i] + err * inputs[i] * learningRate;
			}
			manipulateWeight(inputs, weights, expectedR);
		}
		
		return weights;
		
	}
	
	public static double err(double expected, double actual)
	{
		return expected-actual;
	}

	public static void printWeights(double [] w) {
		for(int i = 0; i<w.length; i++)
		{
			System.out.println(w[i] + ",");
		}
		System.out.print("are the weights for minimized error.");
	}
}
*/