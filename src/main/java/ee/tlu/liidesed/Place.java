/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.tlu.liidesed;

import ee.tlu.liidesed.PlacedObject;

/**
 *
 * @author Merily.Rooparg
 */
public class Place implements PlacedObject{
    int x, y;

    public Place(int x, int y) {
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
}
