package ee.tlu.automaattestid;

/**
 *
 * @author Merily.Rooparg
 */
public class Turtle {

    /*
    public enum Angle {
        right, down, left, up;
        public Angle next() {
            switch (this) {
                case right  : return down;
                case down   : return left;
                case left   : return up;
                case up     : return right;
                default: return null;
            }
        }
        public Angle previous() {
            switch (this) {
                case right  : return up;
                case down   : return right;
                case left   : return down;
                case up     : return left;
                default: return null;
            }
        }
        private static Angle[] vals = values();
        public Angle nextAngle() {
            return vals[(this.ordinal()+1) % vals.length];
        }
        public Angle previousAngle() {
            if (this.ordinal () == 0)
                return vals [vals.length - 1];
            return vals[(this.ordinal()-1) % vals.length];
        }
    };
    */
    
//    Angle angle;
    int direction;
    private int x, y;
    
    public Turtle(int tx, int ty) {
        x = tx;
        y = ty;
        direction = 1;
//        angle = Angle.right;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public int getDirection(){
        return direction;
    }
    
//    public Angle getAngle() {
//        System.out.println("Angle - "+angle);
//        return angle;
//    }

    public void rotateRight() {
//        angle = angle.next();
//        angle = angle.nextAngle();
        direction ++;
        if (direction > 4)
            direction = direction - 4;
    }
    
    public void rotateLeft() {
//        angle = angle.previous();
//        angle = angle.previousAngle();
        direction --;
        if (direction < 1)
            direction = direction + 4;
    }
    
    /**
     * Take 1 step in direction
     */
    public void step () {
        switch(direction) {
            case 1:
                x ++;
                break;
            case 2:
                y ++;
                break;
            case 3:
                x --;
                break;
            case 4: 
                y --;
                break;
        }
    }
    
}
