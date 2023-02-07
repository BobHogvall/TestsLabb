package andraUppgiften;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class KataCalculatorTest {

    @Test
    public void TestAdd(){
        var x = KataCalculator.Add("2,3");    //given
        assertThat(x).isEqualTo(5);  //then and when
    }

}
