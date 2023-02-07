package andraUppgiften;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class KataCalculatorTest {

    @Test
    public void testAdd(){
        var test = KataCalculator.add("2,3");    //given
        assertThat(test).isEqualTo(5);  //then and when
    }

    @Test
    public void testThatAddWorksWithException(){
        var testShouldFail = KataCalculator.add(",3");
        assertThat(testShouldFail).isZero();
    }

}
