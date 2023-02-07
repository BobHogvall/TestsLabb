package andraUppgiften;
import java.util.Arrays;

    public class KataCalculator {


        public static int Add(String numbers){
            return Arrays.stream(numbers.split(",")).mapToInt(Integer::parseInt).sum();
        }

    }
