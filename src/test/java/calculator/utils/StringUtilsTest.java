package calculator.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("스트링 유틸 테스트")
class StringUtilsTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("문자열 isEmpty() 테스트")
    void isEmpty(String input, boolean expectedValue) {
        assertThat(StringUtils.isEmpty(input)).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> isEmpty() {
        return Stream.of(
                Arguments.of("", true),
                Arguments.of(null, true),
                Arguments.of(" ", false),
                Arguments.of("n", false)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("문자열이 숫자로만 이루어져 있는지 테스트")
    void isNumeric(String input, boolean expectedValue) {
        assertThat(StringUtils.isNumeric(input)).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> isNumeric() {
        return Stream.of(
                Arguments.of("", false),
                Arguments.of("1", true),
                Arguments.of("-1", true),
                Arguments.of("50", true)
        );
    }
}