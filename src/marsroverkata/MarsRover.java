package marsroverkata;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bfindeiss
 */
public class MarsRover {

    private Position planetSize = null;
    private Position currentPosition = null;
    private Direction currentDirection = Direction.EAST;
    private Map<Character, Method> supportedCommands = new HashMap<Character, Method>() {
        {
            try {
                put('f', MarsRover.class.getMethod("moveForward"));
                put('b', MarsRover.class.getMethod("moveBackward"));
                put('r', MarsRover.class.getMethod("turnRight"));
                put('l', MarsRover.class.getMethod("turnLeft"));
            } catch (Exception ex) {
                Logger.getLogger(MarsRover.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    public void initialize(Position startingPosition, Direction startingDirection) {
        currentDirection = startingDirection;
        currentPosition = startingPosition;
        this.setPlanetSize(new Position(3, 3));
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void enterSingleCommand(char command) {
        if (supportedCommands.keySet().contains(command)) {
            Method currentCommand = supportedCommands.get(command);
            try {
                currentCommand.invoke(this);
            } catch (Exception ex) {
                Logger.getLogger(MarsRover.class.getName()).log(Level.SEVERE, null, ex);
            }

            calculateTruePositionOnPlanet();

        } else {
            throw new UnsupportedOperationException("Command not recognized");
        }
    }

    public void moveForward() {
        currentPosition = currentPosition.moveInDirection(currentDirection);
    }

    public void moveBackward() {
        currentPosition = currentPosition.moveInOppositeDirection(currentDirection);
    }

    public void turnRight() {
        currentDirection = Direction.turnRight(currentDirection);
    }

    public void turnLeft() {
        currentDirection = Direction.turnLeft(currentDirection);
    }

    void enterCommands(char[] commands) {
        for (char command : commands) {
            enterSingleCommand(command);
        }
    }

    private void calculateTruePositionOnPlanet() {
        int xPlanetSize = this.getPlanetSize().getxValue() + 1;
        int yPlanetSize = this.getPlanetSize().getyValue() + 1;

        int trueXPosition = (this.getCurrentPosition().getxValue() + xPlanetSize) % xPlanetSize;
        int trueYPosition = (this.getCurrentPosition().getyValue() + yPlanetSize) % yPlanetSize;
        
        this.getCurrentPosition().setxValue(trueXPosition);
        this.getCurrentPosition().setyValue(trueYPosition);

    }

    public Position getPlanetSize() {
        return planetSize;
    }

    public void setPlanetSize(Position planetSize) {
        this.planetSize = planetSize;
    }
}
