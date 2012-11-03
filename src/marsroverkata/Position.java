package marsroverkata;

/**
 *
 * @author bfindeiss
 */
class Position {

    private int xValue;
    private int yValue;
  
    public Position(int x, int y) {
        xValue = x;
        yValue = y;
       
    }

    public int getxValue() {
        return xValue;
    }

    public void setxValue(int xValue) {
        this.xValue = xValue;
    }

    public int getyValue() {
        return yValue;
    }

    public void setyValue(int yValue) {
        this.yValue = yValue;
    }

    public Position moveInDirection(Direction facing) {
        

        if (Direction.EAST.equals(facing)) {
            xValue++;
        }
        if (Direction.SOUTH.equals(facing)) {
            yValue--;
        }
        if (Direction.WEST.equals(facing)) {
            xValue--;
        }
        if (Direction.NORTH.equals(facing)) {
            yValue++;
        }

        return this;

    }

    public Position moveInOppositeDirection(Direction currentDirection) {
        Direction oppositeDirection = Direction.getOppositeDirection(currentDirection);
        return moveInDirection(oppositeDirection);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.xValue;
        hash = 53 * hash + this.yValue;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.xValue != other.xValue) {
            return false;
        }
        if (this.yValue != other.yValue) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Current Position is (" + this.getxValue() + ", " + this.getyValue() + ");";
    }
}
