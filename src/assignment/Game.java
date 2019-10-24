package assignment;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Game implements BoggleGame {
    private BoggleDictionary wordDictionary;
    private ArrayList<String> cubes;
    private char[][] gameBoard;
    private long lastTilesSelected = 0;
    private HashSet<String> foundWords;
    private String lastWord;
    private int[] playerScores;
    private int currentPlayer;

    public Game() {
        wordDictionary = new Dictionary();
        cubes = new ArrayList<>();
        foundWords = new HashSet<>();
        try {
            newGame(4, 2, "cubes.txt", wordDictionary);
        } catch (IOException ex) {
            System.err.println("The specified dictionary file cannot be accessed.");
            System.exit(1);
        }
    }

    @Override
    public void newGame(int size, int numPlayers, String cubeFile, BoggleDictionary dict) throws IOException {
        lastWord = "";
        wordDictionary = new Dictionary();
        cubes = new ArrayList<>();
        foundWords = new HashSet<>();
        playerScores = new int[numPlayers];
        currentPlayer = 0;
        loadCube(cubeFile);
        wordDictionary.loadDictionary("words.txt");
        gameBoard = new char[size][size];
        generateDiceStates();
    }

    @Override
    public char[][] getBoard() {
        return gameBoard;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public int addWord(String word, int player) {
        word = word.toUpperCase();
        if (word.length() < 4 || word.length() > 16 || !word.matches("[A-Z]+") || !wordDictionary.contains(word) || foundWords.contains(word)) {
            System.out.println("boom");
            return 0;
        }

        for (int r = 0; r < gameBoard.length; r++) {
            boolean isValid = false;
            for (int c = 0; c < gameBoard[r].length; c++) {
                if (gameBoard[r][c] == word.charAt(0)) {
                    System.out.println(r + " " + c);
                    isValid = recursePossibilities(word, r, c);
                }
            }
            if (isValid == true){
                lastWord = word;
                foundWords.add(lastWord);

                int wordScore = word.length() - 3;
                playerScores[currentPlayer] += wordScore;
                return wordScore;
            }
        }
        return 0;
    }

    @Override
    public List<Point> getLastAddedWord() {
        return null;
    }

    @Override
    public void setGame(char[][] board) {
        gameBoard = board;
    }

    @Override
    public Collection<String> getAllWords() {
        return null;
    }

    @Override
    public void setSearchTactic(SearchTactic tactic) {

    }

    @Override
    public int[] getScores() {
        return new int[0];
    }

    private void loadCube(String cubesFile){
        try {
            Scanner cubeReader = new Scanner(new File(cubesFile));
            while (cubeReader.hasNextLine()){
                cubes.add(cubeReader.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Cubes File not Found");
            System.exit(0);
        }

    }

    private void generateDiceStates(){
        Collections.shuffle(cubes);
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                int diceFace = (int) (Math.random() * 6);
                gameBoard[i][j] = cubes.get(4 * i + j).charAt(diceFace);
            }
        }
    }

    private boolean recursePossibilities(String word, int r, int c) {
        return recursePossibilities(word, r, c, 0);
    }

    private boolean recursePossibilities(String word, int r, int c, long visited) {
        word = word.substring(1);

        if (word.length() <= 0){
            visited += (long) Math.pow(2, r * gameBoard.length + c);
            lastTilesSelected = visited;
            return true;
        }
        visited += (long) Math.pow(2, r * gameBoard.length + c);
        for (int i = Math.max(0, r - 1); i <= Math.min(gameBoard.length - 1, r + 1); i++) {
            for (int j = Math.max(0, c - 1); j <= Math.min(gameBoard[r].length - 1, c + 1); j++) {
                if (gameBoard[i][j] == word.charAt(0) && (visited & ((long) Math.pow(2, i * gameBoard.length + j))) == 0) {
                    System.out.println(i + " " + j);
                    if (recursePossibilities(word, i, j, visited)) {
                        System.out.println("last" + lastTilesSelected);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String getLastWord() {
        return lastWord;
    }

    public long getLastTilesSelected() {
        return lastTilesSelected;
    }

    public BoggleDictionary getWordDictionary() {
        return wordDictionary;
    }

    public int getCurrentPlayer() { return currentPlayer; }

    public int[] getPlayerScores() { return playerScores; }
}
