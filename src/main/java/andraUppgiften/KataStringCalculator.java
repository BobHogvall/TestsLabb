package andraUppgiften;
import java.util.Arrays;

public class KataStringCalculator {

    public static int add(String numbers) {
        var sum = 0;
        if (numbers.contains(",\n")){
            return sum;
        } else if (numbers.startsWith("//") && !numbers.contains("][")){
            return Arrays.stream(cutString(numbers).replace(delimiter(numbers),",").split(","))
                    .mapToInt(Integer::parseInt)
                    .sum();
        } else if (numbers.contains("][")) {
            return Arrays.stream(cutString(numbers).split(multipleDelimiters(numbers)))
                    .mapToInt(Integer::parseInt)
                    .sum();
        } else if (numbers.contains("-")){
            Arrays.stream(numbers.split("[,\n]"))
                    .mapToInt(Integer::parseInt)
                    .filter(n -> n < 0)
                    .forEach(System.out::println);
            throw new NumberFormatException("negatives not allowed");
        } else {
            try {
                return Arrays.stream(numbers.split("[,\n]"))
                        .mapToInt(Integer::parseInt)
                        .filter(n -> n < 1001)
                        .sum();
            } catch (NumberFormatException e) {
                return sum;
            }
        }
    }

    private static String delimiter(String numbers){
            return numbers.substring(2, numbers.indexOf("\n"))
                    .replace("[", "")
                    .replace("]", "");

    }
    private static String multipleDelimiters(String numbers){
        return numbers.substring(2, numbers.indexOf("\n"))
                .replace("][","|")
                .replace("[", "")
                .replace("]", "")
                .replace("*","\\*");
    }
    private static String cutString(String numbers){
        return numbers.substring(numbers.indexOf("\n")+1);
    }
}