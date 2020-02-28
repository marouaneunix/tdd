package ma.norsys.airport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SumTest {

    private Calculator calculator;

    @BeforeEach
    void setUp(){
        this.calculator = new Calculator();
    }

    @DisplayName("sam(\"\") => 0")
    @Test
    void shouldReturn0WhenThenStringIsEmpty(){
        Assertions.assertEquals(0, calculator.sam(""));
    }

    @DisplayName("sam(\"1\") => 1")
    @Test
    void shouldReturnNumber(){
        Assertions.assertEquals(1, calculator.sam("1"));
    }

    @DisplayName("sam(\"1,2\") => 3")
    @Test
    void shouldCalculateTheSumOfTwoNumberWithCommaSeparator(){
        Assertions.assertEquals(3, calculator.sam("1,2"));
    }

    @DisplayName("sam(\"1\\n2\") => 3")
    @Test
    void shouldCalculateTheSumOfTwoNumberWithNewLineSeparator(){
        Assertions.assertEquals(3, calculator.sam("1\n2"));
    }

    @DisplayName("sam(\"1,2,9,5\") => 17")
    @Test
    void shouldCalculateAnUnknownAmountOfNumbers(){
        Assertions.assertEquals(17, calculator.sam("1,2,9,5"));
    }

    @DisplayName("sam(\"1\\n2,9,5\") => 17")
    @Test
    void shouldHandleNewLinesBetweenNumber() {
        Assertions.assertEquals(17, calculator.sam("1\n2,9,5"));
    }

    @DisplayName("sam(\"1\\n,\") => exception")
    @Test
    void shouldThrowExceptionWhenIsNotOk(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.sam("1\n,"));
    }

    @DisplayName("sam(\"//;\\n1;2\") => 3")
    @Test
    void shouldHandleMultipleDelimiters(){
        Assertions.assertEquals(3, calculator.sam("//;\n1;2"));
    }




}
