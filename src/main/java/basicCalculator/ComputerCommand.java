package basicCalculator;
import exceptionHandling.InvalidInputException;

import java.util.List;


public interface ComputerCommand {
    double execute(List<Double> values) throws InvalidInputException;


}
