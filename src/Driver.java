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




