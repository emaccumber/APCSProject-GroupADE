import java.awt.Color;
import acm.graphics.GPolygon;
public class FlipperLeft extends GPolygon{
	private double xpos;
	private double ypos;
	private Board board;
	private Ball pin;
	private double flip;
	private boolean up;
	private double totalvel;
	private double xvel;
	private double yvel;
	private double angle;
	private boolean debounce=false;
	private double xdist;
	private double ydown;
	public FlipperLeft(double x, double y, Color c, Board box, Ball ping){
		super(x, y);
		setColor(c);
        setFillColor(c);
        setFilled(true);
        board = box;
        pin=ping;
        addVertex(0, 0);
        addVertex(0, 10);
        addVertex(60, 10);
        addVertex(60, 0);
        flip=-30;
        rotate(-30);
	}
	public void checkForHits(){
		if(hitbox(pin.getX()+(pin.getWidth()/2), pin.getY()+pin.getHeight())
				&&!debounce
				&&pin.getYVel()>0){
			debounce=true;
			totalvel=Math.sqrt((pin.getXVel()*pin.getXVel())+(pin.getYVel()*pin.getYVel()));
			angle=Math.toRadians(flip+90);
			yvel=Math.sin(angle);
			yvel=yvel*totalvel;
			xvel=Math.cos(angle);
			xvel=xvel*totalvel;
			if(flip<=25&&up){				
				pin.changeVel(3*xvel, -3*yvel);
			}
			else{
				pin.changeVel(1.5*xvel, -1.5*yvel);
			}
		}
		else{
			debounce=false;
		}
	}
	public boolean hitbox(double x, double y){
		xdist=getX()-x;
		ydown=getY()+(flip*2/100)*xdist;
		if(ydown<0){
			ydown=ydown*-1;
		}
		if(x<=getX()+50
				&&x>=getX()
				&&y>=ydown
				&&y<=ydown+20){
			return true;
		}
		else{
			return false;
		}
	}
	public void goUp(){
		up=true;
	}
	public void goDown(){
		up=false;
	}
	public void flipup(){
		if(flip<=25&&up){
			rotate(5);
			flip=flip+5;
		}
	}
	public void release(){
		if(flip>=-30&&!up){
			rotate(-1);
			flip=flip-1;
		}
	}
	public void move(){
		flipup();
		release();
		checkForHits();
	}
}