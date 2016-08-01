import acm.program.*;
import acm.graphics.*;
import java.awt.Color;  

public class Box extends GraphicsProgram
{
	
	
	public void init()
	{
		setSize(536, 800);
	}

	public void run() 
	
	{
		GPolygon poly = new GPolygon();
	      poly.setFilled(true);
	      poly.setColor(Color.RED);
	      
	      poly.addArc(100, 100, 100, 100);
	      poly.addEdge(100, 100);
	      
	      poly.setLocation(100, 100);
	      add(poly);
		
	}
	
	
	
}