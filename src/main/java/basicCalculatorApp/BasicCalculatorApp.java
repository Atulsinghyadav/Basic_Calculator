package basicCalculatorApp;

import basicCalculator.ComputerCommand;
import service.*;

import java.util.*;

public class BasicCalculatorApp {

    public static void main(String[] args) {

        System.out.println("Running");

        String input = args[0];

        CommandHistoryService commandHistoryService = new CommandHistoryService();

        if(input.equalsIgnoreCase("history")){
            commandHistoryService.printsHistory();
            return;
        }

        if (args.length < 3 && !input.equalsIgnoreCase("history")) {
            System.out.println("You have to use it as shown: [operation] [nums1] [nums2]....");
            return;
        }


        // Create the map of operations
        Map<String, ComputerCommand> commands = new HashMap<>();
        commands.put("add", new AddCommandService());
        commands.put("substract", new SubstractCommandService());
        commands.put("multiply", new MultiplyCommandService());
        commands.put("divison", new DivisonCommandService());


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
            commandHistoryService.addHistory(input, values, result);
            System.out.println("Result: " + result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}