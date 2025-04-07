package calculator;

import basicCalculator.ComputerCommand;
import exceptionHandling.InvalidInputException;

import java.util.List;
import java.util.Scanner;

public class SubstractCommand implements ComputerCommand {

    public double execute(List<Double> values) throws InvalidInputException {
        if(values.size()<2){
            throw new InvalidInputException("Please enter atleast two numbers to perform substraction");
        }

        if (values.size() == 2 && values.get(1) > values.get(0)) {
            System.out.println("Warning: The result may be negative. Do you want to continue? (yes/no)");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                throw new InvalidInputException("Operation cancelled by user.");
            }
        }

        double result = values.get(0);

        for(double n: values){
            result -= n;
        }
        return result;


    }
}
