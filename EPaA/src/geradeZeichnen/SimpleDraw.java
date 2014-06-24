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
        // Implement line drawing
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
	
	panel.fillCanvas(Color.RED);
	for (int i=0; i<123; ++i)
	    panel.setPoint(i,i, Color.BLUE);

	panel.repaint();
    }


}
