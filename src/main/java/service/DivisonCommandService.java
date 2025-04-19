package service;

import basicCalculator.ComputerCommand;
import exceptionHandling.InvalidInputException;

import java.util.List;

public class DivisonCommandService implements ComputerCommand<Double> {

    public Double execute(List<Double> values) throws InvalidInputException {
        if(values.size()<2) {
            throw new InvalidInputException("Please enter atleast two numbers to perform divison");
        }
        double result = values.get(0);

        for(int i=1; i<values.size(); i++) {
            if (values.get(i) == 0) {
                throw new NullPointerException("You can not use a zero value in divison");
            } else {
                result /= values.get(i);
            }
        }
        return result;
    }
}
