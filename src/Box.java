import acm.program.*;
import acm.graphics.*;
import java.awt.Color;  

public class Box extends GraphicsProgram
{
	private GImage background;

	
	public void init()
	{
		setSize(536, 800);
		background = new GImage("BoardTemplate.jpg", 0, 0);
		background.setSize(getWidth(), getHeight());
	}

	public void run() 
	{
		
		add(background);
		GPolygon poly = new GPolygon();
	      poly.setFilled(true);
	      poly.setColor(Color.RED);
	      
	      poly.addArc(200, 200, 3.14, 100);
	      poly.addEdge(100, 100);
	      
	      poly.setLocation(200, 200);
	      add(poly);
		
	}
	
	
	
}