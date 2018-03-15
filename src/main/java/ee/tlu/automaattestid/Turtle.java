package ee.tlu.automaattestid;

/**
 *
 * @author Merily.Rooparg
 */
public class Turtle {

    
    public enum Angle {
        right, down, left, up;
        private static Angle[] vals = values();
        public Angle next() {
            return vals[(this.ordinal()+1) % vals.length];
        }
        public Angle previous() {
            if (this.ordinal () == 0)
                return vals [vals.length - 1];
            return vals[(this.ordinal()-1) % vals.length];
        }
    };
        
    Angle angle;
    private int x, y;
    
    public Turtle(int tx, int ty) {
        x = tx;
        y = ty;
        angle = Angle.right;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public Angle getAngle() {
        System.out.println("Angle - "+angle);
        return angle;
    }

    public void rotateRight() {
        angle = angle.next();
    }
    
    public void rotateLeft() {
        angle = angle.previous();
    }
    
    /**
     * Take 1 step in direction
     */
    public void step () {
        switch (angle) {
            case right:
                x ++;
                break;
            case down:
                y ++;
                break;
            case left:
                x --;
                break;
            case up: 
                y --;
                break;
        }
    }

    @Override
    public String toString() {
        switch (angle) {
            case right:
                return ">";
            case down:
                return "v";
            case left:
                return "<";
            case up: 
                return "^";
        }
        return null;
    }
    
    
    
}
