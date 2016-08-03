/**
 * Created by Abim, David and Ethan
 * AP Computer Science
 * August 2016
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
    private Bar bar1;
    private Bar bar2;
    private Bar bar3;
    private Bar bar4;
    
    
	private static GOval hitOval;  //is it ok to make this static 

    public static void main(String[] args) 		// in case you want to run as application rather than applet 
    {
        new Board().start();
    }
    
    Color pb = new Color(0, 0, 0);
	Color sp = new Color(125, 125, 125);
	double tick = .001;
	double gravconstant = 3;
	private Spring sprong = new Spring(6, 40, this, 477, 705);
	private Ball pinball = new Ball(477, 600, pb, 8, 0, 0, this, sprong);
	private FlipperLeft lflip = new FlipperLeft(190, 640, Color.BLACK, this, pinball);
	private FlipperRight rflip = new FlipperRight(350, 640, Color.BLACK, this, pinball);
	
	public void keyPressed(KeyEvent s)
	{
		if (s.getKeyChar() == 's')
			sprong.springdown();
		if (s.getKeyChar() == 'a')
			lflip.goUp();
		if (s.getKeyChar() == 'd')
			rflip.goUp();
	}
	public void keyReleased(KeyEvent s)
	{
		if (s.getKeyChar() == 's')
			sprong.release();
		if (s.getKeyChar() == 'a')
			lflip.goDown();
		if (s.getKeyChar() == 'd')
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
        
        bar1 = new Bar(95, 106, 14, 44);
        	bar1.setVisible(false);
        bar2 = new Bar(152, 106, 14, 44);
        	bar2.setVisible(false);
        bar3 = new Bar(207, 106, 14, 44);
        	bar3.setVisible(false);
        bar4 = new Bar(263, 106, 14, 44);
        	bar4.setVisible(false);

        hitOval = new GOval(43, 51, 454, 700);
        hitOval.setVisible(false); 
        
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
        add(bar1);
        add(bar2);
        add(bar3);
        add(bar4);
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
    
    public static GOval getMyHitOval()
    {
        return hitOval;
    }

    public Score getMyScoreBoard()
    {
        return scoreBoard;
    }
}