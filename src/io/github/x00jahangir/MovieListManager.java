package io.github.x00jahangir;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieListManager {
    private final ArrayList<String> movieList;

    /**
     * Cache all the movies.
     * @param moviesFilePath      path of movies texts file.
     */
    public MovieListManager(String moviesFilePath) {
        movieList = new ArrayList<>();
        try {
            File moviesFile = new File(moviesFilePath);
            Scanner moviesScanner = new Scanner(moviesFile);

            while (moviesScanner.hasNextLine()) {
                movieList.add(moviesScanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("error: " + moviesFilePath + " " + "does not exist");
        }
    }

    /**
     * 
     * @return random movie title.
     */
    public String GetRandomMovie(){
        int movieIndex = (int) (Math.random() * movieList.size());
        return movieList.get(movieIndex);
    }


}
