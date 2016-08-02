import acm.graphics.GImage;
import acm.graphics.GOval;

/**
 * Created by davidmaccumber on 8/1/16.
 */
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
