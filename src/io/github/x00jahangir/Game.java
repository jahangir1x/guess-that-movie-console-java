package io.github.x00jahangir;

public class Game {
    private enum GameState {
        Playing,
        Lost,
        Won
    }

    private MovieListManager movieListManager;
    private String actualMovieTitle;
    private String hiddenMovieTitle;
    private String rightLetters;
    private String wrongLetters;
    private int totalWrongGuess;

    public Game() {
        rightLetters = "";
        wrongLetters = "";
        totalWrongGuess = 0;

        // show welcome messages
        System.out.println("                     ---Guess That Movie---\n");
    }

    /**
     * Main Game loop...
     */
    public void StartGame() {
        CacheMovies();
        SetHiddenMovieTitle();

        while (true) {
            UserIO.ShowGameProgress(hiddenMovieTitle, wrongLetters, totalWrongGuess);
            String userGuess = UserIO.GetValidGuess(rightLetters);
            ProcessHiddenLetters(userGuess);

            GameState currentGameState = GetGameProgress();

            if (currentGameState == GameState.Lost) {
                UserIO.ShowLoseMessage(actualMovieTitle);
                return;
            }
            if (currentGameState == GameState.Won) {
                UserIO.ShowWinMessage(actualMovieTitle);
                return;
            }
        }
    }

    /**
     * check whether user won or lost or playing
     *
     * @return returns Won or Lost or Playing
     */
    private GameState GetGameProgress() {
        if (!hiddenMovieTitle.contains("_")) {
            return GameState.Won;
        }
        if (totalWrongGuess >= 10) {
            return GameState.Lost;
        } else {
            return GameState.Playing;
        }
    }

    /**
     * updates Hidden movie title according to guesses.
     *
     * @param userGuess the 1 character string to check with actual movie title.
     */
    private void ProcessHiddenLetters(String userGuess) {
        if (actualMovieTitle.contains(userGuess.toLowerCase()) || actualMovieTitle.contains(userGuess.toUpperCase())) {
            rightLetters += userGuess;
            String replaceCharRegex = "[a-zA-Z&&[^" + rightLetters + rightLetters.toUpperCase() + "]]";
            hiddenMovieTitle = actualMovieTitle.replaceAll(replaceCharRegex, "_");
        } else {
            totalWrongGuess += 1;
            if (!wrongLetters.contains(userGuess)) {
                wrongLetters += userGuess;
            }
        }
    }


    public void CacheMovies() {
        movieListManager = new MovieListManager("res/movies.txt");
    }

    /**
     * get random movie title and
     * set hidden movie title for first time
     */
    private void SetHiddenMovieTitle() {
        actualMovieTitle = movieListManager.GetRandomMovie();
        hiddenMovieTitle = actualMovieTitle.replaceAll("[a-zA-Z]", "_");
    }

}
