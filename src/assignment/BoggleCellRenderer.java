package assignment;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.HashSet;

class BoggleCellRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;
    private boolean[][] pointsToHighlight;

    public BoggleCellRenderer(int width, int height) {
        pointsToHighlight = new boolean[width][height];
    }

    public boolean[][] getPointsToHighlight() {
        return pointsToHighlight;
    }

    public void setPointsToHighlight(boolean[][] pointsToHighlight) {
        this.pointsToHighlight = pointsToHighlight;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (pointsToHighlight[row][column]){
            System.out.println("yo" + row + " " +column);
            setBackground(Color.CYAN);
        }
        else{
            setBackground(Color.WHITE);
        }
        setText((Character) table.getValueAt(row,column) + "");
        setFont(new java.awt.Font("Impact", 0, 30));
        setHorizontalAlignment(JLabel.CENTER);
        setOpaque(true);
        return this;
    }
}