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
    private GImage border;
    private GImage curvedWall;
    private GImage bars;
    private GImage spring;
    private GImage sideWalls;
    private SideBars sideBars;
    private Score scoreBoard;
    private CircleBumper circleBumper50;
    private CircleBumper circleBumper10;
    private CircleBumper circleBumper25;
    private Bar bar1;
    private Bar bar2;
    private Bar bar3;
    private Bar bar4;
	private GOval hitOval; 

    public static void main(String[] args) 		// in case you want to run as application rather than applet 
    {
        new Board().start();
    }
    
    Color pb = new Color(0, 0, 0);
	Color sp = new Color(125, 125, 125);
	double tick = 1;
	double gravconstant = 3;
	private Spring sprong = new Spring(6, 40, this, 477, 705);
	private Ball pinball = new Ball(472, 680, pb, 8, 0, 0, this, sprong);
	private FlipperLeft lflip = new FlipperLeft(190, 660, Color.BLACK, this, pinball);
	private FlipperRight rflip = new FlipperRight(350, 660, Color.BLACK, this, pinball);
	private RightBarrier rBar = new RightBarrier(450, 620, Color.BLACK, this, pinball);
	private LeftBarrier lBar = new LeftBarrier(90, 620, Color.BLACK, this, pinball);
	private LTriangle ltri = new LTriangle(45, 647, Color.BLACK, this, pinball);
	private RTriangle rtri = new RTriangle(461, 670, Color.BLACK, this, pinball);
	
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
        border = new GImage("Border.png");
        	border.setSize(getWidth(), getHeight());
        background.setSize(getWidth(), getHeight());
        spring = new GImage("Spring.png", 0, 0);
        spring.setSize(getWidth(), getHeight());
        sideWalls = new GImage("SideWalls.png", 0, 0);
        
        bar1 = new Bar(93, 112, 17, 48);    
        bar2 = new Bar(150, 112, 17, 48);        
        bar3 = new Bar(205, 112, 17, 48);       
        bar4 = new Bar(261, 112, 17, 48);
        

        hitOval = new GOval(43, 51, 454, 700);
        hitOval.setVisible(false); 
        
        scoreBoard = new Score("0000", 206, 43);
        
        curvedWall = new GImage("CurvedWall.png", 0, 0);

        circleBumper50 = new CircleBumper(278, 238, 25, "CircleBumper50.png", this, pinball, scoreBoard, 50);
        circleBumper25 = new CircleBumper(146, 294, 25, "CircleBumper25.png", this, pinball, scoreBoard, 25);
        circleBumper10 = new CircleBumper(270, 374, 25, "CircleBumper10.png", this, pinball, scoreBoard, 10);
        
        bars = new GImage("Bars.png", 0, 8);
        bars.setSize(getWidth(), getHeight());
        sideBars = new SideBars(55, 340, 11, 134, "SideBars.png", this);
        
        add(background);
        add(curvedWall);
        add(bars);
        add(lflip);
        add(rflip);
        add(sideWalls);
    	add(pinball);
        add(sprong);
        add(spring);
        add(hitOval);
        add(bar1);
        add(bar2);
        add(bar3);
        add(bar4);
        add(ltri);
        add(rtri);
        add(border);
        add(scoreBoard);
        add(lBar);
        add(rBar);
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
            circleBumper10.checkForHits();    
            circleBumper25.checkForHits();
            circleBumper50.checkForHits();
            ltri.checkForHits();
            rtri.checkForHits();
            rBar.checkForHits();
            lBar.checkForHits();
        }
    }
    
    public SideBars getSideBars()
    {
    	return sideBars;
    }
    
    public GOval getHitOval()
    {
        return hitOval;
    }

    public Score getMyScoreBoard()
    {
        return scoreBoard;
    }
    
    public Bar getBar1()
    {
    	return bar1;
    }
    
    public Bar getBar2()
    {
    	return bar2;
    }
    
    public Bar getBar3()
    {
    	return bar3;
    }
    
    public Bar getBar4()
    {
    	return bar4;
    }
    
}