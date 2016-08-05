package objects;
/**
 * Created by Abim, David and Ethan
 * AP Computer Science
 * August 2016
 */
import acm.graphics.GRect;
import game.Board;

import java.awt.Color;
public class Spring extends GRect
{
	private double ySet;
	public double strength = 0;
	public int pulled = 0;
	
	public Spring(double xS, double yS, Board board, double xP, double yP) 
	{
		super(xP, yP, xS, yS);
		setVisible(false);
		ySet = yS;
	}
	
	public void springdown() {
		pulled = 1;
		if(getHeight() > 6)
		{
			setSize(getWidth(), getHeight() - 2);
			if(strength == 0)
			{
				strength = .25;
			}
			strength = strength * 1.20;
			move(0, 2);
		}
	}
	
	public void release() {
	
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