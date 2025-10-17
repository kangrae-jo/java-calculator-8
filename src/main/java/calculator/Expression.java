package calculator;

import java.util.regex.Pattern;

public class Expression {

    private final CustomSeparator customSeparator;
    private final String expression;

    public Expression(String input) {
        this.customSeparator = new CustomSeparator(input);
        this.expression = validateNumbers(input);
    }

    public Integer makeSum() {
        String defaultSeparator = ",:";
        String separator = defaultSeparator;
        if (customSeparator.hasSeparator()) {
            separator += customSeparator.getSeparator();
        }

        String splitRegex = "[" + Pattern.quote(separator) + "]";

        int sum = 0;
        for (String number : expression.split(splitRegex)) {
            if (!number.isEmpty()) {
                sum += Integer.parseInt(number);
            }
        }

        return sum;
    }

    private String validateNumbers(String input) {
        String defaultSeparator = ",:";
        String separator = defaultSeparator;

        if (customSeparator.hasSeparator()) {
            separator += customSeparator.getSeparator();
            input = input.substring(5);
        }

        String numberPattern = "^([0-9]+(?:[" + Pattern.quote(separator) + "][0-9]+)*)?$";
        if (!input.matches(numberPattern)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 숫자 입력 형식입니다.");
        }

        return input;
    }

}
