package org.howard.edu.lsp.midterm.question5;

/**
 * Movie content subclass that extends StreamableContent and adds movie-specific behavior.
 */
public class Movie extends StreamableContent {

    /**
     * Constructor to initialize Movie content with a title.
     *
     * @param title Title of the movie.
     */
    public Movie(String title) {
        super(title);
    }

    /**
     * Rewind the movie by a specified number of seconds.
     *
     * @param seconds Number of seconds to rewind.
     */
    public void rewind(int seconds) {
        System.out.println("Rewinding movie: " + title + " by " + seconds + " seconds");
    }
}
