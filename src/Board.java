/**
 * Created by davidmaccumber on 8/1/16.
 */
import acm.graphics.GImage;
import acm.program.GraphicsProgram;
public class Board extends GraphicsProgram {

    private GImage background;
    private CurvedWall curvedWall;
    private CircleBumper circleBumper50;
    private CircleBumper circleBumper10;
    private CircleBumper circleBumper25;

    public static void main(String[] args)
    {
        new Board().start();
    }

    public void init()
    {
        setSize(536, 800);
        background = new GImage("Background.png");
        background.setSize(getWidth(), getHeight());

        curvedWall = new CurvedWall(43, 49, 452, 700);
        circleBumper50 = new CircleBumper(250, 400, 25, "CircleBumper50.png", this);
        circleBumper25 = new CircleBumper(400, 230, 25, "CircleBumper25.png", this);
        circleBumper10 = new CircleBumper(300, 300, 25, "CircleBumper10.png", this);
    }

    public void run()
    {
        add(background);
        add(curvedWall);

        circleBumper50.showBumper();
        circleBumper25.showBumper();
        circleBumper10.showBumper();
    }

}