/**
 * Created by Abim, David and Ethan
 * AP Computer Science
 * August 2016
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
	private double spcp = 3.5;
	private double tanSlope; 
	
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
		double change = constant / 1000;
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
		
		if (getY() + getHeight() >= (myBoard.getHeight() - 51) && YVelocity > 0)
		{ 
			YVelocity = YVelocity * -1;
		}
		if (getY() <= 51 && YVelocity < 0)
		{
			YVelocity = YVelocity * -1;
		}
		if (getX() <= 43 && XVelocity < 0)
		{
			XVelocity = XVelocity * -1;
		}
		if (getX() + getWidth() >= (myBoard.getWidth() - 43) && XVelocity > 0)
		{
			XVelocity = XVelocity * -1;
		}
		
		if ((getX() <= (myBoard.getSideBars().getX() + myBoard.getSideBars().getWidth())) 
				&& (getY() > myBoard.getSideBars().getY() 
						&& (getY() + getHeight() - 2) < (myBoard.getSideBars().getY() + myBoard.getSideBars().getHeight())))
			XVelocity = -XVelocity;
		
		if (getX() < (myBoard.getSideBars().getX() + myBoard.getSideBars().getWidth() - 4) 
				&& (getY() + getHeight()) >= myBoard.getSideBars().getY() 
				&& (getY() + getHeight()) <  (myBoard.getSideBars().getY() + 34))
			
			YVelocity = -YVelocity;
		
		if (getX() < (myBoard.getSideBars().getX() + myBoard.getSideBars().getWidth() - 4) 
				&& getY() <= (myBoard.getSideBars().getY() + myBoard.getSideBars().getHeight())
				&& (getY() >  (myBoard.getSideBars().getY() + myBoard.getSideBars().getHeight() - 34 )))
			
			YVelocity = -YVelocity;
				 
		if (!myBoard.getHitOval().contains(getX() + 8, getY() + 8 ) && getY() < 400 && getX() > 268) 
		{
			tanSlope = ((-1) / ((-12755 * getX() + 2895385) / (5153 * -getY() + 1839621)));
			XVelocity -= .2;
			YVelocity += .2 * tanSlope;
		}
		
		// bar1
		
		if (getX() <= myBoard.getBar1().getX() + myBoard.getBar1().getWidth() 
				&& getY() + getHeight() > myBoard.getBar1().getY() 
				&& getY() < myBoard.getBar1().getY() + myBoard.getBar1().getHeight()
				&& getX() > myBoard.getBar1().getX() + myBoard.getBar1().getWidth() - 6)
			XVelocity = -XVelocity;
		
		if (getX() + getWidth() >= myBoard.getBar1().getX()
				&& getY() + getHeight() > myBoard.getBar1().getY() 
				&& getY() < myBoard.getBar1().getY() + myBoard.getBar1().getHeight()
				&& getX() + getWidth() < myBoard.getBar1().getX() + 6)
			XVelocity = -XVelocity;
		
		if (getY() + getHeight() >= myBoard.getBar1().getY()
				&& getX() < myBoard.getBar1().getX() + myBoard.getBar1().getWidth()
				&& getX() + getWidth() > myBoard.getBar1().getX() 
				&& getY() - getHeight() < myBoard.getBar1().getY() + 21)
			YVelocity = -YVelocity;  
	
		if (getY() <= myBoard.getBar1().getY() + myBoard.getBar1().getHeight()
				&& getX() < myBoard.getBar1().getX() + myBoard.getBar1().getWidth()
				&& getX() - getWidth() > myBoard.getBar1().getX()
				&& getY() > myBoard.getBar1().getY() + myBoard.getBar1().getHeight() - 21)
			YVelocity = -YVelocity; 
		
		if (getY() + getHeight() == myBoard.getBar1().getY()
				&& getX() == myBoard.getBar1().getX() + myBoard.getBar1().getWidth())
		{
			YVelocity = -YVelocity;
			XVelocity = -XVelocity;
		}
		
		if (getY() + getHeight() == myBoard.getBar1().getY()
				&& getX() - getWidth() == myBoard.getBar1().getX())
		{
			YVelocity = -YVelocity;
			XVelocity = -XVelocity;
		}
		
		if (getY() == myBoard.getBar1().getY() + myBoard.getBar1().getHeight()
				&& getX() - getWidth() == myBoard.getBar1().getX())
		{
			YVelocity = -YVelocity;
			XVelocity = -XVelocity;
		}
		
		if (getY() == myBoard.getBar1().getY() + myBoard.getBar1().getHeight()
				&& getX() == myBoard.getBar1().getX() + myBoard.getBar1().getWidth())
		{
			YVelocity = -YVelocity;
			XVelocity = -XVelocity;
		}
		
		// bar 2
		
		if (getX() <= myBoard.getBar2().getX() + myBoard.getBar2().getWidth() 
				&& getY() + getHeight() > myBoard.getBar2().getY() 
				&& getY() < myBoard.getBar2().getY() + myBoard.getBar2().getHeight()
				&& getX() > myBoard.getBar2().getX() + myBoard.getBar2().getWidth() - 6)
			XVelocity = -XVelocity;
		
		if (getX() + getWidth() >= myBoard.getBar2().getX()
				&& getY() + getHeight() > myBoard.getBar2().getY() 
				&& getY() < myBoard.getBar2().getY() + myBoard.getBar2().getHeight()
				&& getX() + getWidth() < myBoard.getBar2().getX() + 6)
			XVelocity = -XVelocity;
		
		if (getY() + getHeight() >= myBoard.getBar2().getY()
				&& getX() < myBoard.getBar2().getX() + myBoard.getBar2().getWidth()
				&& getX() + getWidth() > myBoard.getBar2().getX()
				&& getY() - getHeight() < myBoard.getBar2().getY() + 21)
			YVelocity = -YVelocity; 
		
		if (getY() <= myBoard.getBar2().getY() + myBoard.getBar2().getHeight()
				&& getX() < myBoard.getBar2().getX() + myBoard.getBar2().getWidth()
				&& getX() - getWidth() > myBoard.getBar2().getX()
				&& getY() > myBoard.getBar2().getY() + myBoard.getBar2().getHeight() - 21)
			YVelocity = -YVelocity; 
		
		if (getY() + getHeight() == myBoard.getBar2().getY()
				&& getX() == myBoard.getBar2().getX() + myBoard.getBar2().getWidth())
		{
			YVelocity = -YVelocity;
			XVelocity = -XVelocity;
		}
		
		if (getY() + getHeight() == myBoard.getBar2().getY()
				&& getX() - getWidth() == myBoard.getBar2().getX())
		{
			YVelocity = -YVelocity;
			XVelocity = -XVelocity;
		}
		
		if (getY() == myBoard.getBar2().getY() + myBoard.getBar2().getHeight()
				&& getX() - getWidth() == myBoard.getBar2().getX())
		{
			YVelocity = -YVelocity;
			XVelocity = -XVelocity;
		}
		
		if (getY() == myBoard.getBar2().getY() + myBoard.getBar2().getHeight()
				&& getX() == myBoard.getBar2().getX() + myBoard.getBar2().getWidth())
		{
			YVelocity = -YVelocity;
			XVelocity = -XVelocity;
		}
		
		// bar 3
		
		if (getX() <= myBoard.getBar3().getX() + myBoard.getBar3().getWidth() 
				&& getY() + getHeight() > myBoard.getBar3().getY() 
				&& getY() < myBoard.getBar3().getY() + myBoard.getBar3().getHeight()
				&& getX() > myBoard.getBar3().getX() + myBoard.getBar3().getWidth() - 6)
			XVelocity = -XVelocity;
		
		if (getX() + getWidth() >= myBoard.getBar3().getX()
				&& getY() + getHeight() > myBoard.getBar3().getY() 
				&& getY() < myBoard.getBar3().getY() + myBoard.getBar3().getHeight()
				&& getX() + getWidth() < myBoard.getBar3().getX() + 6)
			XVelocity = -XVelocity;
		
		if (getY() + getHeight() >= myBoard.getBar3().getY()
				&& getX() < myBoard.getBar3().getX() + myBoard.getBar3().getWidth()
				&& getX() + getWidth() > myBoard.getBar3().getX()
				&& getY() - getHeight() < myBoard.getBar3().getY() + 21)
			YVelocity = -YVelocity; 
		
		if (getY() <= myBoard.getBar3().getY() + myBoard.getBar3().getHeight()
				&& getX() < myBoard.getBar3().getX() + myBoard.getBar3().getWidth()
				&& getX() - getWidth() > myBoard.getBar3().getX()
				&& getY() > myBoard.getBar3().getY() + myBoard.getBar3().getHeight() - 21)
			YVelocity = -YVelocity; 
		
		if (getY() + getHeight() == myBoard.getBar3().getY()
				&& getX() == myBoard.getBar3().getX() + myBoard.getBar3().getWidth())
		{
			YVelocity = -YVelocity;
			XVelocity = -XVelocity;
		}
		
		if (getY() + getHeight() == myBoard.getBar3().getY()
				&& getX() - getWidth() == myBoard.getBar3().getX())
		{
			YVelocity = -YVelocity;
			XVelocity = -XVelocity;
		}
		
		if (getY() == myBoard.getBar3().getY() + myBoard.getBar3().getHeight()
				&& getX() - getWidth() == myBoard.getBar3().getX())
		{
			YVelocity = -YVelocity;
			XVelocity = -XVelocity;
		}
		
		if (getY() == myBoard.getBar3().getY() + myBoard.getBar3().getHeight()
				&& getX() == myBoard.getBar3().getX() + myBoard.getBar3().getWidth())
		{
			YVelocity = -YVelocity;
			XVelocity = -XVelocity;
		}
		
		// bar4
		
		if (getX() <= myBoard.getBar4().getX() + myBoard.getBar4().getWidth() 
				&& getY() + getHeight() > myBoard.getBar4().getY() 
				&& getY() < myBoard.getBar4().getY() + myBoard.getBar4().getHeight()
				&& getX() > myBoard.getBar4().getX() + myBoard.getBar4().getWidth() - 6)
			XVelocity = -XVelocity;
		
		if (getX() + getWidth() >= myBoard.getBar4().getX()
				&& getY() + getHeight() > myBoard.getBar4().getY() 
				&& getY() < myBoard.getBar4().getY() + myBoard.getBar4().getHeight()
				&& getX() + getWidth() < myBoard.getBar4().getX() + 6)
			XVelocity = -XVelocity;
		
		if (getY() + getHeight() >= myBoard.getBar4().getY()
				&& getX() < myBoard.getBar4().getX() + myBoard.getBar4().getWidth()
				&& getX() + getWidth() > myBoard.getBar4().getX()
				&& getY() - getHeight() < myBoard.getBar4().getY() + 21)
			YVelocity = -YVelocity; 
		
		if (getY() <= myBoard.getBar4().getY() + myBoard.getBar4().getHeight()
				&& getX() < myBoard.getBar4().getX() + myBoard.getBar4().getWidth()
				&& getX() - getWidth() > myBoard.getBar4().getX()
				&& getY() > myBoard.getBar4().getY() + myBoard.getBar4().getHeight() - 21)
			YVelocity = -YVelocity; 
		
		if (getY() + getHeight() == myBoard.getBar4().getY()
				&& getX() == myBoard.getBar4().getX() + myBoard.getBar4().getWidth())
		{
			YVelocity = -YVelocity;
			XVelocity = -XVelocity;
		}
		
		if (getY() + getHeight() == myBoard.getBar4().getY()
				&& getX() - getWidth() == myBoard.getBar4().getX())
		{
			YVelocity = -YVelocity;
			XVelocity = -XVelocity;
		}
		
		if (getY() == myBoard.getBar4().getY() + myBoard.getBar4().getHeight()
				&& getX() - getWidth() == myBoard.getBar4().getX())
		{
			YVelocity = -YVelocity;
			XVelocity = -XVelocity;
		}
		
		if (getY() == myBoard.getBar4().getY() + myBoard.getBar4().getHeight()
				&& getX() == myBoard.getBar4().getX() + myBoard.getBar4().getWidth())
		{
			YVelocity = -YVelocity;
			XVelocity = -XVelocity;
		}
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
	
	public void speedCap()
	{
		if (XVelocity > spcp)
			XVelocity = spcp;
		if (YVelocity > spcp)
			YVelocity = spcp;
		if(XVelocity < -spcp)
			XVelocity = -spcp;
		if(YVelocity < -spcp)
			YVelocity = -spcp;
	}
	
	public void moved(double constant)
	{
		if (!springed)
		{
			gravitAdd(constant);
			boundaryHit();
			airResist();
			speedCap();
		}
		if (!(getY() + getHeight() >= sprong.getY() && getX() >= sprong.getX() - 5 
				&& getX() <= sprong.getX() + sprong.getWidth() 
				&& getY() <= sprong.getY() + (sprong.getHeight() * .3) || springed))
		{
			move(XVelocity, YVelocity);
		}
		else if (YVelocity >= 0 && sprong.pulled == 1)
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