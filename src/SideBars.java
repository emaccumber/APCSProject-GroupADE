import acm.graphics.GImage;
import acm.graphics.GRect;

/**
 * Created by davidmaccumber on 8/1/16.
 */
public class SideBars extends GRect {

    private Board myBoard;
    private GImage sideBarsGImage;

    public SideBars(double x, double y, double w, double h, String sideBarsImage, Board board)
    {
        super(x, y, w, h);
        myBoard = board;
        sideBarsGImage = new GImage(sideBarsImage, 0, 0);
        sideBarsGImage.setSize(myBoard.getWidth(), myBoard.getHeight());
    }

    public void showSideBars()
    {
        myBoard.add(this);
        myBoard.add(sideBarsGImage);
    }
}
