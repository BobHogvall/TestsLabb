package andraUppgiften;
import java.util.Arrays;

public class KataStringCalculator {

    public static int add(String numbers) {
        var sum = 0;
        if (numbers.contains(",\n")){
            return sum;
        } else if (numbers.startsWith("//")){
            var delimiter = numbers.charAt(2);
            var newNumbers = numbers.substring(4);
            sum = Arrays.stream(newNumbers.replace(',', delimiter).split(String.valueOf(delimiter)))
                        .mapToInt(Integer::parseInt)
                        .sum();
            return sum;
        } else if (numbers.contains("-")){
            Arrays.stream(numbers.split("[,\n]"))
                    .mapToInt(Integer::parseInt)
                    .filter(n -> n < 0)
                    .forEach(System.out::println);
            throw new NumberFormatException("negatives not allowed");
        }
        else {
            try {
                sum = Arrays.stream(numbers.split("[,\n]"))
                        .mapToInt(Integer::parseInt)
                        .filter(n -> n < 1001)
                        .sum();
                return sum;
            } catch (NumberFormatException e) {
                return sum;
            }
        }
    }
}