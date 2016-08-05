package objects;
/**
* Created by Abim, David and Ethan
 * AP Computer Science
 * August 2016
 */

import java.awt.Color;
import acm.graphics.GRect;

public class Bar extends GRect {
	public Bar(double x, double y, double w, double h)
    {
        super(x, y, w, h);
        setColor(Color.red);
        setVisible(false);
    }

}
