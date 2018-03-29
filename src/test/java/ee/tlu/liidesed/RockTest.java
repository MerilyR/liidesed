/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.tlu.liidesed;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Merily.Rooparg
 */
public class RockTest {
    
    public RockTest() {
    }

    /**
     * Test of getX method, of class Rock.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Rock instance = new Rock(2,5);
        int expResult = 2;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getY method, of class Rock.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Rock instance = new Rock(2,5);
        int expResult = 5;
        int result = instance.getY();
        assertEquals(expResult, result);
    }
    
}
