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

    public CircleBumper(double x, double y, double r, String bumperImage, Board board, Ball ball)
    {
        super(x, y, 2*r, 2*r);
        myBoard = board;
        bumperGImage = new GImage(bumperImage, x, y);
        bumperGImage.setSize(2*r, 2*r);
        setVisible(false); 			// sets the GOval for each bumper as invisible
    }

    public void showBumper()
    {
        myBoard.add(this);
        myBoard.add(bumperGImage);
    }
}
