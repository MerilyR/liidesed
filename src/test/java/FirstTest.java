/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ee.tlu.automaattestid.Turtle;
import ee.tlu.automaattestid.Turtle.Angle;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Merily.Rooparg
 */
public class FirstTest {
    
    public FirstTest() {
    }
    @Test
    public void first() {
        assertEquals(5, 3+2);
    }
    Turtle t;
    
    @Before
    public void setUp() {
        t = new Turtle (3, 5);
        System.out.println("Turtle created with parameters "+t.getX() + " & "+t.getY());
    }
    
    @Test
    public void second(){
        assertPosition (3, 5, Angle.right);
    }
    @Test
    public void turnRightTest() {
       assertPosition (3, 5, Angle.right);
        t.rotateRight();
        assertPosition (3, 5, Angle.down);
        t.rotateRight();
        t.rotateRight();
        assertPosition (3, 5, Angle.up);
        t.rotateRight();
    }
    @Test
    public void turnLefttTest() {
        t.rotateLeft();
        assertPosition (3, 5, Angle.up);
        t.rotateLeft();
        t.rotateLeft();
        assertPosition (3, 5, Angle.down);
        t.rotateLeft();
    }
    
    @Test public void moveTest() {
        assertPosition (3, 5, Angle.right);
        t.step();
        assertPosition (4, 5, Angle.right);
        t.rotateRight();
        t.step();
        t.rotateRight();
        t.step();
        assertPosition (3, 6, Angle.left);
    }

    private void assertPosition(int x, int y, Angle angle) {
        assertEquals (x, t.getX());
        assertEquals (y, t.getY());
        assertEquals (angle, t.getAngle());
    }
}
