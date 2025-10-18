package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparator {

    public static final int CUSTOM_SEPARATOR_END = 5;
    private static final String HEADER_PATTERN = "^//(\\D)\\\\n.*$";

    private final Character separator;

    public CustomSeparator(String input) {
        this.separator = validateRegex(input);
    }

    public boolean hasSeparator() {
        return separator != null;
    }

    public Character getSeparator() {
        return separator;
    }

    private Character validateRegex(String input) {
        // 헤더가 없는 경우
        if (input.isEmpty() || input.charAt(0) != '/') {
            return null;
        }

        // 헤더가 있는 경우
        Pattern pattern = Pattern.compile(HEADER_PATTERN);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 잘못된 커스텀 구분자 등록 형식입니다. 어플리케이션을 종료합니다.");
        }

        return matcher.group(1).charAt(0);
    }

}
