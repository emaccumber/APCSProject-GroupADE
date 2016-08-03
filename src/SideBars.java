/**
 * Created by Abim, David and Ethan
 * AP Computer Science
 * August 2016
 */
import acm.graphics.GImage;
import acm.graphics.GRect;

public class SideBars extends GRect {

    private Board myBoard;
    private GImage sideBarsGImage;

    public SideBars(double x, double y, double w, double h, String sideBarsImage, Board board)
    {
        super(x, y, w, h);
        myBoard = board;
        sideBarsGImage = new GImage(sideBarsImage, 0, 0);
        sideBarsGImage.setSize(myBoard.getWidth(), myBoard.getHeight());
        setVisible(false);			// sets the GRect for the side bar invisible 
    }

    public void showSideBars()
    {
        myBoard.add(this);
        myBoard.add(sideBarsGImage);
    }
}
