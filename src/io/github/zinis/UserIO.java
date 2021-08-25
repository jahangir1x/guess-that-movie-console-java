package io.github.zinis;

import java.util.Scanner;

public class UserIO {

    /**
     * shows current game progression: the movie title user revealed so far, wrong letters and total wrong guess
     * @param partiallyRevealedMovieTitle
     * @param wrongLetters
     * @param totalWrongGuess
     */
    public static void ShowGameProgress(String partiallyRevealedMovieTitle,String wrongLetters,int totalWrongGuess) {

        System.out.println("You are guessing:" + partiallyRevealedMovieTitle);
        System.out.print("You have guessed (" + totalWrongGuess + ") wrong letters: ");
        for (char letter: wrongLetters.toCharArray()){
            System.out.print(letter + " ");
        }
        System.out.println();
    }

    /**
     * returns valid input from user.
     * user cannot input multiple letters or numbers or special characters or previously right character.
     * @param rightLetters
     * @return
     */
    public static String GetValidGuess(String rightLetters) {
        while (true) {
            System.out.print("Guess a letter: ");
            Scanner scanner = new Scanner(System.in);
            String userGuess = scanner.nextLine().toLowerCase();

            if (userGuess.length() != 1) {
                System.out.println("Please input only one letter.");
            }
            else if (rightLetters.contains(userGuess)) {
                System.out.println("You already guessed \"" + userGuess + "\"");
            }
            else if (!userGuess.matches("[a-z]")) {
                System.out.println("Please input valid letter");
            }
            else{
                return userGuess;
            }
        }
    }


    public static void ShowWinMessage(String movieTitle) {
        System.out.println("You Win!");
        System.out.println("You have guessed '" + movieTitle + "' correctly");
    }

    public static void ShowLoseMessage(String movieTitle) {
        System.out.println("You Lose!");
        System.out.println("You were unable to guess '" + movieTitle + "' correctly");
    }
}
