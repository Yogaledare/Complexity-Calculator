import java.util.ArrayList;
import java.util.List;

public class ComplexityCalculator3 {




    private final List<TFunction> tfunctions;
    private final List<Double> measurePoints;
    private final double biggestProblemConstant;
    private final double dx = 0.0001;
    private final double errorTolerance = 0.01;
    private final double initialGuess = 200;


    public ComplexityCalculator3(List<TFunction> tFunctions, List<Double> measurePoints, double biggestProblemConstant) {

        this.tfunctions = tFunctions;
        this.measurePoints = measurePoints;
        this.biggestProblemConstant = biggestProblemConstant;
    }


    public List<Double> applyFunctions (int n) {
        List<Double> output = new ArrayList<>();
        for (TFunction tfunction : tfunctions) {
            output.add(tfunction.apply(n));
        }
        return output;
    }


    public double findDerivate(TFunction tFunction, double x) {
        return (tFunction.apply(x + dx) - tFunction.apply(x - dx)) / (2 * dx);
    }


    public double findIntersectionWithNewtonRaphson(TFunction tFunction, double constant) {
        TFunction f = x -> tFunction.apply(x) - constant;
        double xn = initialGuess;
        while (true) {
            double xOld = xn;
//            System.out.println(xn + ", " + tFunction.apply(xn) + ", " + constant);
            xn = xn - f.apply(xn)/findDerivate(f, xn);
            if (Math.abs(xn - xOld) < errorTolerance) {
                break;
            }
        }
        return xn;
    }


    public double calculateOutput(TFunction tfunction, double x) {
        return tfunction.apply(x);
    }


    public double calculatePercentageDifference(double after, double before) {
        return (after-before) / before * 100;
    }

//    public List<Double> calculateFactors(TFunction tfunction, List<Double> measurePoints) {
//        List<Double> factors = new ArrayList<>();
//        double functionOutputFirst = tfunction.apply(measurePoints.get(0));
//
//
//    }


    public void calculateComplexities() {
        for (TFunction tfunction : tfunctions) {
            double functionOutputFirst = tfunction.apply(measurePoints.get(0));
//            double measurePoint;
            double functionOutput;
//            double percentageDifference;
            double factor;

            for (Double measurePoint : measurePoints) {
                functionOutput = tfunction.apply(measurePoint);
//                percentageDifference = calculatePercentageDifference(functionOutput, functionOutputFirst);
                factor = functionOutput / functionOutputFirst;

                System.out.printf("n = %.0f: %.1f, factor: %.2f %n", measurePoint, functionOutput, factor);


            }



        }


    }
//
//
//        for (int i = 0; i < tfunctions.size(); i++) {
//            System.out.println("For function " + i + ":");
//            measurePoint = measurePoints.get(0);
//            functionOutput = calculateOutput(tfunctions.get(0), measurePoint);
//            System.out.printf("n = %.0f: %.1f%n", measurePoint, functionOutput);
//
//
//            for (int j = 1; j < measurePoints.size(); j++) {
//                measurePoint = measurePoints.get(j);
//                functionOutput = calculateOutput(tfunctions.get(j), measurePoint);
//
//                System.out.printf("n = %.0f: ", );
//
//
//            }
//
//



    public List<TFunction> getTfunctions() {
        return tfunctions;
    }
}
