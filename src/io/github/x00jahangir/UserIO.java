package io.github.x00jahangir;

import java.util.Scanner;

public class UserIO {

    /**
     * shows current game progression: the movie title user revealed so far, wrong letters and total wrong guess
     * @param partiallyRevealedMovieTitle       the title to show to user
     * @param wrongLetters                      wrong letter inputs by user
     * @param totalWrongGuess                   total wrong guess by user
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
     * @param rightLetters      right guess string by users
     * @return                  returns valid input from user
     */
    public static String GetValidGuess(String rightLetters) {
        while (true) {
            System.out.print("Guess a letter: ");
            Scanner scanner = new Scanner(System.in);
            String userGuess = scanner.nextLine().toLowerCase();

            if (userGuess.matches(".*[^a-zA-Z].*")) {
                System.out.println("Please input valid letter");
            }
            else if (userGuess.length() != 1) {
                System.out.println("Please input only one letter.");
            }
            else if (rightLetters.contains(userGuess)) {
                System.out.println("You already guessed \"" + userGuess + "\"");
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
