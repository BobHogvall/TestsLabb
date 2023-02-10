package andraUppgiften;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorTest {

    @Test
    void testAdd(){
        var test = StringCalculator.add("2,3");    //given
        assertThat(test).isEqualTo(5);  //then and when
    }

    @Test
    void testThatAddWorksWithException(){
        var testShouldFail = StringCalculator.add(",3");
        assertThat(testShouldFail).isZero();
    }

    @Test
    void testThatAddWorksWithUnknownAmountsOfNumber(){
        assertThat(StringCalculator.add("2,3,12,7")).isEqualTo(24);
    }

    @Test
    void testThatAddCanHandleLineSeparator(){
        assertThat(StringCalculator.add("1\n2,3")).isEqualTo(6);

    }

    @Test
    void testThatCharSequenceLineBreakAfterCommaFails(){
        assertThat(StringCalculator.add("1,\n")).isZero();
    }

    @Test
    void testThatDifferentDelimiterWorks(){
        assertThat(StringCalculator.add("//;\n1;2")).isEqualTo(3);
    }

    @Test
    void testAnotherDelimiter(){
        assertThat(StringCalculator.add("//o\n1o2")).isEqualTo(3);
    }

    @Test
    void negativeNumbersShouldThrowExceptAndPrintNumbers(){
          Exception exception = assertThrows(NumberFormatException.class,
                   () -> StringCalculator.add("3,-5,-9,-22"));
           String expectedMessage = "negatives not allowed";
           assertThat(expectedMessage).isEqualTo(exception.getMessage());
        System.out.println(expectedMessage);
    }

    @Test
    void ignoreNumbersLargerThan1000(){
        assertThat(StringCalculator.add("2,3,1007")).isEqualTo(5);
    }

    @Test
    void multipleDelimitersShouldWork(){
        assertThat(StringCalculator.add("//[***]\n1***2***3")).isEqualTo(6);
    }

    @Test
    void differentDelimitersShouldWorkSimultaneously(){
        assertThat(StringCalculator.add("//[*][%]\n1*2%3")).isEqualTo(6);
    }

    @Test
    void differentDelimitersLongerThanOneCharacter(){
        assertThat(StringCalculator.add("//[**][%%][oo]\n1**2%%3oo4")).isEqualTo(10);
    }

    @Test
    void tryDifferentDelimitersWithThreeStars(){
        assertThat(StringCalculator.add("//[***][%]\n1***2%3")).isEqualTo(6);
    }
}