package org.howard.edu.lsp.midterm.question5;

/**
 * Music content subclass that extends StreamableContent and adds music-specific behavior.
 */
public class Music extends StreamableContent {

    /**
     * Constructor to initialize Music content with a song title.
     *
     * @param song Title of the song.
     */
    public Music(String song) {
        super(song);
    }

    /**
     * Add the song to a playlist.
     *
     * @param playlistName Name of the playlist.
     */
    public void addToPlaylist(String playlistName) {
        System.out.println("Added " + title + " to " + playlistName + " playlist");
    }
}

