package ca.ece.ubc.cpen221.mp5.statlearning;

import ca.ece.ubc.cpen221.mp5.Restaurant;
import ca.ece.ubc.cpen221.mp5.RestaurantDB;
import java.util.*;

public class LinearRegressionFunction implements MP5Function {

    private final double Sxx;
    private final double Syy;
    private final double Sxy;

    private final double b;
    private final double a;
    private final double r_squared;

    private final double xMean;
    private final double yMean;

    private final MP5Function featureFunction;

    /**
     * Constructs a linear regression based on inputs, outputs and given
     * feature.
     * 
     * @param inputs
     * @param outputs
     * @param featureFunction
     */
    public LinearRegressionFunction(List<Double> inputs, List<Double> outputs, MP5Function featureFunction) {
        this.Sxx = sValueXXYY(inputs);
        this.Syy = sValueXXYY(outputs);
        this.Sxy = sValueXY(inputs, outputs);

        this.b = this.Sxy / this.Sxx;
        this.a = getMean(outputs) - this.b * getMean(inputs);
        this.r_squared = this.Sxy * this.Sxy / (this.Sxx * this.Syy);

        this.xMean = getMean(inputs);
        this.yMean = getMean(outputs);

        this.featureFunction = featureFunction;

    }

    /**
     * Returns the value of Sxy
     * 
     * @param inputs
     * @param outputs
     * @return double
     */
    private static Double sValueXY(List<Double> inputs, List<Double> outputs) {
        double distance;
        double xMean = getMean(inputs);
        double yMean = getMean(outputs);
        List<Double> inputCopy = new ArrayList<Double>(inputs);
        List<Double> outputCopy = new ArrayList<Double>(outputs);

        for (int i = 0; i < inputs.size(); i++)
            inputCopy.set(i, inputs.get(i) - xMean);

        for (int i = 0; i < inputs.size(); i++)
            outputCopy.set(i, outputs.get(i) - yMean);

        outputCopy = multiplyArray(inputCopy, outputCopy);
        distance = arraySummation(outputCopy);

        return new Double(distance);
    }

    /**
     * Returns the value of Sxx or Syy
     * 
     * @param inputs
     * @return Double
     */
    private static Double sValueXXYY(List<Double> inputs) {
        double distance;
        double Mean = getMean(inputs);
        List<Double> inputCopy = new ArrayList<Double>(inputs);

        for (int i = 0; i < inputs.size(); i++)
            inputCopy.set(i, inputs.get(i) - Mean);
        inputCopy = multiplyArray(inputCopy, inputCopy);
        distance = arraySummation(inputCopy);

        return new Double(distance);
    }

    /**
     * Returns the average of the values within the array
     * 
     * @param array
     * @return Double
     */
    private static Double getMean(List<Double> array) {
        double mean;
        double numberOfValues = array.size();
        double arraySum = arraySummation(array);

        mean = arraySum / numberOfValues;

        return new Double(mean);
    }

    /**
     * Returns an array with values arrayC[n] = arrayA[n]*arrayB[n]; where n
     * goes from 0 to arrayA.size().
     * 
     * @requires arrayA.size() == arrayB.size()
     * @param arrayA
     * @param arrayB
     * @return List<Double>
     */
    private static List<Double> multiplyArray(List<Double> arrayA, List<Double> arrayB) {
        List<Double> multipliedArray = new LinkedList<Double>();
        double multipliedValue;
        assert(arrayA.size() == arrayB.size());

        for (int i = 0; i < arrayA.size(); i++) {
            multipliedValue = arrayA.get(i) * arrayB.get(i);
            multipliedArray.add(multipliedValue);
        }

        return multipliedArray;
    }

    /**
     * Returns the sum of all numbers in given array
     * 
     * @param array
     * @return double
     */
    private static double arraySummation(List<Double> array) {
        double sum = 0;
        for (int i = 0; i < array.size(); i++)
            sum += array.get(i);
        return new Double(sum);
    }

    /**
     * Returns R2
     * 
     * @return double
     */
    public double getR2() {
        return new Double(this.r_squared);
    }

    /**
     * Returns Sxx
     * 
     * @return double
     */
    public double getSXX() {
        return new Double(this.Sxx);
    }

    /**
     * Returns Sxx
     * 
     * @return double
     */
    public double getSYY() {
        return new Double(this.Syy);
    }

    /**
     * Returns Sxx
     * 
     * @return double
     */
    public double getSXY() {
        return new Double(this.Sxy);
    }

    /**
     * Returns Sxx
     * 
     * @return double
     */
    public double getA() {
        return new Double(this.a);
    }

    /**
     * Returns Sxx
     * 
     * @return double
     */
    public double getB() {
        return new Double(this.b);
    }

    /**
     * Returns feature given
     * 
     * @return MP5Function
     */
    public MP5Function getFeature() {
        return this.featureFunction;
    }

    /**
     * Returns average of outputs
     * 
     * @return double
     */
    public double getyMean() {
        return new Double(this.yMean);
    }

    /**
     * Returns average of inputs
     * 
     * @return double
     */
    public double getxMean() {
        return new Double(this.xMean);
    }

    @Override
    public double f(Restaurant yelpRestaurant, RestaurantDB db) {
        double predictedRating;

        predictedRating = this.getA() + this.getB() * this.getFeature().f(yelpRestaurant, db);

        return predictedRating;
    }
}
