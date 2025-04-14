package service;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CommandHistoryService {
    private String input;
    private List<Double> values;
    private double result;

    private static Queue<CommandHistoryService> history = new LinkedList<>();

    public CommandHistoryService(){
    }

    public CommandHistoryService(String input, List<Double> values, double result) {
        this.input = input;
        this.values = values;
        this.result = result;
    }

    public void printsHistory(){
        for(CommandHistoryService h: history){
            System.out.println("operations: " + h.input + ", values: " + h.values + ", result: " + h.result);
        }

    }

    public void addHistory(String input, List<Double> values, double result){

        if(history.size() == 5){
            history.poll();
        }
        history.offer(new CommandHistoryService(input, values, result));
    }

}
