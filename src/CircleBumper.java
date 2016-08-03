/**
 * Created by Abim, David and Ethan
 * AP Computer Science
 * August 2016
 */
import acm.graphics.GImage;
import acm.graphics.GOval;

public class CircleBumper extends GOval {

    private Board myBoard;
    private GImage bumperGImage;
    private Score scor;
    Ball ball;
	double xch;
	double ych;
	double xvel;
	double yvel;
	double tch;
	double angl;
	double totalvel;
	int adding;
	public boolean debounce=false;

    public CircleBumper(double x, double y, double r, String bumperImage, Board board, Ball target, Score scoreboard, int scoreadd)
    {
        super(x, y, 2*r, 2*r);
        myBoard = board;
        bumperGImage = new GImage(bumperImage, x, y);
        bumperGImage.setSize(2*r, 2*r);
        setVisible(false); 			// sets the GOval for each bumper as invisible
        ball = target;
        scor = scoreboard;
        adding = scoreadd;
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
}
