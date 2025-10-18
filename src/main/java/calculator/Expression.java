package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Expression {

    private final static String DEFAULT_SEPARATOR = ",:";
    private final CustomSeparator customSeparator;
    private final String expression;

    public Expression(String input) {
        this.customSeparator = new CustomSeparator(input);
        this.expression = validateNumbers(input);
    }

    public Integer makeSum() {
        String separator = DEFAULT_SEPARATOR;
        if (customSeparator.hasSeparator()) {
            separator += customSeparator.getSeparator();
        }

        String numberRegex = "[" + Pattern.quote(separator) + "]";
        return Arrays.stream(expression.split(numberRegex))
                .filter(number -> !number.isEmpty())
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private String validateNumbers(String input) {
        String separator = DEFAULT_SEPARATOR;
        if (customSeparator.hasSeparator()) {
            separator += customSeparator.getSeparator();
            input = input.substring(CustomSeparator.CUSTOM_SEPARATOR_END);
        }

        String numberPattern = "^([0-9]+(?:[" + Pattern.quote(separator) + "][0-9]+)*)?$";
        if (!input.matches(numberPattern)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 숫자 입력 형식입니다.");
        }

        return input;
    }

}
