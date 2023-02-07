package andraUppgiften;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


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



}
