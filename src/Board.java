/**
 * Created by Abim, David and Ethan on 7/27/16
 * AP Computer Science
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
    private Score scoreBoard;
    private CircleBumper circleBumper50;
    private CircleBumper circleBumper10;
    private CircleBumper circleBumper25;
    
	private GOval hitOval = new GOval(43, 51, 454, 700); 

    public static void main(String[] args)
    {
        new Board().start();
    }
    
    Color pb = new Color(0, 0, 0);
	Color sp = new Color(125, 125, 125);
	double tick = .001;
	double gravconstant = 3;
	private Spring sprong = new Spring(6, 40, this, 477, 705);
	private Ball pinball = new Ball(479, 200, pb, 8, 0, 0, this, sprong);
	private FlipperLeft lflip = new FlipperLeft(190, 640, Color.BLACK, this, pinball);
	private FlipperRight rflip = new FlipperRight(350, 640, Color.BLACK, this, pinball);
	
	public void keyPressed(KeyEvent s)
	{
		if(s.getKeyChar() == 's')
			sprong.springdown();
		if(s.getKeyChar() == 'a')
			lflip.goUp();
		if(s.getKeyChar() == 'd')
			rflip.goUp();
	}
	public void keyReleased(KeyEvent s)
	{
		if(s.getKeyChar() == 's')
			sprong.release();
		if(s.getKeyChar() == 'a')
			lflip.goDown();
		if(s.getKeyChar() == 'd')
			rflip.goDown();
	}
	    
	public void init()
    {
    	addKeyListeners(this);
    	setSize(536, 800);
        background = new GImage("Background.png");
        background.setSize(getWidth(), getHeight());
        spring = new GImage("Spring.png", 0, 0);
        spring.setSize(getWidth(), getHeight());
        
        scoreBoard = new Score("0000", 206, 43);
        
        curvedWall = new GImage("CurvedWall.png", 0, 0);

        circleBumper50 = new CircleBumper(278, 238, 25, "CircleBumper50.png", this, pinball);
        circleBumper25 = new CircleBumper(146, 294, 25, "CircleBumper25.png", this, pinball);
        circleBumper10 = new CircleBumper(270, 374, 25, "CircleBumper10.png", this, pinball);
        
        bars = new GImage("Bars.png", 0, 0);
        bars.setSize(getWidth(), getHeight());
        sideBars = new SideBars(55, 340, 11, 134, "SideBars.png", this);
        
        add(background);
        add(curvedWall);
        add(bars);
        add(lflip);
        add(rflip);
    	add(pinball);
        add(sprong);
        add(spring);
        add(hitOval);
        add(scoreBoard);
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
            lflip.move();
            rflip.move();
        }
    }
    
    public SideBars getSideBars()
    {
    	return sideBars;
    }
    
    public GOval getMyhitOval()
    {
        return hitOval;
    }

    public Score getMyScoreBoard()
    {
        return scoreBoard;
    }
}