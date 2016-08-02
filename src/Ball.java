import java.awt.Color;
import acm.graphics.GOval;

//APCS Final - Pinball 
//Abim, Ethan, and David 
//Aug 2016
//
public class Ball extends GOval{
	double XVelocity;
	double YVelocity;
	double power;
	Board board;
	Spring sprong;
	boolean springed = false;
	public Ball(double x, double y, Color c, double r, double xVel, double yVel, Board box, Spring spring)
	    {
	        super(x, y, 2*r, 2*r);
	        setColor(c);
	        setFillColor(c);
	        setFilled(true);
	        XVelocity = xVel;
	        YVelocity = yVel;
	        board = box;
	        sprong = spring;
	    }
	public void gravitAdd(double constant)
	{
		double change=constant / 1000;
		YVelocity = YVelocity + change;
	}
	public void boundaryHit(){
		
		if(getY() + getHeight() >= board.getHeight() && YVelocity > 0)
		{
			YVelocity = YVelocity * -1;
		}
		if(getY() <= 0 && YVelocity < 0)
		{
			YVelocity = YVelocity * -1;
		}
		if(getX() <= 0 && XVelocity < 0)
		{
			XVelocity = XVelocity * -1;
		}
		if(getX() + getWidth() >= board.getWidth() && XVelocity > 0)
		{
			XVelocity = XVelocity * -1;
		}
		
		if (((getY() + getHeight()) >= board.getY() - 2) && (getY() <= (board.getSideBars().getY() +
                board.getSideBars().getHeight() - 2)) && (getX() <= (board.getSideBars().getX() +
                board.getSideBars().getWidth())))
		{
          XVelocity = -XVelocity;
		}
          
	
	}
	public void launch()
	{
		springed = false;
		setLocation(sprong.getX() - 3, sprong.getY() - 14);
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
		if(!(getY() + getHeight() >= sprong.getY() && getX() >= sprong.getX() - 3 
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
			setLocation(sprong.getX() - 3, sprong.getY() - 10);
			power = sprong.strength;
		}
		else
		{
			launch();
		}
	}
}