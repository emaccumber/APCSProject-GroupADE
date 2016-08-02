/**
 * Created by Abim, David and Ethan on 8/1/16
 * AP Computer Science
 */

import java.awt.Color;
import acm.graphics.GOval;

public class Ball extends GOval{
	private double XVelocity;
	private double YVelocity;
	private double power;
	private Board myBoard;
	private Spring sprong;
	private boolean springed = false;
	
	private double tanSlope; 
	private double xToUse = getX() - 227;
	private double yToUse = getY() + 357.1; 
	private double d; 
	private double b; 
	
	public Ball(double x, double y, Color c, double r, double xVel, double yVel, Board box, Spring spring)
	    {
	        super(x, y, 2*r, 2*r);
	        setColor(c);
	        setFillColor(c);
	        setFilled(true);
	        XVelocity = xVel;
	        YVelocity = yVel;
	        myBoard = box;
	        sprong = spring;
	    }
	public void gravitAdd(double constant)
	{
		double change=constant / 1000;
		YVelocity = YVelocity + change;
	}
	public double getXVel()
	{
		return XVelocity;
	}
	public double getYVel()
	{
		return YVelocity;
	}
	public void changeVel(double x, double y){
		XVelocity=XVelocity+x;
		YVelocity=YVelocity+y;
	}
	public void boundaryHit(){
		
		if(getY() + getHeight() >= (myBoard.getHeight() - 51) && YVelocity > 0)
		{
			YVelocity = YVelocity * -1;
		}
		if(getY() <= 51 && YVelocity < 0)
		{
			YVelocity = YVelocity * -1;
		}
		if(getX() <= 43 && XVelocity < 0)
		{
			XVelocity = XVelocity * -1;
		}
		if(getX() + getWidth() >= (myBoard.getWidth() - 43) && XVelocity > 0)
		{
			XVelocity = XVelocity * -1;
		}
		
		if ((getY() + getHeight()) >= myBoard.getY() && (getY() <= (myBoard.getSideBars().getY() +
                myBoard.getSideBars().getHeight())) && (getX() <= (myBoard.getSideBars().getX() +
                myBoard.getSideBars().getWidth())))
		{
          XVelocity = -XVelocity;
		}
		
	/*	if (!board.getMyhitOval().contains(getX(), getY()))
		{
			
			tanSlope = (-1) / ((-12755 * xToUse) / (5153 * yToUse)); 
			b = yToUse - tanSlope * xToUse; 
			d = (xToUse + (yToUse - b) * tanSlope) / (1 + tanSlope * tanSlope); 
			
			XVelocity = 2 * d - xToUse;
			YVelocity = 2 * d * tanSlope - yToUse + 2 * b;  
			
		} */
          
	
	}
	public void launch()
	{
		springed = false;
		setLocation(sprong.getX() - 5, sprong.getY() - 17);
		YVelocity =- power;
		power = 0;
	}
	public void airResist()
	{
		YVelocity=YVelocity * .9995;
		XVelocity=XVelocity * .9995;
	}
	public double getSpeed()
	{
		double speed = (Math.sqrt((YVelocity * YVelocity) + (XVelocity * XVelocity)));
		return speed;
	}
	public void changeSpSize(double size)
	{
		super.setSize(size, size / 2);
	}
	public void moved(double constant)
	{
		if(!springed)
		{
			gravitAdd(constant);
			boundaryHit();
			airResist();
		}
		if(!(getY() + getHeight() >= sprong.getY() && getX() >= sprong.getX() - 5 
				&& getX() <= sprong.getX() + sprong.getWidth() 
				&& getY() <= sprong.getY() + (sprong.getHeight() * .3) || springed))
		{
			move(XVelocity, YVelocity);
		}
		else if(YVelocity >= 0 && sprong.pulled == 1)
		{
			springed = true;
			XVelocity = 0;
			YVelocity = 0;			
			setLocation(sprong.getX() - 5, sprong.getY() - 10);
			power = sprong.strength;
		}
		else
		{
			launch();
		}
	}
	
}