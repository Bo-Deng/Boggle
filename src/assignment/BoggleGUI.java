package assignment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raymo
 */
public class BoggleGUI extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */

    private Game game;
    private String scoreBoardText = "Discovered Words";
    private int fontSize;


    public BoggleGUI() {
        game = new Game();
        initComponents();
        setButtonText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        fontSize = 28;
        EnterWord = new javax.swing.JTextField();
        EnterButton = new javax.swing.JButton();
        ScoreBoardScroll = new javax.swing.JScrollPane();
        ScoreBoard = new javax.swing.JLabel();
        EndTurn = new javax.swing.JButton();
        P1Score = new javax.swing.JLabel();
        CPUScore = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BoggleBoardTable = new javax.swing.JTable();
        //BoggleBoardTable.setEnabled(false);
        setRendering();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(520, 455));

        EnterWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EnterWordKeyPressed(evt);
            }
        });

        EnterButton.setText("Enter");
        EnterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterButtonActionPerformed(evt);
            }
        });

        ScoreBoard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreBoard.setText("Discovered Words");
        ScoreBoard.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        ScoreBoardScroll.setViewportView(ScoreBoard);


        EndTurn.setText("End Turn");
        EndTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EndTurnActionPerformed(evt);
            }
        });

        P1Score.setText("Player: ");

        CPUScore.setText("Comp:");
        BoggleBoardTable.setEnabled(false);
        BoggleBoardTable.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        BoggleBoardTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [game.getBoard().length][game.getBoard()[0].length],
                new String [game.getBoard().length]
        ));
        BoggleBoardTable.setGridColor(new java.awt.Color(0, 0, 0));
        BoggleBoardTable.setRowHeight(Math.max((int)(300 / game.getBoard().length),30));
        BoggleBoardTable.setColumnModel(getCorrectColumnLength(game.getBoard()[0].length));
        BoggleBoardTable.setShowGrid(true);
        jScrollPane1.setViewportView(BoggleBoardTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(EnterWord, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(EnterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(CPUScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(P1Score, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ScoreBoardScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(EndTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(ScoreBoardScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(28, 28, 28)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(EnterWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(EnterButton)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(P1Score, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(CPUScore))))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EndTurn, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private TableColumnModel getCorrectColumnLength(int length) {
        TableColumnModel columns = BoggleBoardTable.getColumnModel();
        int width = (Math.max(300 / length, 30));
        for (int i = 0; i < columns.getColumnCount(); i++){
            columns.getColumn(i).setWidth(width);
        }
        if (columns.getColumnCount() > 10){
            BoggleBoardTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        }
        return columns;
    }


    private void EnterButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int score = (game.addWord(EnterWord.getText(), 0));
        if (score != 0){
            boolean[][] tiles = game.getLastTilesSelected();
            highlightButtons(tiles);
            EnterWord.setText("");
            scoreBoardText += ("<br/>");
            if (game.getCurrentPlayer() == 0){
                scoreBoardText += "<font color='red'>" + game.getLastWord() + "</font>";
            }
            else if (game.getCurrentPlayer() == 1){
                scoreBoardText += "<font color='blue'>" + game.getLastWord() + "</font>";
            }
            ScoreBoard.setText("<html>" + scoreBoardText + "</html>");
            P1Score.setText("<html><font color='red'> Player Score: " + game.getPlayerScores()[0] + "</font></html>");
            CPUScore.setText("<html><font color='blue'>Comp Score: " + game.getPlayerScores()[1] + "</font></html>");
        }
    }

    private void EnterWordKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            int score = (game.addWord(EnterWord.getText(), 0));
            if (score != 0){
                boolean[][] tiles = game.getLastTilesSelected();
                highlightButtons(tiles);
                EnterWord.setText("");
                scoreBoardText += ("<br/>");
                if (game.getCurrentPlayer() == 0){
                    scoreBoardText += "<font color='red'>" + game.getLastWord() + "</font>";
                }
                else if (game.getCurrentPlayer() == 1){
                    scoreBoardText += "<font color='blue'>" + game.getLastWord() + "</font>";
                }
                ScoreBoard.setText("<html>" + scoreBoardText + "</html>");
                P1Score.setText("<html><font color='red'> Player Score: " + game.getPlayerScores()[0] + "</font></html>");
                CPUScore.setText("<html><font color='blue'>Comp Score: " + game.getPlayerScores()[1] + "</font></html>");
            }
        }
    }

    private void setRendering(){
        BoggleBoardTable.setCellSelectionEnabled(true);
        BoggleCellRenderer renderer = new BoggleCellRenderer(game.getBoard().length, game.getBoard()[0].length);
        BoggleBoardTable.setDefaultRenderer(Object.class, renderer);
    }

    private void EndTurnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        game.setCurrentPlayer(1);
        ArrayList<String> allWords = (ArrayList<String>) game.getAllWords();
        for (String w : allWords){
            scoreBoardText += ("<br/>");
            if (game.getCurrentPlayer() == 0){
                scoreBoardText += "<font color='red'>" + w + "</font>";
            }
            else if (game.getCurrentPlayer() == 1){
                scoreBoardText += "<font color='blue'>" + w + "</font>";
            }
        }
        ScoreBoard.setText("<html>" + scoreBoardText + "</html>");
        P1Score.setText("<html>Text color: <font color='red'> Player Score: " + game.getPlayerScores()[0] + "</font></html>");
        CPUScore.setText("<html>Text color: <font color='blue'>Comp Score: " + game.getPlayerScores()[1] + "</font></html>");
    }


    /**


     /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BoggleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BoggleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BoggleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoggleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BoggleGUI().setVisible(true);
            }
        });
    }


    private void setButtonText() {
        DefaultTableModel boardModel = (DefaultTableModel) BoggleBoardTable.getModel();
        char[][] gameBoard = game.getBoard();
        for (int r = 0; r < gameBoard.length; r++) {
            for (int c = 0; c < gameBoard[r].length; c++) {
                boardModel.setValueAt(gameBoard[r][c],r,c);
            }
        }
        P1Score.setText("<html><font color='red'> Player Score: " + game.getPlayerScores()[0] + "</font></html>");
        CPUScore.setText("<html><font color='blue'>Comp Score: " + game.getPlayerScores()[1] + "</font></html>");
    }

    private void highlightButtons(boolean[][] buttonsToHighlight){
        char[][] gameBoard = game.getBoard();
        BoggleCellRenderer renderer = new BoggleCellRenderer(gameBoard.length, gameBoard[0].length);
        renderer.setPointsToHighlight(buttonsToHighlight);
        System.out.println(gameBoard.length + " up " + gameBoard[0].length);
        BoggleBoardTable.setDefaultRenderer(Object.class, renderer);
        BoggleBoardTable.repaint();
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel CPUScore;
    private javax.swing.JButton EndTurn;
    private javax.swing.JTable BoggleBoardTable;
    private javax.swing.JButton EnterButton;
    private javax.swing.JTextField EnterWord;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel P1Score;
    private javax.swing.JLabel ScoreBoard;
    private javax.swing.JScrollPane ScoreBoardScroll;
    // End of variables declaration
    // End of variables declaration
}