package andraUppgiften;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class KataStringCalculatorTest {

    @Test
    public void testAdd(){
        var test = KataStringCalculator.add("2,3");    //given
        assertThat(test).isEqualTo(5);  //then and when
    }

    @Test
    public void testThatAddWorksWithException(){
        var testShouldFail = KataStringCalculator.add(",3");
        assertThat(testShouldFail).isZero();
    }

    @Test
    public void testThatAddWorksWithUnknownAmountsOfNumber(){
        assertThat(KataStringCalculator.add("2,3,12,7")).isEqualTo(24);
    }

    @Test
    public void testThatAddCanHandleLineSeparator(){
        assertThat(KataStringCalculator.add("1\n2,3")).isEqualTo(6);

    }

    @Test
    public void testThatCharSequenceLineBreakAfterCommaFails(){
        assertThat(KataStringCalculator.add("1,\n")).isZero();
    }

    @Test
    public void testThatDifferentDelimiterWorks(){
        assertThat(KataStringCalculator.add("//;\n1;2")).isEqualTo(3);
    }

    @Test
    public void testAnotherDelimiter(){
        assertThat(KataStringCalculator.add("//o\n1o2")).isEqualTo(3);
    }

    @Test
    public void testNegativeNumbersShouldThrowExceptAndPrintNumbers(){
          Exception exception = assertThrows(NumberFormatException.class,
                   () -> {
                       KataStringCalculator.add("3,-5,-9,-22");
                   });

           String expectedMessage = "negatives not allowed";
           assertThat(expectedMessage).isEqualTo(exception.getMessage());
        System.out.println(expectedMessage);

    }

}
