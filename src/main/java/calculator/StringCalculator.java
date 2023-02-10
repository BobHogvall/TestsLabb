package calculator;
import java.util.Arrays;

public class StringCalculator {

    public static int add(String numbers) {
        var sum = 0;
        if (numbers.contains("-")) negative(numbers);
        else if (numbers.startsWith("//")) return multipleDel(numbers);
        else if (numbers.contains(",\n")) return sum;
        return other(numbers, sum);
    }

    private static int other(String numbers, int sum) {
        try {
            return Arrays.stream(numbers.split("[,\n]"))
                    .mapToInt(Integer::parseInt)
                    .filter(n -> n < 1001)
                    .sum();
        } catch (NumberFormatException e) {
            return sum;
        }
    }

    private static void negative(String numbers) {
        if (numbers.contains("//")){

        }
        Arrays.stream(numbers.split("[,\n]"))
                .mapToInt(Integer::parseInt)
                .filter(n -> n < 0)
                .forEach(System.out::println);
        throw new NumberFormatException("negatives not allowed");
    }

    private static int multipleDel(String numbers) {
        return Arrays.stream(cutString(numbers).split(multipleDelimiters(numbers)))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static String multipleDelimiters(String numbers){
        return numbers.substring(2, numbers.indexOf("\n"))
                .replace("][","|")
                .replace("[", "")
                .replace("]", "")
//                .replace("/","")
//                .replace("\n", "")
                .replace("*","\\*");
    }
    private static String cutString(String numbers){
        return numbers.substring(numbers.indexOf("\n")+1);
    }
}

// //[***]\n1***2