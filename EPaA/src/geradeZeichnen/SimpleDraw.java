package geradeZeichnen;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleDraw extends JPanel {

    private BufferedImage mCanvas;

    public SimpleDraw(int aWidth, int aHeight) {
        mCanvas = new BufferedImage(aWidth, aHeight, 
				   BufferedImage.TYPE_INT_ARGB);
    }

    public Dimension getPreferredSize() {
        return new Dimension(mCanvas.getWidth(), mCanvas.getHeight());
    }

    /* Do the redraw */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(mCanvas, null, null);
    }

    /* Fill the whole canvas with a color */
    public void fillCanvas(Color c) {
        int color = c.getRGB();
        for (int x = 0; x < mCanvas.getWidth(); x++) {
            for (int y = 0; y < mCanvas.getHeight(); y++) {
                mCanvas.setRGB(x, y, color);
            }
        }
        repaint();
    }


    public void drawLine(int x1, int y1, int x2, int y2, Color c) {
    	int dx = x2 - x1;
    	int dy = y2 - y1;
    	int dx2=2*dx;
    	int dy2=2*dy;
    	
    	int xi=x1;
    	int yi=y1;
    	
    	int erry =-dx;
    	int errx =-dy;
    	
    	while(xi<=x2) {
    		setPoint ( xi , yi, c );
    		erry += dy2;
    		errx += dx2;
        
    		if (erry>=0) {
    			yi++;
    			erry+=dx2;
    		}
    		
    		if(errx>=0){
        		xi++;
        		errx+=dy2;
    		}
    	}
        repaint();
    }

    public void drawRect(int x1, int y1, int aWidth, int aHeight, Color c) {
        int color = c.getRGB();
        // Do rectangle drawing
        for (int x = x1; x < x1 + aWidth; x++) {
            for (int y = y1; y < y1 + aHeight; y++) {
                setPoint(x, y, c);
            }
        }
        repaint();
    }

    public void setPoint(int x, int y, Color c)
    {
    	Dimension dim = getPreferredSize();
    	x += dim.getWidth()/2;
    	y = (int) (dim.getHeight()/2 - y);
        int color = c.getRGB();
        mCanvas.setRGB(x, y, color);
    }

    public static void main(String[] args) {
        int width = 512;
        int height = 256;
        JFrame frame = new JFrame("SimpleDraw");

        SimpleDraw panel = new SimpleDraw(width, height);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
        panel.fillCanvas(Color.WHITE);
        panel.setPoint(0, 0, Color.BLACK);
        
        for (int i = -30; i < 30; i++) {
			panel.setPoint(0, i, Color.green);
			panel.setPoint(i, 0, Color.green);
		}

        panel.drawLine(10, 10, 100, -80, Color.black);
        
        panel.repaint();
    }


}
