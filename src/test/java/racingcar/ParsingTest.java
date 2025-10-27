package racingcar;

import static org.assertj.core.api.BDDAssertions.catchException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParsingTest {

    @Test
    void 파싱_예외에_대해서_에러를_반환한다() {
        //given
        Parser parser = new Parser(",");
        String input = "가,,나";

        //when
        Exception exception = catchException(() -> {
            parser.parsing(input);
        });

        //then
        Assertions.assertThat(exception).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해석할 수 없는 문자열 입니다");
    }
}