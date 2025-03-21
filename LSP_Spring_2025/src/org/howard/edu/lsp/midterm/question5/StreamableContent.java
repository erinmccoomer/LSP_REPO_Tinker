package org.howard.edu.lsp.midterm.question5;

/**
 * Base class for all types of streamable content, providing common behaviors.
 */
public class StreamableContent {
    protected String title;

    /**
     * Constructor to initialize streamable content with a title.
     *
     * @param title Title of the streamable content (movie, music, audiobook).
     */
    public StreamableContent(String title) {
        this.title = title;
    }

    /**
     * Play the streamable content.
     */
    public void play() {
        System.out.println("Playing: " + title);
    }

    /**
     * Pause the streamable content.
     */
    public void pause() {
        System.out.println("Paused: " + title);
    }

    /**
     * Stop the streamable content.
     */
    public void stop() {
        System.out.println("Stopped: " + title);
    }
}
