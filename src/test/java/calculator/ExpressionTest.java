package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ExpressionTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "100:1"})
    void 문자열_검증_헤더가_없이_올바른_경우(String input) {
        new Expression(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,,2", "/1,2,3", "2-4-5-6-", "1,2,"})
    void 문자열_검증_헤더가_없이_올바르지않은_경우(String input) {
        assertThatThrownBy(() -> new Expression(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//[\\n", "//-\\n", "//[\\n1,2[3"})
    void 문자열_검증_헤더가_있이_올바른_경우(String input) {
        new Expression(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//[//", "/;\n", "//--\\n", "//)\\n1,2,3)"})
    void 문자열_검증_헤더가_있이_올바르지않은_경우(String input) {
        assertThatThrownBy(() -> new Expression(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
