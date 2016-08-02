/**
 * Created by davidmaccumber on 8/1/16.
 */
import acm.graphics.GImage;
import java.awt.event.*;
import java.awt.*;


import acm.program.GraphicsProgram;
public class Board extends GraphicsProgram {

    private GImage background;
    private GImage curvedWall;
    private GImage bars;
    private SideBars sideBars;
    private CircleBumper circleBumper50;
    private CircleBumper circleBumper10;
    private CircleBumper circleBumper25;

    public static void main(String[] args)
    {
        new Board().start();
    }
    
    Color pb = new Color(0, 0, 255);
	Color sp = new Color(125, 125, 125);
	double tick = .001;
	double gravconstant = 3;
	private Spring sprong = new Spring(6, 40, sp, this, 400, 600);
	private Ball pinball = new Ball(100, 100, pb ,  6, 1, -1, this, sprong);
	
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
        
        curvedWall = new GImage("CurvedWall.png", 0, 0);

        circleBumper50 = new CircleBumper(250, 400, 25, "CircleBumper50.png", this);
        circleBumper25 = new CircleBumper(400, 230, 25, "CircleBumper25.png", this);
        circleBumper10 = new CircleBumper(300, 300, 25, "CircleBumper10.png", this);
        
        bars = new GImage("Bars.png", 0, 0);
        bars.setSize(getWidth(), getHeight());
        sideBars = new SideBars(55, 340, 11, 134, "SideBars.png", this);
        
        add(background);
        add(curvedWall);
        add(bars);
    	add(pinball);
        add(sprong);
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

}