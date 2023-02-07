package andraUppgiften;
import java.util.Arrays;

    public class KataCalculator {


        public static int add(String numbers) {
            var sum = 0;
            try {
                sum = Arrays.stream(numbers.split(","))
                        .mapToInt(Integer::parseInt)
                        .sum();
                return sum;
            } catch (NumberFormatException e) {
                return sum;
            }
        }

    }
