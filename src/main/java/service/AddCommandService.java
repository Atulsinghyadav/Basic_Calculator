package service;

import basicCalculator.ComputerCommand;
import exceptionHandling.InvalidInputException;

import java.util.List;

public class AddCommandService implements ComputerCommand<Double> {


    public Double execute(List<Double> values) throws InvalidInputException {
        if (values.size() < 2) {
            throw new InvalidInputException("Please enter atleast two numbers to perform addition.");
        }
        double result = 0;
        for (double n : values) {
            result += n;
        }
        return result;
    }
}
