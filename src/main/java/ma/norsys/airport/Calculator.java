package ma.norsys.airport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    private final static String EMPTY = "";
    private final static String COMMA_DELIMITER = ",";
    private final static String NEW_LINE_DELIMITER = "\n";
    private List<String> delimiters = new ArrayList<>(List.of(COMMA_DELIMITER, NEW_LINE_DELIMITER));


    public int sam(String numbers) {
        if(EMPTY.equals(numbers)) {
            return 0;
        }

        if(numbers.startsWith("//")) {
            String newDelimiter = numbers.substring(2, 3);
            numbers = numbers.replaceFirst("\n", "");
            numbers = numbers.replaceFirst(newDelimiter, "");
            numbers = numbers.replaceFirst("//", "");
            delimiters.add(newDelimiter);
        }

        if(delimiters.stream().noneMatch(numbers::contains)) {
            return Integer.parseInt(numbers);
        }

        String reduce = delimiters.stream().reduce((s, s2) -> s +"|"+ s2).get();
        System.out.println(reduce);
        String[] nums = numbers.split(reduce);
        if(nums.length <= 1){
            throw new IllegalArgumentException();
        }
        int sum = 0;
        for (String num : nums) {
            sum = sum + Integer.parseInt(num);
        }
        return sum;
    }
}
