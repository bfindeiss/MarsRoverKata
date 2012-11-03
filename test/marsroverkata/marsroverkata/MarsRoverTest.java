package marsroverkata;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

/**
 *
 * @author bfindeiss
 */
public class MarsRoverTest {

    @Test
    public void testNewRoverStartingPosition() {
        MarsRover rover = new MarsRover();
        Position startingPosition = new Position(0, 0);
        Direction startingDirection = Direction.EAST;
        rover.initialize(startingPosition, startingDirection);
        assertThat(rover.getCurrentPosition(), is(startingPosition));
    }

    @Test
    public void testNewRoverStartingDirection() {
        MarsRover rover = new MarsRover();
        Position startingPosition = new Position(0, 0);
        Direction startingDirection = Direction.EAST;
        rover.initialize(startingPosition, startingDirection);
        assertThat(rover.getCurrentDirection(), is(startingDirection));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testCommandReceptionOfIllegalCommand() {
        MarsRover rover = new MarsRover();
        rover.enterSingleCommand('x');
    }

    @Test
    public void testMoveRoverBackward() {
        MarsRover rover = new MarsRover();
        Position startingPosition = new Position(0, 0);
        Direction startingDirection = Direction.EAST;
        rover.initialize(startingPosition, startingDirection);
        assertThat(rover.getCurrentPosition(), is(startingPosition));
        assertThat(rover.getCurrentDirection(), is(startingDirection));

        rover.enterSingleCommand('b');

        assertThat(rover.getCurrentPosition(), equalTo(new Position(3, 0)));

    }

    @Test
    public void testRoverTurnRight() {

        MarsRover rover = new MarsRover();
        Position startingPosition = new Position(0, 0);
        Direction startingDirection = Direction.EAST;
        rover.initialize(startingPosition, startingDirection);
        assertThat(rover.getCurrentPosition(), is(startingPosition));
        assertThat(rover.getCurrentDirection(), is(startingDirection));

        rover.enterSingleCommand('r');

        assertThat(rover.getCurrentDirection(), equalTo(Direction.SOUTH));

    }

    @Test
    public void testRoverTurnLeft() {

        MarsRover rover = new MarsRover();
        Position startingPosition = new Position(0, 0);
        Direction startingDirection = Direction.EAST;
        rover.initialize(startingPosition, startingDirection);
        assertThat(rover.getCurrentPosition(), is(startingPosition));
        assertThat(rover.getCurrentDirection(), is(startingDirection));

        rover.enterSingleCommand('l');

        assertThat(rover.getCurrentDirection(), equalTo(Direction.NORTH));

    }

    @Test
    public void testMoveRoverForwardDirectionEast() {
        MarsRover rover = new MarsRover();

        Position startingPosition = new Position(0, 0);
        Direction startingDirection = Direction.EAST;
        rover.initialize(startingPosition, startingDirection);
        assertThat(rover.getCurrentPosition(), is(startingPosition));
        assertThat(rover.getCurrentDirection(), is(startingDirection));

        rover.enterSingleCommand('f');

        assertThat(rover.getCurrentPosition(), equalTo(new Position(1, 0)));

    }

    @Test
    public void testMoveRoverForwardDirectionSouth() {
        MarsRover rover = new MarsRover();

        Position startingPosition = new Position(0, 0);
        Direction startingDirection = Direction.SOUTH;
        rover.initialize(startingPosition, startingDirection);
        assertThat(rover.getCurrentPosition(), is(startingPosition));
        assertThat(rover.getCurrentDirection(), is(startingDirection));

        rover.enterSingleCommand('f');

        assertThat(rover.getCurrentPosition(), equalTo(new Position(0, 3)));

    }

    @Test
    public void testMoveRoverForwardDirectionWest() {
        MarsRover rover = new MarsRover();

        Position startingPosition = new Position(0, 0);
        Direction startingDirection = Direction.WEST;
        rover.initialize(startingPosition, startingDirection);
        assertThat(rover.getCurrentPosition(), is(startingPosition));
        assertThat(rover.getCurrentDirection(), is(startingDirection));

        rover.enterSingleCommand('f');

        assertThat(rover.getCurrentPosition(), equalTo(new Position(3, 0)));

    }

    @Test
    public void testMoveRoverForwardDirectionNorth() {
        MarsRover rover = new MarsRover();

        Position startingPosition = new Position(0, 0);
        Direction startingDirection = Direction.NORTH;
        rover.initialize(startingPosition, startingDirection);
        assertThat(rover.getCurrentPosition(), is(startingPosition));
        assertThat(rover.getCurrentDirection(), is(startingDirection));

        rover.enterSingleCommand('f');

        assertThat(rover.getCurrentPosition(), equalTo(new Position(0, 1)));

    }

    @Test
    public void testMoveRoverWithMultipleCommands() {
        MarsRover rover = new MarsRover();

        Position startingPosition = new Position(0, 0);
        Direction startingDirection = Direction.NORTH;
        rover.initialize(startingPosition, startingDirection);
        assertThat(rover.getCurrentPosition(), is(startingPosition));
        assertThat(rover.getCurrentDirection(), is(startingDirection));

        char[] commands = {'f', 'r', 'f', 'l', 'f', 'l', 'b'};

        rover.enterCommands(commands);

        assertThat(rover.getCurrentPosition(), equalTo(new Position(2, 2)));

    }

    @Test
    public void testMoveRoverOutOfGrid() {
        MarsRover rover = new MarsRover();

        Position startingPosition = new Position(0, 0);
        Direction startingDirection = Direction.EAST;
        rover.initialize(startingPosition, startingDirection);
        assertThat(rover.getCurrentPosition(), is(startingPosition));
        assertThat(rover.getCurrentDirection(), is(startingDirection));

        char[] commands = {'f', 'f', 'f', 'f', 'f', 'f', 'f'};

        rover.enterCommands(commands);

        assertThat(rover.getCurrentPosition(), equalTo(new Position(3, 0)));

    }
}
