package neuralNet;

import org.jblas.DoubleMatrix;


public interface CostFunction 
{

	  /**
	   *  Returns a Tuple with first element the Cost, and the second element the Gradients of given input matrix
	   */
	  public Tuple<Double, DoubleMatrix> evaluateCost(DoubleMatrix input);

}

