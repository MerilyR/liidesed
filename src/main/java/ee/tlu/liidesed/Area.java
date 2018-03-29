/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.tlu.liidesed;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Merily.Rooparg
 */
public class Area {



    

    public enum Command {FWD, BWD}
    
    int w, h;
    char[][] m;
    List <PlacedObject> objects = new ArrayList<>();
    
    public Area(int width, int height) {
        w = width;
        h = height;
        m = new char[w][h];
        clearArea();
        setTurtle (new Turtle (0,0));
        objects.add(turtle);
    }
    
    private void clearArea(){
        turtle = null;
        for (int y = 0; y < m[0].length; y ++ ) 
            for (char[] m1 : m) {
                m1[y] = '.';
            }
    }
    
    public boolean isFree (int x, int y) {
        if (x<0 || y<0)
            return false;
        if (x>=m.length || y>=m[0].length)
            return false;
        
        /*
        for (PlacedObject obj : objects)
            if (obj.getX() == x && obj.getY()==y)
                return false;
        
        OR
        
        if (!objects.stream().noneMatch((obj) -> (obj.getX() == x && obj.getY() == y)))
            return false;
           
        return true;
        */
        
        return objects.stream().noneMatch((obj) -> (obj.getX() == x && obj.getY() == y));
    }
    
    public  boolean isFree(Place p) {
        return isFree (p.getX(), p.getY());
    }
    
    Turtle turtle;
    
    public Turtle getTurtle() {
        return turtle;
    }
    
    private void setTurtle(Turtle t) {
        // remove turtle
        if (turtle != null)
            m [turtle.getX()][turtle.getY()] = '.';
        // set new Turtle
        turtle = t;
        m [turtle.getX()][turtle.getY()] = turtle.toString().charAt(0);
    }
    
    public boolean command (Command c) {
        switch (c) {
            case FWD:
                return moveForward();
            //case BWD:
                //return moveBackward();
        }
        return false;
    }
    
    public boolean command (char c) {
        switch (c) {
            case 'f' :
                return moveForward();
            case ('r'):
                turnRight();
                break;
            case ('l'):
                turnLeft();
                break;
        }
        return true;
    }
    
    public boolean commandsAsString(String s) {
        for (char c : s.toCharArray()) {
            if (!command (c))
                return false;
            else 
                System.out.println(this.toString() + "/n");
        }
        return true;
    }
    
    private boolean moveForward () {
        if (!isFree(turtle.nextPlace()))
            return false;
        
        //if (!outOfArea (turtle))        
        //leave trail - set current position to *
        m [turtle.getX()][turtle.getY()] = '*';
        
        // step to direction
        turtle.step();
        // set new position
        m [turtle.getX()][turtle.getY()] = turtle.toString().charAt(0);
        return true;       
        
    }
    
    private void turnRight () {
        // step to direction
        turtle.rotateRight();
        //if (!outOfArea (turtle))  
        // set new position
        m [turtle.getX()][turtle.getY()] = turtle.toString().charAt(0);
    }
    
    private void turnLeft () {
        // step to direction
        turtle.rotateLeft();
        //if (!outOfArea (turtle))  
        // set new position
        m [turtle.getX()][turtle.getY()] = turtle.toString().charAt(0);
    }
    /* NOT used, cause isFree already stops (should!) the turtle from moving out of the area
    private boolean outOfArea (Turtle t) {
        if (t.getX () >= 0 && t.getY()   >= 0)
            return false;
        
        System.out.println("Turtle is out of area!!!");
        return true;
    }
    */
    
    public boolean addRock(int x, int y) {
        
        if (!isFree(x, y))
            return false;
        
        Rock r = new Rock(x, y);
        objects.add(r);
        m [r.getX()][r.getY()] = r.toString().charAt(0);
        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < m[0].length; y ++ ) {
            for (char[] m1 : m) {
                sb.append(m1[y]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
