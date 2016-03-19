package training03;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

public class DrawTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				JFrame frame = new DrawFrame();
				frame.setTitle("DrawTest");
				frame.setSize(400, 400);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}

}
class DrawFrame extends JFrame{
	public DrawFrame(){
		add(new DrawComponent());
		pack();
	}
}

class DrawComponent extends JComponent{
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 400;
	
	public void paintComponent(Graphics g){
		/*
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		System.out.println(screenWidth+"x"+screenHeight);
		
		//setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		setSize(screenWidth/2,screenHeight/2);
		setLocationByPlatform(true);
		
		Image img = new ImageIcon("icon.gif").getImage();
		setIconImage(img);
		*/
		//g.drawString("HELLO,JAVA.", 75, 100);
		Graphics2D g2 = (Graphics2D) g;
		double leftX = 100;
		double topY = 100;
		double width = 200;
		double height = 150;
		Rectangle2D rect = new Rectangle2D.Double(leftX,topY,width,height);
		g2.draw(rect);
		
		//draw the enclosed ellipse
		Ellipse2D ellipse = new Ellipse2D.Double();
		ellipse.setFrame(rect);
		g2.draw(ellipse);
		
		//draw a diagonal line
		g2.draw(new Line2D.Double(leftX, topY, leftX+width,topY+height));
		
		//draw a circle with the same center
		double centerX = rect.getCenterX();
		double centerY = rect.getCenterY();
		double radius = 150;
		
		Ellipse2D circle = new Ellipse2D.Double();
		circle.setFrameFromCenter(centerX, centerY, centerX+radius, centerY+radius);
		g2.draw(circle);
		
	}
	public Dimension getPreferrenSize(){
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
}