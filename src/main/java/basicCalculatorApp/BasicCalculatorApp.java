package basicCalculatorApp;

import basicCalculator.ComputerCommand;
import service.*;

import java.util.*;

public class BasicCalculatorApp {

    public static void main(String[] args) {

        System.out.println("Welcome to the Calculator.Here you can perform actions like 'addition', 'substraction'" +
                "'multiply', 'divison' and also see the history for last 5 operations.");

        CommandHistoryService commandHistoryService = new CommandHistoryService();
        Scanner sc = new Scanner(System.in);

        // Create the map of operations
        Map<String, ComputerCommand> commands = new HashMap<>();
        commands.put("add", new AddCommandService());
        commands.put("substract", new SubstractCommandService());
        commands.put("multiply", new MultiplyCommandService());
        commands.put("divison", new DivisonCommandService());



        while (true) {

            System.out.println("Enter the operation you want to perform:");

            String input = sc.nextLine().trim();

            if (!commands.containsKey(input.toLowerCase())) {
                System.out.println("Please enter a valid operation:");
            }

            System.out.println("Enter the numbers. Press enter without typing anything to stop.");

            List<Double> values = new ArrayList<>();
            // List to hold the numbers
            while (true) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) {
                    break;
                }
                try {
                    values.add(Double.parseDouble(line));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format: ");
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
                System.out.println("Do you wish to perform more operations.");
                String choice = sc.nextLine().trim();
                if(choice.equalsIgnoreCase("no")){
                    break;
                }
                System.out.println("Do you want to see the history for last 5 operations. It will stop this program.");
                String historyChoice = sc.nextLine();
                if (historyChoice.equalsIgnoreCase("Yes")) {
                    commandHistoryService.printsHistory();
                    break;
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}