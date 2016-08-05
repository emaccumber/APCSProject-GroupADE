/**
 * Created by Abim, David and Ethan
 * AP Computer Science
 * August 2016
 */
import java.awt.Color;

public class BallsRemaining extends Boards {
	
	private int remaining;
	
	public BallsRemaining (String str, int x, int y, int numOfBalls)
    {
        super(str, x, y);
        setColor(Color.gray);
        remaining = numOfBalls - 1;
        setFont("Frozen Crystal Bold-Bold-22");
        setLabel("Balls Remaining: " + (numOfBalls - 1));
    }
	
	public void decrement()
	{
		remaining--;
		if (remaining <= 0) 
		setLabel("Balls Remaining: 0");
		
		else
		setLabel("Balls Remaining: " + remaining);
	}
	
	public int getRemain()
	{
		return remaining;
	}

}
