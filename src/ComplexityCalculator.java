import java.util.List;

public class ComplexityCalculator {


    private final List<TFunction> tFunctions;
    private final List<Double> xs;
    private final double biggestProblemConstant;


    public ComplexityCalculator(List<TFunction> tFunctions, List<Double> xs, double biggestProblemConstant) {
        this.tFunctions = tFunctions;
        this.xs = xs;
        this.biggestProblemConstant = biggestProblemConstant;
    }


    // Run tests and print results for all tFunctions at all xs
    public void runTests() {
        for (int i = 0; i < tFunctions.size(); i++) {
            TFunction f = tFunctions.get(i);
            double x0 = xs.get(0);
            double biggestProblem = Math.floor(findIntersectionWithConstant(f, biggestProblemConstant, xs.get(0)/*20*/));

            System.out.println("Function " + i + ":");
            for (Double x : xs) {
                double scaleFactor = f.apply(x) / f.apply(x0);
                System.out.printf("n = %5.0f, scale = %6.2e, value = %.2e %n", x, scaleFactor, f.apply(x));
            }
            System.out.printf("Biggest problem solvable with %.0es: %.0f elements %n", biggestProblemConstant, biggestProblem);
            System.out.println();
        }
    }


    // Find derivate of f(x) at point x by symmetric difference quotient
    private static double findDerivative(TFunction tFunction, double x) {
        double dx = 0.01;
        return (tFunction.apply(x + dx) - tFunction.apply(x - dx)) / (2 * dx);
    }


    // find root of f(x) - constant = 0 with Newton Raphsons method
    public static double findIntersectionWithConstant(TFunction tFunction, double constant, double initialGuess) {
        double errorTolerance = 0.001;
        TFunction f = x -> tFunction.apply(x) - constant;
        double xn = initialGuess;
        while (true) {
            double xOld = xn;
            xn = xn - f.apply(xn)/ findDerivative(f, xn);
//            System.out.println("xn = " + xOld + " - " + f.apply(xOld) + " / " + findDerivative(f, xOld));
            if (Math.abs(xn - xOld) < errorTolerance || Double.isInfinite(xn) || Double.isNaN(xn)) {
                break;
            }
        }
        return xn;
    }


}



