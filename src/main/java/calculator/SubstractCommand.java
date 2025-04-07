package calculator;

import basicCalculator.ComputerCommand;
import exceptionHandling.InvalidInputException;

import java.util.List;

public class SubstractCommand implements ComputerCommand {

    public double execute(List<Double> values) throws InvalidInputException {
        if(values.size()<2){
            throw new InvalidInputException("Please enter atleast two numbers to perform substraction");
        }
        double result = values.get(0);

        for(double n: values){
            result -= n;
        }
        return result;
    }
}
