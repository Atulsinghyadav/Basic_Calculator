package service;

import exceptionHandling.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyCommandServiceTest {

    @Test
    void testMultiplyWithOneValue(){

        MultiplyCommandService multiplyCommandService = new MultiplyCommandService();

       List<Double> input = Arrays.asList(10.0);

       Assertions.assertThrows(InvalidInputException.class, () -> {
           multiplyCommandService.execute(input);
       });
    }


    @Test
    void testMultiplyCommandWithMultipleValues() throws InvalidInputException {

        MultiplyCommandService multiplyCommandService = new MultiplyCommandService();

        List<Double> inputList = Arrays.asList(10.0, 20.0, 30.0);

        Double result = multiplyCommandService.execute(inputList);

        Assertions.assertEquals(result , 6000);
    }

}