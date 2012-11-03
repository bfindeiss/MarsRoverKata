package marsroverkata;

import java.util.ArrayList;

/**
 *
 * @author bfindeiss
 */
class Direction {

    private final String facingDirection;
    public static String NORTH_DIRECTION = "NORTH";
    public static String SOUTH_DIRECTION = "SOUTH";
    public static String WEST_DIRECTION = "WEST";
    public static String EAST_DIRECTION = "EAST";
    public static Direction NORTH = new Direction(NORTH_DIRECTION);
    public static Direction SOUTH = new Direction(SOUTH_DIRECTION);
    public static Direction EAST = new Direction(EAST_DIRECTION);
    public static Direction WEST = new Direction(WEST_DIRECTION);
    private static ArrayList<Direction> directions = new ArrayList<Direction>() {
        {
            add(Direction.NORTH);
            add(Direction.EAST);
            add(Direction.SOUTH);
            add(Direction.WEST);
        }
    };

    private Direction(String facingDirection) {
        this.facingDirection = facingDirection;
    }

    public static Direction turnRight(Direction currentDirection) {
        int indexOfCurrentDirection = getIndexOfDirection(currentDirection);
        int indexOfNewDirection = (indexOfCurrentDirection + 1) % directions.size();

        return directions.get(indexOfNewDirection);
    }

    public static Direction turnLeft(Direction currentDirection) {
        int indexOfCurrentDirection = getIndexOfDirection(currentDirection);
        int indexOfNewDirection = (indexOfCurrentDirection - 1 + directions.size()) % directions.size();

        return directions.get(indexOfNewDirection);
    }

    public static Direction getOppositeDirection(Direction currentDirection) {
        int indexOfCurrentDirection = getIndexOfDirection(currentDirection);
        int indexOfNewDirection = (indexOfCurrentDirection + (directions.size() / 2)) % directions.size();

        return directions.get(indexOfNewDirection);
    }

    private static int getIndexOfDirection(Direction currentDirection) {
        int indexOfCurrentDirection = directions.indexOf(currentDirection);
        return indexOfCurrentDirection;
    }

    @Override
    public String toString() {
        return "Direction{" + "facingDirection=" + facingDirection + '}';
    }
}
