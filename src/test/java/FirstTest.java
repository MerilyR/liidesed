/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ee.tlu.automaattestid.Turtle;
//import ee.tlu.automaattestid.Turtle.Angle;
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
        assertEquals (3, t.getX());
        assertEquals (5, t.getY());
        assertEquals (1, t.getDirection());
    }
    @Test
    public void turnRightTest() {
        assertEquals (1, t.getDirection());
//        assertEquals (Angle.right, t.getAngle());
        t.rotateRight();
        assertEquals (2, t.getDirection());
//        assertEquals (Angle.down, t.getAngle());
        t.rotateRight();
        assertEquals (3, t.getDirection());
        t.rotateRight();
        assertEquals (4, t.getDirection());
//        assertEquals (Angle.up, t.getAngle());
        t.rotateRight();
        assertEquals (1, t.getDirection());
    }
    @Test
    public void turnLefttTest() {
        assertEquals (1, t.getDirection());
        t.rotateLeft();
        assertEquals (4, t.getDirection());
//        assertEquals (Angle.up, t.getAngle());
        t.rotateLeft();
        assertEquals (3, t.getDirection());
        t.rotateLeft();
        assertEquals (2, t.getDirection());
//        assertEquals (Angle.down, t.getAngle());
        t.rotateLeft();
        assertEquals (1, t.getDirection());
    }
    
    @Test public void moveTest() {
        assertEquals (3, t.getX());
        assertEquals (5, t.getY());
        assertEquals (1, t.getDirection());
        t.step();
        assertEquals (4, t.getX());
        assertEquals (5, t.getY());
        assertEquals (1, t.getDirection());
    }
}
