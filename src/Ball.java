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
	private BallsRemaining myRemain;
	
	public Ball(double x, double y, Color c, double r, double xVel, double yVel, Board box, Spring spring, BallsRemaining remain)
	    {
	        super(x, y, 2*r, 2*r);
	        setColor(c);
	        setFillColor(c);
	        setFilled(true);
	        XVelocity = xVel;
	        YVelocity = yVel;
	        myBoard = box;
	        sprong = spring;
	        myRemain = remain;	        
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
		
		XVelocity = XVelocity+x;
		YVelocity = YVelocity+y;
	}
	
	private void borderHit()
	{
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
	}
	
	private void sideBarHit()
	{
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
	}
	
	private void curvedWallHit()
	{
		if (!myBoard.getHitOval().contains(getX() + 8, getY() + 8 ) && getY() < 400 && getX() > 268) 
		{
			tanSlope = ((-1) / ((-12755 * getX() + 2895385) / (5153 * -getY() + 1839621)));
			XVelocity -= .2;
			YVelocity += .2 * tanSlope;
		}
	}
	
	private void fourBarsHit()
	{
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
	}
	
	private void rightAndLeftSideBarsHit()
	{
		// right side bar
		
				if (getX() <= myBoard.getRightSideBar().getX() + myBoard.getRightSideBar().getWidth() 
						&& getY() + getHeight() > myBoard.getRightSideBar().getY() 
						&& getY() < myBoard.getRightSideBar().getY() + myBoard.getRightSideBar().getHeight()
						&& getX() > myBoard.getRightSideBar().getX() + myBoard.getRightSideBar().getWidth() - 3)
					XVelocity = -XVelocity;
				
				if (getX() + getWidth() >= myBoard.getRightSideBar().getX()
						&& getY() + getHeight() > myBoard.getRightSideBar().getY() 
						&& getY() < myBoard.getRightSideBar().getY() + myBoard.getRightSideBar().getHeight()
						&& getX() + getWidth() < myBoard.getRightSideBar().getX() + 3)
					XVelocity = -XVelocity;
				
				if (getY() + getHeight() >= myBoard.getRightSideBar().getY()
						&& getX() < myBoard.getRightSideBar().getX() + myBoard.getRightSideBar().getWidth()
						&& getX() + getWidth() > myBoard.getRightSideBar().getX() 
						&& getY() - getHeight() < myBoard.getRightSideBar().getY() + 21)
					YVelocity = -YVelocity;  
			
				if (getY() <= myBoard.getRightSideBar().getY() + myBoard.getRightSideBar().getHeight()
						&& getX() < myBoard.getRightSideBar().getX() + myBoard.getRightSideBar().getWidth()
						&& getX() - getWidth() > myBoard.getRightSideBar().getX()
						&& getY() > myBoard.getRightSideBar().getY() + myBoard.getRightSideBar().getHeight() - 21)
					YVelocity = -YVelocity; 
				
				
				// left side bar
				
				if (getX() <= myBoard.getLeftSideBar().getX() + myBoard.getLeftSideBar().getWidth() 
						&& getY() + getHeight() > myBoard.getLeftSideBar().getY() 
						&& getY() < myBoard.getLeftSideBar().getY() + myBoard.getLeftSideBar().getHeight()
						&& getX() > myBoard.getLeftSideBar().getX() + myBoard.getLeftSideBar().getWidth() - 3)
					XVelocity = -XVelocity;
				
				if (getX() + getWidth() >= myBoard.getLeftSideBar().getX()
						&& getY() + getHeight() > myBoard.getLeftSideBar().getY() 
						&& getY() < myBoard.getLeftSideBar().getY() + myBoard.getLeftSideBar().getHeight()
						&& getX() + getWidth() < myBoard.getLeftSideBar().getX() + 3)
					XVelocity = -XVelocity;
				
				if (getY() + getHeight() >= myBoard.getLeftSideBar().getY()
						&& getX() < myBoard.getLeftSideBar().getX() + myBoard.getLeftSideBar().getWidth()
						&& getX() + getWidth() > myBoard.getLeftSideBar().getX() 
						&& getY() - getHeight() < myBoard.getLeftSideBar().getY() + 21)
					YVelocity = -YVelocity;  
			
				if (getY() <= myBoard.getLeftSideBar().getY() + myBoard.getLeftSideBar().getHeight()
						&& getX() < myBoard.getLeftSideBar().getX() + myBoard.getLeftSideBar().getWidth()
						&& getX() - getWidth() > myBoard.getLeftSideBar().getX()
						&& getY() > myBoard.getLeftSideBar().getY() + myBoard.getLeftSideBar().getHeight() - 21)
					YVelocity = -YVelocity; 
	}
	
	public void boundaryHit()
	{
		ballsRemaining();
		borderHit();
		sideBarHit();
		curvedWallHit();
		fourBarsHit();
		rightAndLeftSideBarsHit();
	}
	
	public void launch()
	{
		springed = false;
		setLocation(sprong.getX() - 5, sprong.getY() - 17);
		YVelocity = -power;
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
	
	private void ballsRemaining()
	{	
		if (getY() >= myBoard.getHeight() - 51)
		{ 			
			myRemain.decrement();
			
			if (myRemain.getRemain() >= 0)
			{
			setLocation(472, 680);
			}
			
			else myBoard.endGame();
		}

	}
	
}