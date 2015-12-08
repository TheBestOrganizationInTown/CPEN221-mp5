package ca.ece.ubc.cpen221.mp5.statlearning;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import ca.ece.ubc.cpen221.mp5.*;

public class LinearRegressionFunctionTest {
	MP5Function featureFunction1 = new PriceScaleFeature();
	@Test
	public void test() {
		
		List<Double> inputs = new ArrayList<Double>();
		inputs.add(1.0);
		inputs.add(2.0);
		inputs.add(3.0);
		List<Double> outputs = new ArrayList<Double>();
		outputs.add(2.0);
		outputs.add(4.0);
		outputs.add(6.0);

		LinearRegressionFunction regression = new LinearRegressionFunction(inputs,outputs,featureFunction1);
		
		assert(regression.getSXX() == 2.0);
		assert(regression.getSYY() == 8.0);
		assert(regression.getSXY() == 4.0);
		
		assert(regression.getA() == 0.0);
		assert(regression.getB() == 2.0);
		assert(regression.getR2() == 1.0);
		
	}
	
	@Test
	public void test2() {
		
		List<Double> inputs = new ArrayList<Double>();
		inputs.add(1.0);
		List<Double> outputs = new ArrayList<Double>();
		outputs.add(2.0);
		
		LinearRegressionFunction regression = new LinearRegressionFunction(inputs,outputs,featureFunction1);
		
		assert(regression.getSXX() == 0);
		assert(regression.getSYY() == 0);
		assert(regression.getSXY() == 0);
		
	}

}
