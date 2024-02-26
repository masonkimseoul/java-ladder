package ladder.domain.direction;

import java.util.Random;

public class DirectionRightGeneratorImpl implements DirectionGenerator {

    private final Random random;

    public DirectionRightGeneratorImpl() {
        this.random = new Random();
    }

    @Override
    public Direction generateInitialValue() {
        return Direction.getDirection(true);
    }

    @Override
    public Direction generateMiddleValue(Direction priorDirection) {
        if (priorDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return generateRightOrNeutral();
    }

    @Override
    public Direction generateLastValue(Direction priorDirection) {
        if (priorDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return Direction.NEUTRAL;
    }

    private Direction generateRightOrNeutral() {
        return Direction.getDirection(random.nextBoolean());
    }
}
