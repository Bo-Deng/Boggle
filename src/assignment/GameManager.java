package assignment;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class GameManager implements BoggleGame {
    private BoggleDictionary wordDictionary;
    private ArrayList<String> cubes;
    private char[][] gameBoard;
    private int[][] lastTilesSelected;
    public HashSet<String> foundWords;
    private String lastWord;
    private int[] playerScores;
    private int currentPlayer;
    private SearchTactic searchTactic;

    // Default Constructor always loads from words.txt and cubes.txt and a 4 x 4 board. (This basically is the default
    // version of Boggle with no frills added.)
    public GameManager() {
        cubes = new ArrayList<>();
        foundWords = new HashSet<>();
    }


    // Instantiates the objects needed to create a new Boggle game
    @Override
    public void newGame(int size, int numPlayers, String cubeFile, BoggleDictionary dict) throws IOException {
        if (size <= 0){
            System.err.println("Cannot have board of non-positive size");
            throw new IllegalArgumentException();
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

    // Returns a 2D array of the characters on the boggle board
    @Override
    public char[][] getBoard() {
        return gameBoard;
    }

    // Sets the current player (by default, human is 0 and computer is 1)
    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    // Checks the board to see if a word is valid and adds the associated score to a player
    @Override
    public int addWord(String word, int player) {
        word = word.toUpperCase();
        // Basic checks for validity
        if (word.length() < 4 || word.length() > 16|| !word.matches("[A-Z]+") || !wordDictionary.contains(word) || foundWords.contains(word)) {
            return 0;
        }

        for (int r = 0; r < gameBoard.length; r++) {
            boolean isValid = false;
            for (int c = 0; c < gameBoard[r].length; c++) {
                if (gameBoard[r][c] == word.charAt(0)) {
                    isValid = recursePossibilities(word, r, c);
                    if (isValid == true){
                        lastWord = word;
                        foundWords.add(lastWord);
                        int wordScore = word.length() - 3;
                        playerScores[player] += wordScore;
                        return wordScore;
                    }
                }
            }
            if (isValid == true){
                lastWord = word;
                foundWords.add(lastWord);

                int wordScore = word.length() - 3;
                playerScores[player] += wordScore;
                return wordScore;
            }
        }
        return 0;
    }

    // Returns the a list of the tile locations of the last added word
    @Override
    public List<Point> getLastAddedWord() {
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < lastTilesSelected.length; i++){
            for (int j = 0; j < lastTilesSelected[i].length; j++){
                if (lastTilesSelected[i][j] != 0){
                    points.add(new Point(i, j));
                }
            }
        }
        return points;
    }

    // Sets the game board to a custom arrangement
    @Override
    public void setGame(char[][] board) {
        gameBoard = board;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                board[i][j] = Character.toUpperCase(board[i][j]);
            }
        }
        foundWords = new HashSet<>();
        playerScores = new int[playerScores.length];
        currentPlayer = 0;
    }

    // Returns an ArrayList of all the valid words on the board using one of two search tactics
    @Override
    public Collection<String> getAllWords() {
        if (searchTactic == SearchTactic.SEARCH_DICT) {
            return dictionarySearch();
        }
        return boardSearch();
    }

    // Iterates through the dictionary to return an ArrayList of all valid words
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

    // Uses depth first search on the board to return an ArrayList of all valid words
    private Collection<String> boardSearch() {
        ArrayList<String> allWords = new ArrayList<>();
        for (int r = 0; r < gameBoard.length; r++){
            for (int c = 0; c < gameBoard[r].length; c++){
                recursiveBoardSearch(r,c,new int[gameBoard.length][gameBoard[0].length],"",allWords, 1);
            }
        }
        return allWords;
    }

    // Depth first search implementation to find valid words on the board
    private void recursiveBoardSearch(int r, int c, int[][] visited, String currentWord, ArrayList<String> allWords, int letterIndex){
        currentWord += gameBoard[r][c];
        visited[r][c] = letterIndex;
        if (!wordDictionary.isPrefix(currentWord)){
            return;
        }

        // if the word is valid, add to the player's score (usually the computer)
        if (wordDictionary.contains(currentWord) && !foundWords.contains(currentWord) && currentWord.length() > 3){
            foundWords.add(currentWord);
            allWords.add(currentWord);
            playerScores[currentPlayer] += (currentWord.length() - 3);
        }

        // recurse through all currently valid paths
        for (int i = Math.max(0, r - 1); i <= Math.min(gameBoard.length - 1, r + 1); i++) {
            for (int j = Math.max(0, c - 1); j <= Math.min(gameBoard[r].length - 1, c + 1); j++) {
                if (visited[i][j] == 0) {
                    recursiveBoardSearch(i,j,deepCopyVisitedArray(visited),currentWord,allWords, letterIndex + 1);
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

    // Loads in a file containing the boggle cubes
    private void loadCube(String cubesFile) throws IOException {
        try {
            Scanner cubeReader = new Scanner(new File(cubesFile));
            while (cubeReader.hasNextLine()){
                cubes.add(cubeReader.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Cubes File not Found");
            throw new IOException();
        }
        if (cubes.size() == 0){
            System.err.println("No dice in cubes file");
            throw new IllegalArgumentException();
        }

    }

    // Generates dice states randomly using the given cubes
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

    // recursively checks to see if a word is on the board (helper)
    private boolean recursePossibilities(String word, int r, int c) {
        return recursePossibilities(word, r, c, new int[gameBoard.length][gameBoard[0].length], 1);
    }

    // recursively checks to see if a word is on the board
    private boolean recursePossibilities(String word, int r, int c, int[][] visited, int letterIndex) {
        word = word.substring(1);

        if (word.length() <= 0){
            visited[r][c] = letterIndex;
            lastTilesSelected = visited;
            return true;
        }
        visited[r][c] = letterIndex;
        for (int i = Math.max(0, r - 1); i <= Math.min(gameBoard.length - 1, r + 1); i++) {
            for (int j = Math.max(0, c - 1); j <= Math.min(gameBoard[r].length - 1, c + 1); j++) {
                if (gameBoard[i][j] == word.charAt(0) && (visited[i][j] == 0)) {
                    if (recursePossibilities(word, i, j, deepCopyVisitedArray(visited), letterIndex + 1)) {
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

    public int[][] getLastTilesSelected() {
        return lastTilesSelected;
    }

    public BoggleDictionary getWordDictionary() {
        return wordDictionary;
    }

    public int getCurrentPlayer() { return currentPlayer; }

    public int[] getPlayerScores() { return playerScores; }

    // constructs a deep copy of the visited array for each search path
    private int[][] deepCopyVisitedArray(int[][] visited){
        int[][] copy = new int[visited.length][visited[0].length];
        for (int i = 0; i < visited.length; i++){
            for (int j = 0; j < visited[i].length; j++){
                copy[i][j] = visited[i][j];
            }
        }
        return copy;
    }

    public void clearFoundTiles(){
        foundWords.clear();
    }

    public void clearScores(){
        playerScores = new int[playerScores.length];
    }
}
