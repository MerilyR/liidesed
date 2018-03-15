/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ee.tlu.automaattestid.Turtle;
import org.junit.Test;
import static org.junit.Assert.*;

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
    @Test
    public void second(){
        Turtle t = new Turtle (3, 5);
        assertEquals (3, t.getX());
        assertEquals (5, t.getY());
    }
}
