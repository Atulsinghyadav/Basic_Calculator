package service;

import exceptionHandling.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DivisonCommandServiceTest {

    DivisonCommandService divisonCommandService = new DivisonCommandService();

    @Test
    void testInvalidInput(){

        List<Double> input = Arrays.asList(10.0);

        Assertions.assertThrows(InvalidInputException.class, () -> {
            divisonCommandService.execute(input);
        });
    }

    @Test
    void testArithmeticException(){
        List<Double> input1 = Arrays.asList(10.0, 0.0);

        Assertions.assertThrows(ArithmeticException.class, () -> {
            divisonCommandService.execute(input1);
        });
    }

    @Test
    void testDivisionCommandWithMultipleValues() throws InvalidInputException {
        List<Double> input2 = Arrays.asList(100.0, 20.0, 5.0);

        Double result = divisonCommandService.execute(input2);

        Assertions.assertEquals(1.0, result);
    }

}