package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomEngineTest {

    @Test
    void 랜덤_엔진은_임계치를_넘으면_전진한다() {
        //given
        int moveDistance = 1;
        int randomRangeEnd = 10;
        int accelerationThreshold = 5;
        Engine engine = new RandomEngine(moveDistance, randomRangeEnd, accelerationThreshold);

        //when
        int accelerate = engine.accelerate();

        //then
        Assertions.assertThat(accelerate).isIn(0, moveDistance);
    }

    @Test
    void 랜덤_엔진은_확률이_100이면_무조건_전진한다() {
        //given
        int moveDistance = 11;
        int randomRangeEnd = 0;
        int accelerationThreshold = 0;
        Engine engine = new RandomEngine(moveDistance, randomRangeEnd, accelerationThreshold);

        //when
        int accelerate = engine.accelerate();

        //then
        Assertions.assertThat(accelerate).isEqualTo(moveDistance);
    }

    @Test
    void 랜덤_엔진은_확률이_0이면_무조건_정지한다() {
        //given
        int moveDistance = 1;
        int randomRangeEnd = 1;
        int accelerationThreshold = 2;
        Engine engine = new RandomEngine(moveDistance, randomRangeEnd, accelerationThreshold);

        //when
        int accelerate = engine.accelerate();

        //then
        Assertions.assertThat(accelerate).isEqualTo(0);
    }
}