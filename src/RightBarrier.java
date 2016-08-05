/**
 * AP Computer Science
 * August 2016
 */
import java.awt.Color;

import acm.graphics.GPolygon;

public class RightBarrier extends GPolygon{
	
	private Board board;
	private Ball pin;
	private double totalvel;
	private double xvel;
	private double yvel;
	private double angle;
	private boolean debounce=false;
	private double xdist;
	private double ydown;
	
	public RightBarrier(double x, double y, Color c, Board box, Ball ping)
	{
		super(x, y);
		setColor(Color.red);
        board = box;
        pin = ping;
        addVertex(0, 0);        
        addVertex(-110, 0);
        addVertex(-110, 10);
        addVertex(0, 10);
        rotate(23);
        setVisible(false);
	}
	public boolean hitBox(double x, double y)
	{
		xdist = getX() - x;
		ydown = getY() + (23 * 2.0 / 100) * xdist;
		if (ydown < 0)
		{
			ydown = ydown * -1;
		}
		if (x >= getX() - 110
				&& x <= getX()
				&& y >= ydown
				&& y <= ydown + 11)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void checkForHits()
	{
		if (hitBox(pin.getX() + (pin.getWidth() / 2), pin.getY() + pin.getHeight())
				&& pin.getYVel()>=0)
		{
			totalvel = Math.sqrt((pin.getXVel() * pin.getXVel()) + (pin.getYVel() * pin.getYVel()));
			angle = Math.toRadians(23 + 90);
			yvel = Math.sin(angle);
			yvel = yvel * totalvel;
			xvel = Math.cos(angle);
			xvel = xvel * totalvel;
			pin.changeVel(xvel, -yvel);
		}
		else if(hitBox(pin.getX() + (pin.getWidth() / 2), pin.getY() + pin.getHeight())
				&& pin.getYVel()<0
				&&pin.getY()>=ydown+3){
			totalvel = Math.sqrt((pin.getXVel() * pin.getXVel()) + (pin.getYVel() * pin.getYVel()));
			angle = Math.toRadians(23 + 90);
			yvel = Math.sin(angle);
			yvel = yvel * totalvel;
			xvel = Math.cos(angle);
			xvel = xvel * totalvel;
			pin.changeVel(-xvel, yvel);
		}
	}
}