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
    private boolean[][] lastTilesSelected;
    public HashSet<String> foundWords;
    private String lastWord;
    private int[] playerScores;
    private int currentPlayer;
    private SearchTactic searchTactic;

    //Default Constructor always loads from words.txt and cubes.txt and a 4 x 4 board. (This basically is the default
    //version of Boggle with no frills added.
    public Game() {
        cubes = new ArrayList<>();
        foundWords = new HashSet<>();
        try {
            Dictionary load = new Dictionary();
            load.loadDictionary("words.txt");
            newGame(4, 2, "cubes.txt", load);
        } catch (IOException ex) {
            System.err.println("The specified dictionary file cannot be accessed.");
            System.exit(1);
        }
    }

    //Allows different files to be loaded, such as different board sizes and different dictionary/dice files
    public Game(int size, String cubeFile, String dictionaryFile) {
        cubes = new ArrayList<>();
        foundWords = new HashSet<>();
        try {
            Dictionary load = new Dictionary();
            load.loadDictionary(dictionaryFile);
            newGame(size, 2, cubeFile, load);
        } catch (IOException ex) {
            System.err.println("The specified dictionary file cannot be accessed.");
            System.exit(1);
        }
    }

    @Override
    public void newGame(int size, int numPlayers, String cubeFile, BoggleDictionary dict) throws IOException {
        if (size == 0){
            System.err.println("Cannot have size 0 board");
            System.exit(0);
        }
        lastWord = "";
        wordDictionary = dict;
        cubes = new ArrayList<>();
        foundWords = new HashSet<>();
        playerScores = new int[numPlayers];
        currentPlayer = 0;
        searchTactic = SearchTactic.SEARCH_BOARD;
        loadCube(cubeFile);
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
                    if (isValid == true){
                        lastWord = word;
                        foundWords.add(lastWord);
                        int wordScore = word.length() - 3;
                        playerScores[currentPlayer] += wordScore;
                        return wordScore;
                    }
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
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < lastTilesSelected.length; i++){
            for (int j = 0; j < lastTilesSelected[i].length; j++){
                if (lastTilesSelected[i][j]){
                    points.add(new Point(i, j));
                }
            }
        }
        return points;
    }

    @Override
    public void setGame(char[][] board) {
        gameBoard = board;
        foundWords = new HashSet<>();
        playerScores = new int[playerScores.length];
        currentPlayer = 0;
    }

    @Override
    public Collection<String> getAllWords() {
        if (searchTactic == SearchTactic.SEARCH_DICT) {
            return dictionarySearch();
        }
        return boardSearch();
    }

    private Collection<String> dictionarySearch() {
        ArrayList<String> allWords = new ArrayList<>();
        Iterator it = wordDictionary.iterator();
        while (it.hasNext()) {
            String next = (String) it.next();
            int score = addWord(next, currentPlayer);
            if (score != 0) {
                allWords.add(next);
            }
        }
        return allWords;
    }

    private Collection<String> boardSearch() {
        ArrayList<String> allWords = new ArrayList<>();
        for (int r = 0; r < gameBoard.length; r++){
            for (int c = 0; c < gameBoard[r].length; c++){
                recursiveBoardSearch(r,c,new boolean[gameBoard.length][gameBoard[0].length],"",allWords);
            }
        }
        return allWords;
    }

    private void recursiveBoardSearch(int r, int c, boolean[][] visited, String currentWord, ArrayList<String> allWords){
        currentWord += gameBoard[r][c];
        visited[r][c] = true;
        if (!wordDictionary.isPrefix(currentWord)){
            return;
        }
        if (wordDictionary.contains(currentWord) && !foundWords.contains(currentWord) && currentWord.length() > 3){
            foundWords.add(currentWord);
            allWords.add(currentWord);
            playerScores[currentPlayer] += (currentWord.length() - 3);
        }
        for (int i = Math.max(0, r - 1); i <= Math.min(gameBoard.length - 1, r + 1); i++) {
            for (int j = Math.max(0, c - 1); j <= Math.min(gameBoard[r].length - 1, c + 1); j++) {
                if (!visited[i][j]) {
                    recursiveBoardSearch(i,j,deepCopyVisitedArray(visited),currentWord,allWords);
                }
            }
        }

    }

    @Override
    public void setSearchTactic(SearchTactic tactic) {
        searchTactic = tactic;
    }

    @Override
    public int[] getScores() {
        return playerScores;
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
        if (cubes.size() == 0){
            System.err.println("No dice in cubes file");
            System.exit(0);
        }

    }

    private void generateDiceStates(){
        Collections.shuffle(cubes);
        for (int i = 0; i < gameBoard.length; i++){
            for (int j = 0; j < gameBoard[0].length; j++){
                int diceFace = (int) (Math.random() * 6);
                gameBoard[i][j] = cubes.get((4 * i + j)%16).charAt(diceFace);
                if (4*i + j == cubes.size() - 1){
                    Collections.shuffle(cubes);
                }
            }
        }
    }

    private boolean recursePossibilities(String word, int r, int c) {
        return recursePossibilities(word, r, c, new boolean[gameBoard.length][gameBoard[0].length]);
    }

    private boolean recursePossibilities(String word, int r, int c, boolean[][] visited) {
        word = word.substring(1);

        if (word.length() <= 0){
            visited[r][c] = true;
            lastTilesSelected = visited;
            return true;
        }
        visited[r][c] = true;
        for (int i = Math.max(0, r - 1); i <= Math.min(gameBoard.length - 1, r + 1); i++) {
            for (int j = Math.max(0, c - 1); j <= Math.min(gameBoard[r].length - 1, c + 1); j++) {
                if (gameBoard[i][j] == word.charAt(0) && (!visited[i][j])) {
                    System.out.println(i + " " + j);
                    if (recursePossibilities(word, i, j, deepCopyVisitedArray(visited))) {
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

    public boolean[][] getLastTilesSelected() {
        return lastTilesSelected;
    }

    public BoggleDictionary getWordDictionary() {
        return wordDictionary;
    }

    public int getCurrentPlayer() { return currentPlayer; }

    public int[] getPlayerScores() { return playerScores; }

    public boolean[][] deepCopyVisitedArray(boolean[][] visited){
        boolean[][] copy = new boolean[visited.length][visited[0].length];
        for (int i = 0; i < visited.length; i++){
            for (int j = 0; j < visited[i].length; j++){
                copy[i][j] = visited[i][j];
            }
        }
        return copy;
    }
}
