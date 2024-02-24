package ladder.domain.direction;

import java.util.Random;

public class DirectionNeutralGeneratorImpl implements DirectionGenerator {

    private final Random random;

    public DirectionNeutralGeneratorImpl() {
        this.random = new Random();
    }

    @Override
    public Direction generateInitialValue() {
        return Direction.getDirection(1);
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
        int randomNumber = random.nextInt(2);
        return Direction.getDirection(randomNumber);
    }
}
