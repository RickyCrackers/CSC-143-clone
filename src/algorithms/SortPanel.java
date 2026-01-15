package algorithms;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.io.Serial;

class SortPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = 1L;

    private final int[] data;
    private int highlightBar1;
    private int highlightBar2;

    public SortPanel(int[] data) {
        this(data, -1, -1);
    }

    public SortPanel(int[] data, int highlightBar1, int highlightBar2) {
        this.data           = data;
        this.highlightBar1  = highlightBar1;
        this.highlightBar2  = highlightBar2;
    }

    public void draw(Graphics panelGraphics) {
        int width       = getWidth();
        int height      = getHeight();
        int barWidth    = (int) ((double) width / data.length * 0.8);
        int xOffset     = (int) ((double) width / data.length * 0.2);

        for (int k = 0; k < data.length; k++) {
            int barHeight = (int) ((double) data[k] / 510 * height); // Scale height
            int x = k * (barWidth + xOffset);
            int y = height - barHeight;

            // Set color for highlighting or default
            if (k == highlightBar1 || k == highlightBar2) {
                panelGraphics.setColor(Color.RED); // Highlighted bars are red
            } else {
                panelGraphics.setColor(Color.BLUE); // Default color is blue
            }

            // Draw the bar
            panelGraphics.fillRect(x, y, barWidth, barHeight);
            panelGraphics.setColor(Color.BLACK); // Outline
            panelGraphics.drawRect(x, y, barWidth, barHeight);
        }

    }

    // Method to set which bars are currently being compared/swapped
    public void setCurrentComparison(int index1, int index2) {
        this.highlightBar1 = index1;
        this.highlightBar2 = index2;
    }

    @Override
    protected void paintComponent(Graphics panelGraphics) {
        super.paintComponent(panelGraphics); // Always call super.paintComponent
        draw(panelGraphics);
    }
}