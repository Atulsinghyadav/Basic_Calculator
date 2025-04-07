package basicCalculatorApp;

import basicCalculator.ComputerCommand;
import calculator.AddCommand;
import calculator.DivisonCommand;
import calculator.MultiplyCommand;
import calculator.SubstractCommand;

import java.util.*;

public class BasicCalculatorApp {

    public static void main(String[] args) {

        System.out.println("Running");

        if (args.length < 3) {
            System.out.println("You have to use it as shown: [operation] [nums1] [nums2]....");
            return;
        }

        // Create the map of operations
        Map<String, ComputerCommand> commands = new HashMap<>();
        commands.put("add", new AddCommand());
        commands.put("substract", new SubstractCommand());
        commands.put("multiply", new MultiplyCommand());
        commands.put("divison", new DivisonCommand());

        // Get the operation (first argument)
        String input = args[0];

        // List to hold the numbers
        List<Double> values = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            try {
                values.add(Double.parseDouble(args[i]));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format: " + args[i]);
                return;
            }
        }

        try {
            // Check if the operation is valid
            ComputerCommand command = commands.get(input);
            if (command == null) {
                System.out.println("Please enter a valid operation.");
                return;
            }

            // Execute the operation and print the result
            double result = command.execute(values);
            System.out.println("Result: " + result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}