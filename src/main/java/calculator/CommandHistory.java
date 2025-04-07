package calculator;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class CommandHistory {

    private final int HISTORY = 5;
    private final String HISTORY_FILE = "command_history.txt";

    public CommandHistory(){
        loadHistoryFile();
    }

    private Queue<String> history = new LinkedList<>();

    public void add(String command){
        if(history.size() == HISTORY){
            history.poll();
        }
        history.offer(command);
    }

    public void printHistory(){
        System.out.println("Last " + history.size() + " commands:");
        for (String cmd : history) {
            System.out.println(cmd);
        }
    }

    public void loadHistoryFile() {
        File file = new File(HISTORY_FILE);

        if(!file.exists()){
            return;
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = reader.readLine()) != null){
                history.offer(line);
            }
        }   catch (IOException e) {
            System.out.println("Could not load history: " + e.getMessage());
        }
    }

    public void saveHistoryToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORY_FILE))) {
            for (String cmd : history) {
                writer.write(cmd);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not save history: " + e.getMessage());
        }
    }
}
