package service;

import exceptionHandling.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubstractCommandServiceTest {

    @Test
    void testInvalidInput(){
        SubstractCommandService substractCommandService = new SubstractCommandService();

        List<Double> input = Arrays.asList(10.0);

        Assertions.assertThrows(InvalidInputException.class, () -> {
            substractCommandService.execute(input);
        });
    }

    @Test
    void testNegativeValueResult(){
        SubstractCommandService substractCommandService = new SubstractCommandService();

        String input1 = "no\n";
        System.setIn(new ByteArrayInputStream(input1.getBytes()));

        List<Double> input2 = Arrays.asList(10.0,20.0);

        Assertions.assertThrows(InvalidInputException.class, () -> {
            substractCommandService.execute(input2);
        });
    }


    @Test
    void testResultWithMultipleValues() throws InvalidInputException {
        SubstractCommandService substractCommandService = new SubstractCommandService();

        List<Double> input3 = Arrays.asList(100.0, 20.0, 30.0);

        Double result = substractCommandService.execute(input3);

        Assertions.assertEquals(result, 50.0);
    }

}