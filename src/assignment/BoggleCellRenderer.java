package assignment;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.HashSet;

class BoggleCellRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;
    private int[][] pointsToHighlight;

    public BoggleCellRenderer(int width, int height) {
        pointsToHighlight = new int[width][height];
    }

    public int[][] getPointsToHighlight() {
        return pointsToHighlight;
    }

    public void setPointsToHighlight(int[][] pointsToHighlight) {
        this.pointsToHighlight = pointsToHighlight;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //If the corresponding index of the table is true, then that cell will be highlighted cyan
        if (pointsToHighlight[row][column] != 0){
            setBackground(Color.CYAN);
        }
        else{
            setBackground(Color.WHITE);
        }
        //Adjusts font and alignment of the cell
        setText((Character) table.getValueAt(row,column) + "");
        //This is a font we find conveys the letters distinctly and maintains the "game"-y feeling of the board
        setFont(new java.awt.Font("Impact", 0, 30));
        //Centers text, since by default text is left aligned
        setHorizontalAlignment(JLabel.CENTER);
        setOpaque(true);
        return this;
    }
}