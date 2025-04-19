package basicCalculator;
import exceptionHandling.InvalidInputException;

import java.util.List;


public interface ComputerCommand<T> {
    T execute(List<Double> values) throws InvalidInputException;
}
