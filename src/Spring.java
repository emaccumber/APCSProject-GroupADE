
import acm.graphics.GRect;
import java.awt.Color;
public class Spring extends GRect
{
	double ySet;
	double strength = 0;
	int pulled = 0;
	public Spring(double xS, double yS, Color c, Board board, double xP, double yP) 
	{
		super(xP, yP, xS, yS);
		setFilled(true);
		setColor(c);
		ySet = yS;
	}
	public void springdown(){
		pulled = 1;
		if(getHeight() > 6)
		{
			setSize(getWidth(), getHeight() - 2);
			if(strength == 0)
			{
				strength = .05;
			}
			strength = strength * 1.25;
			move(0, 2);
		}
	}
	public void release(){
		pulled = 0;
		double sizechange = ySet - getHeight();
		
		while(getHeight() < ySet)
		{
			move(0, -2);
			setSize(getWidth(), getHeight() + 2);
		}
		setSize(getWidth(), ySet);
		
		strength = 0;
	}
}