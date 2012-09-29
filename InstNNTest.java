package neuralNet;
import java.io.IOException;
import java.util.Scanner;


import org.jblas.DoubleMatrix;

/*
* Tests the neural network and trains it with a given dataset
*/


public class InstNNTest
{

	/*
	 * Args are text files with one matrix in each file of format:
	 * Line between rows
	 * space between columns
	 */
	public static void main(String[] args)
	{
		
		try
		{
			Scanner inputScanner = new Scanner(System.in);
			DoubleMatrix X = NeuralNetwork.getFromTextFile(args[0]);	//Get training input data from a file
			DoubleMatrix Y = NeuralNetwork.getFromTextFile(args[1]);	//Get training output data from a file
			
			int[] topology = {400,30,33,10};	
			double lambda = 0.905343;
			
			NeuralNetwork digitReader = new NeuralNetwork(topology,true);	//Create the neural network! randomly generate theta elements
			while (true)
			{	
				System.out.print("How many iterations? ");
				int iters = inputScanner.nextInt();
				if (iters >0)
				{
					digitReader.trainBP(X, Y, lambda, iters,true); //Train the nerual network
					double accuracy = NeuralNetwork.computeAccuracy(digitReader.predictFP(X), Y); //find the accuracy
					System.out.println("Accuracy: "+accuracy);
					
				}
				else
					break;
			}
			inputScanner.close();

			
		} catch (NumberFormatException | IOException e)
		{
			e.printStackTrace();
		}
	}

}
