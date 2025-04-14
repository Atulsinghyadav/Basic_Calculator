package service;

import basicCalculator.ComputerCommand;
import exceptionHandling.InvalidInputException;

import java.util.List;

public class MultiplyCommandService implements ComputerCommand {

    public double execute(List<Double> values) throws InvalidInputException {
        if(values.size()<2){
            throw new InvalidInputException("Please enter atleast two numbers to perform multiply");
        }
        double result = 1;

        for(double n:values){
            result *= n;
        }
        return result;
    }
}
