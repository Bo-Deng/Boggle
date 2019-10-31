package assignment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//This class is the GUI for the boggle board and uses the GameManager structure to control the game. Essentially
//this class takes care of the visuals, whereas the GameManager takes care of the rules of Boggle
public class Boggle extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */

    private GameManager game;
    private String scoreBoardText = "Discovered Words";
    private int fontSize;


    public Boggle() {
        game = new GameManager();
        GameDictionary load = new GameDictionary();
        try {
            load.loadDictionary("words.txt");
            game.newGame(4,2,"cubes.txt",load);
        } catch (IOException e) {
            System.err.println("Invalid file");
            System.exit(0);
        }
        initComponents();
        setButtonText();
    }

    //Most of this code in initComponents was generated using the NetBeans GUI maker
    private void initComponents() {
        //Uses Java swing for components on the board
        EnterWord = new javax.swing.JTextField();
        EnterButton = new javax.swing.JButton();
        ScoreBoardScroll = new javax.swing.JScrollPane();
        ScoreBoard = new javax.swing.JLabel();
        EndTurn = new javax.swing.JButton();
        P1Score = new javax.swing.JLabel();
        CPUScore = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BoggleBoardTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2.setSelected(false);
        //Uses a custom Cell Renderer so that individual words on the board can be highlighted
        setRendering();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //size of board
        setMinimumSize(new java.awt.Dimension(520, 455));
        //Makes window a fixed size
        this.setResizable(false);
        //Makes it so pressing enter tries the word in the text field
        EnterWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EnterWordKeyPressed(evt);
            }
        });
        //Makes it so clicking the button tries the word in the text field
        EnterButton.setText("Enter");
        EnterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterButtonActionPerformed(evt);
            }
        });
        //Aligns text that stores current score of board
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

        jMenu2.setText("Search");
        ButtonGroup group = new ButtonGroup();
        jRadioButtonMenuItem1.setText("Board-based Searcb");
        jRadioButtonMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jRadioButtonMenuItem1);
        jRadioButtonMenuItem2.setText("Dictionary-based Search");
        jRadioButtonMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jRadioButtonMenuItem2);

        jMenuBar1.add(jMenu2);
        group.add(jRadioButtonMenuItem1);
        group.add(jRadioButtonMenuItem2);
        setJMenuBar(jMenuBar1);
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
    }

    //Resizes the column width based on how many columns there are
    private TableColumnModel getCorrectColumnLength(int length) {
        TableColumnModel columns = BoggleBoardTable.getColumnModel();
        //Smallest columns can be is 30 units wide
        int width = (Math.max(300 / length, 30));
        for (int i = 0; i < columns.getColumnCount(); i++){
            columns.getColumn(i).setWidth(width);
        }
        //If theres more than 10 columns needed, this essentally adds horizontal scorlling
        if (columns.getColumnCount() > 10){
            BoggleBoardTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        }
        return columns;
    }


    //If JButton w/ enter on it is pressed, the board tries to see if the word in the text field can score
    private void EnterButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int score = (game.addWord(EnterWord.getText(), 0));
        //If score > 0, this means that the word is on the board and more than 3 letters
        if (score != 0){
            int[][] tiles = game.getLastTilesSelected();
            //Highlights the tiles that make up the word
            highlightButtons(tiles);
            EnterWord.setText("");
            scoreBoardText += ("<br/>");
            //Displays word on the right side, which shows the list of already chosen words.
            //Red signifies player 0 got that word
            if (game.getCurrentPlayer() == 0){
                scoreBoardText += "<font color='red'>" + game.getLastWord() + "</font>";
            }
            //Blue signifies player 1 go that word
            else if (game.getCurrentPlayer() == 1){
                scoreBoardText += "<font color='blue'>" + game.getLastWord() + "</font>";
            }
            //Updates scores based on the previous word
            ScoreBoard.setText("<html>" + scoreBoardText + "</html>");
            P1Score.setText("<html><font color='red'> Player Score: " + game.getPlayerScores()[0] + "</font></html>");
            CPUScore.setText("<html><font color='blue'>Comp Score: " + game.getPlayerScores()[1] + "</font></html>");
        }
    }

    //Action listener so that when the user presses enter it will attempt to score the word in the text field
    private void EnterWordKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            int score = (game.addWord(EnterWord.getText(), 0));
            //If score > 0, this means that the word is on the board and more than 3 letters
            if (score != 0){
                int[][] tiles = game.getLastTilesSelected();
                //Highlights the tiles that make up the word
                highlightButtons(tiles);
                EnterWord.setText("");
                scoreBoardText += ("<br/>");
                //Displays word on the right side, which shows the list of already chosen words.
                //Red signifies player 0 got that word
                if (game.getCurrentPlayer() == 0){
                    scoreBoardText += "<font color='red'>" + game.getLastWord() + "</font>";
                }
                //Blue signifies player 1 go that word
                else if (game.getCurrentPlayer() == 1){
                    scoreBoardText += "<font color='blue'>" + game.getLastWord() + "</font>";
                }
                //Updates scores based on the previous word
                ScoreBoard.setText("<html>" + scoreBoardText + "</html>");
                P1Score.setText("<html><font color='red'> Player Score: " + game.getPlayerScores()[0] + "</font></html>");
                CPUScore.setText("<html><font color='blue'>Comp Score: " + game.getPlayerScores()[1] + "</font></html>");
            }
        }
    }

    //Sets the correct cell renderers which affect how the content inside the cell is displayed on the screen
    private void setRendering(){
        BoggleBoardTable.setCellSelectionEnabled(true);
        BoggleCellRenderer renderer = new BoggleCellRenderer(game.getBoard().length, game.getBoard()[0].length);
        BoggleBoardTable.setDefaultRenderer(Object.class, renderer);
    }

    //WHen player 0 ends their turn,, player 1 plays
    private void EndTurnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        game.setCurrentPlayer(1);
        //Since player 1 is the computer, it will exhaustively find all remaining words on the board
        ArrayList<String> allWords = (ArrayList<String>) game.getAllWords();
        for (String w : allWords){
            scoreBoardText += ("<br/>");
            //Adds scored words to correct player (always shoulld be player 1 here)
            if (game.getCurrentPlayer() == 0){
                scoreBoardText += "<font color='red'>" + w + "</font>";
            }
            else if (game.getCurrentPlayer() == 1){
                scoreBoardText += "<font color='blue'>" + w + "</font>";
            }
        }
        //Adjusts scoreboard for new scores
        ScoreBoard.setText("<html>" + scoreBoardText + "</html>");
        P1Score.setText("<html>Text color: <font color='red'> Player Score: " + game.getPlayerScores()[0] + "</font></html>");
        CPUScore.setText("<html>Text color: <font color='blue'>Comp Score: " + game.getPlayerScores()[1] + "</font></html>");
    }


    /**


     /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Boggle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Boggle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Boggle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Boggle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Boggle().setVisible(true);
            }
        });
    }


    //Sets correct value for board and score board at beginning of game
    private void setButtonText() {
        DefaultTableModel boardModel = (DefaultTableModel) BoggleBoardTable.getModel();
        char[][] gameBoard = game.getBoard();
        //Sets jtable values to the corresponding chars
        for (int r = 0; r < gameBoard.length; r++) {
            for (int c = 0; c < gameBoard[r].length; c++) {
                boardModel.setValueAt(gameBoard[r][c],r,c);
            }
        }
        //Sets scoreboard start state
        P1Score.setText("<html><font color='red'> Player Score: " + game.getPlayerScores()[0] + "</font></html>");
        CPUScore.setText("<html><font color='blue'>Comp Score: " + game.getPlayerScores()[1] + "</font></html>");
    }

    //Highlights scored letters of the last scored word
    private void highlightButtons(int[][] buttonsToHighlight){
        char[][] gameBoard = game.getBoard();
        //Renderer highlights cells that are in the buttonsToHighlight array
        BoggleCellRenderer renderer = new BoggleCellRenderer(gameBoard.length, gameBoard[0].length);
        renderer.setPointsToHighlight(buttonsToHighlight);
        BoggleBoardTable.setDefaultRenderer(Object.class, renderer);
        BoggleBoardTable.repaint();
    }

    private void jRadioButtonMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        game.setSearchTactic(BoggleGame.SearchTactic.SEARCH_BOARD);
    }

    private void jRadioButtonMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        game.setSearchTactic(BoggleGame.SearchTactic.SEARCH_DICT);
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
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    // End of variables declaration
    // End of variables declaration
}