package service;

import exceptionHandling.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AddCommandServiceTest {

    @Test
    void testAdditionWithLessThanTwoValuesThrowsException() throws InvalidInputException {
        AddCommandService addCommandService = new AddCommandService();

        List<Double> input = List.of(10.0);

        Assertions.assertThrows(InvalidInputException.class, () -> {
            addCommandService.execute(input);
        });
    }

    @Test
    void testAdditionWithMultipleValues() throws InvalidInputException {


        AddCommandService addCommandService = new AddCommandService();
        List<Double> inputList = Arrays.asList(10.0,20.0,30.0,50.0);
        Double result = addCommandService.execute(inputList);

        Assertions.assertEquals(110.0, result);

    }

}