package service;

import basicCalculator.ComputerCommand;
import exceptionHandling.InvalidInputException;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

    public class CommandHistoryService implements ComputerCommand<Void> {
    private String input;
    private List<Double> values;
    private double result;
    private static Queue<CommandHistoryService> history = new LinkedList<>();

    static {
        File file = new File("History.txt");
        FileReader fr = null;
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Failed to create history file: " + e.getMessage());
            }
        }
                     try(BufferedReader br = new BufferedReader(new FileReader("History.txt"))) {
            String line;
            while((line = br.readLine()) != null){

                String[] parts = line.split(":");
                if(parts.length != 3)   continue;

                String input = parts[0];
                String valuesPart = parts[1].replace("[", "").replace("]", "");
                String[] valueString = valuesPart.split(",");
                List<Double> values = new LinkedList<>();
                for(String x: valueString){
                    if(!x.trim().isEmpty()){
                        values.add(Double.parseDouble(x.trim()));
                    }
                }

                Double result = Double.parseDouble(parts[2]);
                history.offer(new CommandHistoryService(input, values, result));
            }
        }catch (IOException e) {
            System.out.println("Error loading history: " + e.getMessage());
        }

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("History.txt"))) {
                for (CommandHistoryService entry : history) {
                    writer.write(entry.input + ":" + entry.values + ":" + entry.result);
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("Failed to save history on exit: " + e.getMessage());
            }
        }));
    }

    public CommandHistoryService(){
    }

    public CommandHistoryService(String input, List<Double> values, double result) {
        this.input = input;
        this.values = values;
        this.result = result;
    }

    public void addHistory(String input, List<Double> values, double result){

        if(history.size() == 5){
            history.poll();
        }
        history.offer(new CommandHistoryService(input, values, result));
    }

    @Override
    public Void execute(List<Double> values) throws InvalidInputException {

        for(CommandHistoryService h: history){
            System.out.println("operations: " + h.input + ", values: " + h.values + ", result: " + h.result);
        }
        return null;
    }

}
