package org.howard.edu.lsp.midterm.question5;

/**
 * Audiobook content subclass that extends StreamableContent and adds audiobook-specific behavior.
 */
public class Audiobook extends StreamableContent {

    /**
     * Constructor to initialize Audiobook content with a title.
     *
     * @param title Title of the audiobook.
     */
    public Audiobook(String title) {
        super(title);
    }

    /**
     * Set the playback speed for the audiobook.
     *
     * @param speed Playback speed (e.g., 1.5 for 1.5x speed).
     */
    public void setPlaybackSpeed(double speed) {
        System.out.println("Setting playback speed of audiobook: " + title + " " + speed + "x");
    }
}
