package background;
/**
 * Created by Abim, David and Ethan
 * AP Computer Science
 * August 2016
 */
import acm.graphics.GImage;
import acm.graphics.GOval;
import acm.graphics.GPolygon;
import game.Board;
public class CurvedWall extends GPolygon {

    private Board myBoard;
    private GImage wallGImage;

    public CurvedWall(double x, double y)
    {
        super(x, y);
    }    
}
