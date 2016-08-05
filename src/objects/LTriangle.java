package objects;
/**
 * AP Computer Science
 * August 2016
 */
import java.awt.Color;

import acm.graphics.GPolygon;
import ball.Ball;
import game.Board;

public class LTriangle extends GPolygon{
	
	public Board board;
	public Ball pin;
	private double totalvel;
	private double xvel;
	private double yvel;
	private double angle;
	private boolean debounce=false;
	private double xdist;
	private double ydown;
	
	public LTriangle(double x, double y, Color c, Board box, Ball ping)
	{
		super(x, y);
		setColor(c);
        setFillColor(c);
        setFilled(true);
        board = box;
        pin = ping;
        addVertex(0, 0);
        addVertex(0, 100);
        addVertex(100, 100);
	}
	 
	public boolean hitBox(double x, double y)
	{
		xdist = getX() - x;
		ydown = getY() + (-45 * 3 / 100) * xdist;
		if (ydown < 0)
		{
			ydown = ydown * -1;
		}
		
		if(x <= getX() + 100
				&& x >= getX()
				&& y >= ydown
				&& y <= ydown + 100)
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
		if (hitBox(pin.getX() + (pin.getWidth() / 2), pin.getY() + pin.getHeight()))
		{
			totalvel = Math.sqrt((pin.getXVel() * pin.getXVel()) + (pin.getYVel() * pin.getYVel()));
			angle = Math.toRadians(-45 + 90);
			yvel = Math.sin(angle);
			yvel = yvel * totalvel;
			xvel = Math.cos(angle);
			xvel = xvel * totalvel;
			pin.changeVel(xvel, -yvel);
		}
	}
}