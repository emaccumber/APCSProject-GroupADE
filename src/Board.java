/**
 * Created by davidmaccumber on 8/1/16.
 */
import acm.graphics.GImage;
import acm.graphics.GOval;

import java.awt.event.*;
import java.awt.*;


import acm.program.GraphicsProgram;
public class Board extends GraphicsProgram {

    private GImage background;
    private GImage curvedWall;
    private GImage bars;
    private GImage spring;
    private SideBars sideBars;
    private CircleBumper circleBumper50;
    private CircleBumper circleBumper10;
    private CircleBumper circleBumper25;
    
	private GOval hitOval = new GOval(43, 51, 454, 714); 

    public static void main(String[] args)
    {
        new Board().start();
    }
    
    Color pb = new Color(0, 0, 0);
	Color sp = new Color(125, 125, 125);
	double tick = .001;
	double gravconstant = 3;
	private Spring sprong = new Spring(6, 40, this, 477, 705);
	private Ball pinball = new Ball(sprong.getX(), sprong.getY(), pb, 8, 0, 0, this, sprong);
	
	public void keyPressed(KeyEvent s)
	{
		if(s.getKeyChar() == 's')
			sprong.springdown();
	}
	public void keyReleased(KeyEvent s)
	{
		if(s.getKeyChar() == 's')
			sprong.release();
	}
	

    public void init()
    {
    	addKeyListeners(this);
    	
    	setSize(536, 800);
        background = new GImage("Background.png");
        background.setSize(getWidth(), getHeight());
        spring = new GImage("Spring.png", 0, 0);
        spring.setSize(getWidth(), getHeight());
        
        curvedWall = new GImage("CurvedWall.png", 0, 0);

        circleBumper50 = new CircleBumper(278, 238, 25, "CircleBumper50.png", this);
        circleBumper25 = new CircleBumper(146, 294, 25, "CircleBumper25.png", this);
        circleBumper10 = new CircleBumper(270, 374, 25, "CircleBumper10.png", this);
        
        bars = new GImage("Bars.png", 0, 0);
        bars.setSize(getWidth(), getHeight());
        sideBars = new SideBars(55, 340, 11, 134, "SideBars.png", this);
        
        add(background);
        add(curvedWall);
        add(bars);
    	add(pinball);
        add(sprong);
        add(spring);
    }

    public void run()
    {
    	sideBars.showSideBars();
        circleBumper50.showBumper();
        circleBumper25.showBumper();
        circleBumper10.showBumper();
        
        while(true)
        {
            pause(tick);
            pinball.moved(gravconstant);
        }
    }
    
    public SideBars getSideBars()
    {
    	return sideBars;
    }

}