package objects;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import acm.graphics.GImage;
import acm.graphics.GOval;
import ball.Ball;
import game.Board;
import scoring.Score;

public class CircleBumper extends GOval implements MouseMotionListener {

    private Board myBoard;
    private GImage bumperGImage;
    private Score scor;
    private Ball ball;
	private double xch;
	private double ych;
	private double xvel;
	private double yvel;
	private double tch;
	private double angl;
	private double totalvel;
	private int adding;
	public boolean debounce = false;


    public CircleBumper(double x, double y, double r, String bumperImage, Board board, Ball target, Score scoreboard, int scoreadd)
    {
        super(x, y, 2*r, 2*r);
        myBoard = board;
        bumperGImage = new GImage(bumperImage, x, y);
        bumperGImage.setSize(2*r, 2*r);
        setVisible(false); 			
        ball = target;
        scor = scoreboard;
        adding = scoreadd;
    	addMouseMotionListener(this);
    }

    public void showBumper()
    {
        myBoard.add(this);
        myBoard.add(bumperGImage);
    }
    
    public boolean hitBox()
    {
		if (ball.getY() + (ball.getHeight() / 2) >= getY() - (ball.getHeight() / 2)
			&& ball.getY() + (ball.getHeight() / 2) <= getY() + getHeight()+(ball.getHeight() / 2)
			&& ball.getX() + (ball.getWidth() / 2) >= getX() - (ball.getWidth() / 2)
			&& ball.getX() + (ball.getWidth() / 2) <= getX() + getWidth() + (ball.getWidth() / 2))
			
			return true;
		
		else return false;			
	}

    public void checkForHits()
    {
		if (hitBox())
		{
			if (!debounce)
			{
				debounce = true;
				xch = (getX() + (getWidth() / 2)) - (ball.getX() + (ball.getWidth() / 2));
				ych = (getY() + (getHeight() / 2)) - (ball.getY() + (ball.getHeight() / 2));
				tch = Math.sqrt((xch * xch) + (ych * ych));
				xvel = ball.getXVel();
				yvel = ball.getYVel();
				totalvel = Math.sqrt((xvel * xvel) + (yvel * yvel));
				angl = Math.acos(xch / tch);
				yvel = Math.sin(angl);
				yvel = yvel * totalvel;
				xvel = Math.cos(angl);
				xvel = xvel * totalvel;
				
				if (ych > 0 && xch > 0)
				{
				yvel= yvel * -1;
				xvel = xvel * -1;
				}
				
				if (ych < 0 && xch > 0)
				{
					xvel = xvel * -1;
				}
				
				if (ych < 0 && xch < 0)
				{
					xvel = xvel * -1;
				}
				
				if (ych > 0 && xch < 0)
				{
					yvel = yvel * -1;
					xvel = xvel * -1;
				}
				ball.changeVel(1.8*xvel, 1.8*yvel);
				scor.add(adding);			
			}
		}
		
		else debounce = false;		
	}

	public void mouseDragged(MouseEvent e) 
	{	
		updatePosition(e);
		System.out.println("dragged");
	}

	public void mouseMoved(MouseEvent e) 
	{
		
		System.out.println("moved");
	}
	
	public void updatePosition(MouseEvent e)
	{
		setLocation(e.getX(), e.getY());
		bumperGImage.setLocation(e.getX(), e.getY());
	}
}
