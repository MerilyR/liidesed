
package ee.tlu.liidesed;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Merily.Rooparg
 */
public class AreaTests {
    
    public AreaTests() {
    }

    Area a;
    
    @Before
    public void setUp(){
        a = new Area (10,10);
    }
    @Test
    public void create() {
        assertThat (a.getTurtle().getX(), is(0));
        assertThat (a.toString(), is (
                    ">.........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"
        ));
    }
    
    @Test
    public void moveTest() {
        assertTrue (a.command (Area.Command.FWD));
        assertThat (a.toString(), is (
                    "*>........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"
        ));
        assertTrue (a.commandsAsString ("frff"));
        assertThat (a.toString(), is (
                    "***.......\n"+
                    "..*.......\n"+
                    "..v.......\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"
        ));
        assertFalse (a.commandsAsString ("lfflfffrffrffffffl"));
        assertThat (a.toString(), is (
                    "***.^.....\n"+
                    "..*.*.....\n"+
                    "..***.....\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"
        ));
    }
    
    @Test
    public void isFreeTest () {
        assertFalse (a.isFree(0, 0));
        assertTrue (a.isFree(1, 0));
        assertFalse (a.isFree (-1, 5));
        assertFalse (a.isFree(9, 10));
    }
    
    @Test
    public void smallAreaTest () {
        Area area = new Area (3, 6);
        area.commandsAsString("frff");
        assertTrue (area.isFree (2, 5));
        assertFalse (area.isFree (5, 2));
        assertTrue (area.isFree (0,0));
        assertFalse (area.isFree (1, 2));
    }
    
    @Test
    public void areaRockTest () {
        Area area = new Area (5, 5);
        area.addRock (2, 3);
        assertFalse (area.isFree(2, 3));
        area.addRock (3, 2);
        assertFalse (area.isFree(3, 2));
        
        assertFalse (area.addRock(0,0));
        assertTrue (area.addRock (1, 2));
        assertFalse (area.addRock (1,2));
    
    }
    
    public void rockTest () {
        assertTrue (a.addRock(8, 8));
        
        assertThat (a.toString(), is (
                    ">.........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "........o.\n"+
                    "..........\n"
        ));
    }
    
    
    public void turtleAgainstRockTest () {
        a.commandsAsString ("ffrff");
        assertThat (a.toString(), is (
                    "***.......\n"+
                    "..*.......\n"+
                    "..v.......\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"
        ));
        
        assertTrue (a.addRock(4, 3));
        assertThat (a.toString(), is (
                    "***.......\n"+
                    "..*.......\n"+
                    "..v.......\n"+
                    "..o.......\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"
        ));
        assertFalse (a.command('f'));
    }
}
