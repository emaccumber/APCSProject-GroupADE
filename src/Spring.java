
import acm.graphics.GRect;
import java.awt.Color;
public class Spring extends GRect{
	double yset;
	double strength=0;
	int pulled=0;
	public Spring(double xs, double ys, Color c, Board board, double xp, double yp) {
		super(xp, yp, xs, ys);
		setFilled(true);
		setColor(c);
		yset=ys;
	}
	public void springdown(){
		pulled=1;
		setSize(getWidth(), getHeight()-2);
		if(getHeight()>0){
			if(strength==0){
				strength=.05;
			}
			strength=strength*1.25;
		}
		move(0, 2);
	}
	public void release(){
		pulled=0;
		double sizechange=yset-getHeight();
		while(getHeight()<yset){
			move(0, -2);
			setSize(getWidth(), getHeight()+2);
		}
		setSize(getWidth(), yset);
		strength=0;
	}
}