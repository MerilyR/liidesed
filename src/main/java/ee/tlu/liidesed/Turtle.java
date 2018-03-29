package ee.tlu.liidesed;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Merily.Rooparg
 */
public class Turtle implements PlacedObject {

    public enum Angle {
        right, down, left, up;
        private static final Angle[] vals = values();
        public Angle next() {
            return vals[(this.ordinal()+1) % vals.length];
        }
        public Angle previous() {
            if (this.ordinal () == 0)
                return vals [vals.length - 1];
            return vals[(this.ordinal()-1) % vals.length];
        }
    };
        
//    Angle angle;
//    private int x, y;
    
    Map<String, Object> data = new HashMap<>();
    
    public Turtle(int tx, int ty) {
        setX(tx);
        setY(ty);
        setAngle(Angle.right);
    }

    @Override
    public int getX() {
        return (int) data.get("x");
    }

    @Override
    public int getY() {
        return (int) data.get("y");
    }
    
    public Angle getAngle() {
        return (Angle) data.get("angle");
    }

    private void setX(int tx) {
        data.put("x", tx);
    } 
    
    private void setY(int ty) {
        data.put("y", ty);
    }
    
    private void setAngle(Angle angle) {
        data.put("angle", angle);
    }
    
    public void rotateRight() {
        setAngle(getAngle().next());
    }
    
    public void rotateLeft() {
        setAngle(getAngle().previous());
    }
    
    /**
     * Take 1 step in direction
     */
    public void step () {
        switch (getAngle()) {
            case right:
                setX (getX() + 1);
                break;
            case down:
                setY (getY() + 1);
                break;
            case left:
                setX (getX() - 1);
                break;
            case up: 
                setY (getY() - 1);
                break;
        }
    }

    @Override
    public String toString() {
        switch (getAngle()) {
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
