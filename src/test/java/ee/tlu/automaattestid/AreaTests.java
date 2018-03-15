
package ee.tlu.automaattestid;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
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
    public void mvoeTest() {
        a.command (Area.Command.FWD);
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
        a.commandsAsString ("frff");
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
        a.commandsAsString ("lfflfffrffrffffffl");
        assertThat (a.toString(), is (
                    "***.*.*...\n"+
                    "..*.*.*...\n"+
                    "..***.*...\n"+
                    "......*...\n"+
                    "......*...\n"+
                    "......>...\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"+
                    "..........\n"
        ));
    }
    
}
