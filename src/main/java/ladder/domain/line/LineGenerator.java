package ladder.domain.line;

import ladder.domain.direction.Direction;
import ladder.domain.direction.DirectionGenerator;

public class LineGenerator {

    private final DirectionGenerator directionGenerator;

    public LineGenerator(DirectionGenerator directionGenerator) {
        this.directionGenerator = directionGenerator;
    }

    public Line generate(int width) {
        Line line = new Line();
        int middleValue = width - 2;

        addInitialDirection(line);
        addMiddleDirection(middleValue, line);
        addLastDirection(line);

        return line;
    }

    private void addInitialDirection(Line line) {
        line.addDirection(directionGenerator.generateInitialValue());
    }

    private void addMiddleDirection(int middleValue, Line line) {
        for (int i = 0; i < middleValue; i++) {
            Direction lastDirection = line.getLastDirection();
            line.addDirection(directionGenerator.generateMiddleValue(lastDirection));
        }
    }

    private void addLastDirection(Line line) {
        Direction lastDirection = line.getLastDirection();
        line.addDirection(directionGenerator.generateLastValue(lastDirection));
    }
}
