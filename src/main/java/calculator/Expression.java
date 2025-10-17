package calculator;

public class Expression {

    private final String expression;

    public Expression(String input) {
        validateRegex(input);
        this.expression = input;
    }

    private void validateRegex(String input) {
        // 헤더가 없는 경우
        if (input.isEmpty() || input.charAt(0) != '/') {
            return;
        }

        // 헤더가 있는 경우
        String headerPattern = "^//(\\D)\\\\n.*$"; // "//;\n1,2,3"
        if (!input.matches(headerPattern)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 커스텀 구분자 등록 형식입니다. 어플리케이션을 종료합니다.");
        }
    }

}
