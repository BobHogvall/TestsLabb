package andraUppgiften;
import java.util.Arrays;

    public class KataStringCalculator {


//        public static int add(String numbers) {
//            var sum = 0;
//            if (numbers.contains(",\n")){
//                return sum;
//            }
//            else {
//                try {
//                    sum = Arrays.stream(numbers.split("[;,\n]"))
//                            .mapToInt(Integer::parseInt)
//                            .sum();
//                    return sum;
//                } catch (NumberFormatException e) {
//                    return sum;
//                }
//            }
//        }

        public static int add(String numbers) {
            var sum = 0;
            if (numbers.contains(",\n")){
                return sum;
            } else if(numbers.startsWith("//;\n")) {
                sum = Arrays.stream(numbers.replace("//;\n", "").split("[;,\n]"))
                        .mapToInt(Integer::parseInt)
                        .sum();
                return sum;
            } else {
                try {
                    sum = Arrays.stream(numbers.split("[;,\n]"))
                            .mapToInt(Integer::parseInt)
                            .sum();
                    return sum;
                } catch (NumberFormatException e) {
                    return sum;
                }
            }
        }
    }

    //varför delvis rött här?