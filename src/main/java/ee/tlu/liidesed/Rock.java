/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.tlu.liidesed;

/**
 *
 * @author Merily.Rooparg
 */
public class Rock implements PlacedObject {

    int x, y;

    public Rock(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
 
    @Override
    public String toString() {
        return "o";
    }
    
}
