package assignment;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

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
    private JButton[][] gameBoard;
    private String scoreBoardText = "Discovered Words";


    public BoggleGUI() {
        game = new Game();
        gameBoard = new JButton[game.getBoard().length][game.getBoard().length];
        initComponents();
        populateDiceArray();
        setButtonText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        R1C4 = new javax.swing.JButton();
        R1C2 = new javax.swing.JButton();
        R1C3 = new javax.swing.JButton();
        R2C1 = new javax.swing.JButton();
        R2C2 = new javax.swing.JButton();
        R2C3 = new javax.swing.JButton();
        R2C4 = new javax.swing.JButton();
        R3C1 = new javax.swing.JButton();
        R3C2 = new javax.swing.JButton();
        R3C3 = new javax.swing.JButton();
        R3C4 = new javax.swing.JButton();
        R4C1 = new javax.swing.JButton();
        R4C2 = new javax.swing.JButton();
        R4C3 = new javax.swing.JButton();
        R4C4 = new javax.swing.JButton();
        R1C1 = new javax.swing.JButton();
        EnterWord = new javax.swing.JTextField();
        EnterButton = new javax.swing.JButton();
        ScoreBoardScroll = new javax.swing.JScrollPane();
        ScoreBoard = new javax.swing.JLabel();
        EndTurn = new javax.swing.JButton();
        P1Score = new javax.swing.JLabel();
        CPUScore = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(520, 455));

        R1C4.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        R1C4.setMaximumSize(new java.awt.Dimension(80, 80));
        R1C4.setMinimumSize(new java.awt.Dimension(80, 80));
        R1C4.setName(""); // NOI18N
        R1C4.setPreferredSize(new java.awt.Dimension(80, 80));

        R1C2.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        R1C2.setMaximumSize(new java.awt.Dimension(80, 80));
        R1C2.setMinimumSize(new java.awt.Dimension(80, 80));
        R1C2.setName(""); // NOI18N
        R1C2.setPreferredSize(new java.awt.Dimension(80, 80));

        R1C3.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        R1C3.setMaximumSize(new java.awt.Dimension(80, 80));
        R1C3.setMinimumSize(new java.awt.Dimension(80, 80));
        R1C3.setName(""); // NOI18N
        R1C3.setPreferredSize(new java.awt.Dimension(80, 80));

        R2C1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        R2C1.setMaximumSize(new java.awt.Dimension(80, 80));
        R2C1.setMinimumSize(new java.awt.Dimension(80, 80));
        R2C1.setName(""); // NOI18N
        R2C1.setPreferredSize(new java.awt.Dimension(80, 80));

        R2C2.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        R2C2.setMaximumSize(new java.awt.Dimension(80, 80));
        R2C2.setMinimumSize(new java.awt.Dimension(80, 80));
        R2C2.setName(""); // NOI18N
        R2C2.setPreferredSize(new java.awt.Dimension(80, 80));

        R2C3.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        R2C3.setMaximumSize(new java.awt.Dimension(80, 80));
        R2C3.setMinimumSize(new java.awt.Dimension(80, 80));
        R2C3.setName(""); // NOI18N
        R2C3.setPreferredSize(new java.awt.Dimension(80, 80));

        R2C4.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        R2C4.setMaximumSize(new java.awt.Dimension(80, 80));
        R2C4.setMinimumSize(new java.awt.Dimension(80, 80));
        R2C4.setName(""); // NOI18N
        R2C4.setPreferredSize(new java.awt.Dimension(80, 80));

        R3C1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        R3C1.setMaximumSize(new java.awt.Dimension(80, 80));
        R3C1.setMinimumSize(new java.awt.Dimension(80, 80));
        R3C1.setName(""); // NOI18N
        R3C1.setPreferredSize(new java.awt.Dimension(80, 80));

        R3C2.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        R3C2.setMaximumSize(new java.awt.Dimension(80, 80));
        R3C2.setMinimumSize(new java.awt.Dimension(80, 80));
        R3C2.setName(""); // NOI18N
        R3C2.setPreferredSize(new java.awt.Dimension(80, 80));

        R3C3.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        R3C3.setMaximumSize(new java.awt.Dimension(80, 80));
        R3C3.setMinimumSize(new java.awt.Dimension(80, 80));
        R3C3.setName(""); // NOI18N
        R3C3.setPreferredSize(new java.awt.Dimension(80, 80));

        R3C4.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        R3C4.setMaximumSize(new java.awt.Dimension(80, 80));
        R3C4.setMinimumSize(new java.awt.Dimension(80, 80));
        R3C4.setName(""); // NOI18N
        R3C4.setPreferredSize(new java.awt.Dimension(80, 80));

        R4C1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        R4C1.setMaximumSize(new java.awt.Dimension(80, 80));
        R4C1.setMinimumSize(new java.awt.Dimension(80, 80));
        R4C1.setName(""); // NOI18N
        R4C1.setPreferredSize(new java.awt.Dimension(80, 80));

        R4C2.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        R4C2.setMaximumSize(new java.awt.Dimension(80, 80));
        R4C2.setMinimumSize(new java.awt.Dimension(80, 80));
        R4C2.setName(""); // NOI18N
        R4C2.setPreferredSize(new java.awt.Dimension(80, 80));

        R4C3.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        R4C3.setMaximumSize(new java.awt.Dimension(80, 80));
        R4C3.setMinimumSize(new java.awt.Dimension(80, 80));
        R4C3.setName(""); // NOI18N
        R4C3.setPreferredSize(new java.awt.Dimension(80, 80));

        R4C4.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        R4C4.setMaximumSize(new java.awt.Dimension(80, 80));
        R4C4.setMinimumSize(new java.awt.Dimension(80, 80));
        R4C4.setName(""); // NOI18N
        R4C4.setPreferredSize(new java.awt.Dimension(80, 80));

        R1C1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        R1C1.setMaximumSize(new java.awt.Dimension(80, 80));
        R1C1.setMinimumSize(new java.awt.Dimension(80, 80));
        R1C1.setName(""); // NOI18N
        R1C1.setPreferredSize(new java.awt.Dimension(80, 80));

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

        P1Score.setText("Player: 0");

        CPUScore.setText("Comp: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(R3C1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(R3C2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(R3C3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(R3C4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(R4C1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(R4C2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(R4C3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(R4C4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(R1C1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(R1C2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(R1C3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(R1C4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(R2C1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(R2C2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(R2C3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(R2C4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(EnterWord, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(EnterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(EndTurn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ScoreBoardScroll)
                                        .addComponent(P1Score, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(CPUScore)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(R1C3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(R1C4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(R1C2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(R1C1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(R2C3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(R2C4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(R2C2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(R2C1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(R3C3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(R3C4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(R3C2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(R3C1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(R4C3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(R4C4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(R4C2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(R4C1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(EnterWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(EnterButton)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(ScoreBoardScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(P1Score)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CPUScore)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EndTurn, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>




    private void EnterButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int score = (game.addWord(EnterWord.getText(), 0));
        if (score != 0){
            long tiles = game.getLastTilesSelected();
            highlightButtons(findTilesToHighlight(tiles));
            EnterWord.setText("");
            System.out.println(game.getLastWord());
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
                long tiles = game.getLastTilesSelected();
                highlightButtons(findTilesToHighlight(tiles));
                EnterWord.setText("");
                System.out.println(game.getLastWord());
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

    private void EndTurnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        game.setCurrentPlayer(1);
        Iterator it = game.getWordDictionary().iterator();
        while (it.hasNext()){
            int score = (game.addWord((String) it.next(), 0));
            if (score != 0){
                long tiles = game.getLastTilesSelected();
                highlightButtons(findTilesToHighlight(tiles));
                EnterWord.setText("");
                System.out.println(game.getLastWord());
                scoreBoardText += ("<br/>");
                if (game.getCurrentPlayer() == 0){
                    scoreBoardText += "<font color='red'>" + game.getLastWord() + "</font>";
                }
                else if (game.getCurrentPlayer() == 1){
                    scoreBoardText += "<font color='blue'>" + game.getLastWord() + "</font>";
                }
                ScoreBoard.setText("<html>" + scoreBoardText + "</html>");
            }
        }
        P1Score.setText("<html>Text color: <font color='red'> Player Score: " + game.getPlayerScores()[0] + "</font></html>");
        CPUScore.setText("<html>Text color: <font color='blue'>Comp Score: " + game.getPlayerScores()[1] + "</font></html>");
    }

    private ArrayList<JButton> findTilesToHighlight(long tiles){
        ArrayList<JButton> toHighlight = new ArrayList<>();
        for (int i = 0; i < 16; i++){
            if ((tiles & (long)(Math.pow(2,i))) == (long)(Math.pow(2,i))){
                toHighlight.add(gameBoard[i / gameBoard.length][i % gameBoard.length]);
            }
        }
        System.out.println("len" + toHighlight.size());
        return toHighlight;
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

    private void populateDiceArray(){
        gameBoard[0][0] = R1C1;
        gameBoard[0][1] = R1C2;
        gameBoard[0][2] = R1C3;
        gameBoard[0][3] = R1C4;
        gameBoard[1][0] = R2C1;
        gameBoard[1][3] = R2C4;
        gameBoard[1][2] = R2C3;
        gameBoard[1][1] = R2C2;
        gameBoard[2][0] = R3C1;
        gameBoard[2][1] = R3C2;
        gameBoard[2][2] = R3C3;
        gameBoard[2][3] = R3C4;
        gameBoard[3][0] = R4C1;
        gameBoard[3][1] = R4C2;
        gameBoard[3][2] = R4C3;
        gameBoard[3][3] = R4C4;
    }

    private void setButtonText() {
        for (int r = 0; r < gameBoard.length; r++) {
            for (int c = 0; c < gameBoard[r].length; c++) {
                gameBoard[r][c].setText(game.getBoard()[r][c] + "");
            }
        }
        P1Score.setText("<html><font color='red'> Player Score: " + game.getPlayerScores()[0] + "</font></html>");
        CPUScore.setText("<html><font color='blue'>Comp Score: " + game.getPlayerScores()[1] + "</font></html>");
    }

    private void highlightButtons(ArrayList<JButton> buttonsToHighlight){
        for (int i = 0; i < gameBoard.length; i++){
            for (int j = 0; j < gameBoard[0].length; j++){
                gameBoard[i][j].setBackground(new java.awt.Color(240,240,240));
            }
        }
        for (int i = 0; i < buttonsToHighlight.size(); i++){
            buttonsToHighlight.get(i).setBackground(new java.awt.Color(0, 255, 204));
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel CPUScore;
    private javax.swing.JButton EndTurn;
    private javax.swing.JButton EnterButton;
    private javax.swing.JTextField EnterWord;
    private javax.swing.JLabel P1Score;
    private javax.swing.JButton R1C1;
    private javax.swing.JButton R1C2;
    private javax.swing.JButton R1C3;
    private javax.swing.JButton R1C4;
    private javax.swing.JButton R2C1;
    private javax.swing.JButton R2C2;
    private javax.swing.JButton R2C3;
    private javax.swing.JButton R2C4;
    private javax.swing.JButton R3C1;
    private javax.swing.JButton R3C2;
    private javax.swing.JButton R3C3;
    private javax.swing.JButton R3C4;
    private javax.swing.JButton R4C1;
    private javax.swing.JButton R4C2;
    private javax.swing.JButton R4C3;
    private javax.swing.JButton R4C4;
    private javax.swing.JLabel ScoreBoard;
    private javax.swing.JScrollPane ScoreBoardScroll;
    // End of variables declaration
    // End of variables declaration
}