import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static void main(String[] args) {
        new Driver().program();
    }

    public void program() {

        List<TFunction> tFunctions = new ArrayList<>();
        tFunctions.add(n -> (Math.log(n)/Math.log(2)));
        tFunctions.add(n -> n);
        tFunctions.add(n -> n * (Math.log(n)/Math.log(2)));
        tFunctions.add(n -> n * n);
        tFunctions.add(n -> n * n * n);
        tFunctions.add(n -> Math.pow(2, n));

        List<Double> xs = List.of(100.0, 101.0, 200.0, 10000.0);
        double biggestProblemConstant = 100000;

        ComplexityCalculator complexityCalculator = new ComplexityCalculator(tFunctions, xs, biggestProblemConstant);
        complexityCalculator.runTests();
    }

}












//        runTests(tFunctions, xs, biggestProblemConstant);
/*    public void runTests(List<TFunction> tFunctions, List<Double> xs, double constant) {
        for (int i = 0; i < tFunctions.size(); i++) {
            TFunction f = tFunctions.get(i);
            double x0 = xs.get(0);
            double biggestProblem = Math.floor(ComplexityCalculator.findIntersectionWithConstant(f, constant, f.apply(x0)));

            System.out.println("Function " + i + ":");
            for (Double x : xs) {
                double scaleFactor = f.apply(x) / f.apply(x0);
                System.out.printf("n = %5.0f, scale = %6.2e, value = %.2e %n", x, scaleFactor, f.apply(x));
            }
            System.out.printf("Biggest problem solvable with %.0es: %.0f elements %n", constant, biggestProblem);
        System.out.println();


        }


    }*/





//            List<Double> outputs = ComplexityCalculator.findOutputs(tFunctions.get(i), xs);
//            List<Double> scaleFactors = ComplexityCalculator.findOutputScaleFactors(outputs);



//
//        ComplexityCalculator3 complexityCalculator = new ComplexityCalculator3(tFunctions, measurePoints, biggestProblemConstant);
//
//        List<Double> results = complexityCalculator.applyFunctions(100);
//
//
//        for (Double result : results) {
//            System.out.println(result);
//        }
//
//        double result2 = complexityCalculator.findDerivate(complexityCalculator.getTfunctions().get(3), 6);
//
//        System.out.println(result2);
//
//        System.out.println();
//
//        double result3 = complexityCalculator.findIntersectionWithNewtonRaphson(complexityCalculator.getTfunctions().get(2), 100000);
//
//        System.out.println(result3);
//
//        System.out.println();
//        System.out.println();
//        complexityCalculator.calculateComplexities();


