package andraUppgiften;
import java.util.Arrays;

public class KataStringCalculator {
    public static int add(String numbers) {
        var sum = 0;
        if (numbers.contains(",\n")){
            return sum;
        } else if (numbers.startsWith("//")){
            sum = Arrays.stream(cutString(numbers).replace(delimiter(numbers),",").split(","))
                .mapToInt(Integer::parseInt)
                .sum();
            return sum;
        } else if (numbers.contains("-")){
            Arrays.stream(numbers.split("[,\n]"))
                    .mapToInt(Integer::parseInt)
                    .filter(n -> n < 0)
                    .forEach(System.out::println);
            throw new NumberFormatException("negatives not allowed");
        } else {
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

    private static String delimiter(String numbers){ //skapar en ny sträng av det som ska användas som delimiter
        return numbers.substring(2, numbers.indexOf("\n"))
                .replaceAll("\\[","")
                .replaceAll("\\]","");
    }
    private static String cutString(String numbers){ //tar bort allt innan radbrytning
        return numbers.substring(numbers.indexOf("\n")+1);
    }
}