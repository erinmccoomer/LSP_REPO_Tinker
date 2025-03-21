package org.howard.edu.lsp.midterm.question5;

/**
 * Driver class that demonstrates creating and using different types of media.
 */
public class StreamingServiceDriver {
    public static void main(String[] args) {
        // Create instances of different media types
        StreamableContent music = new Music("Still a Friend - Incognito");
        StreamableContent movie = new Movie("Avengers End Game");
        StreamableContent audiobook = new Audiobook("A Promised Land – Barack Obama");

        // Test the common behaviors for all media types (play, pause, stop)
        System.out.println("Testing common behaviors for all media types:\n");

        // Test Music
        System.out.println("Testing Music:");
        music.play();  // Output: "Playing: Still a Friend - Incognito"  
        music.pause();  // Output: "Paused: Still a Friend - Incognito"
        music.stop();   // Output: "Stopped: Still a Friend - Incognito"
        System.out.println();

        // Test Movie
        System.out.println("Testing Movie:");
        movie.play();  // Output: "Playing: Avengers End Game"
        movie.pause();  // Output: "Paused: Avengers End Game"
        movie.stop();   // Output: "Stopped: Avengers End Game"
        System.out.println();

        // Test Audiobook
        System.out.println("Testing Audiobook:");
        audiobook.play();  // Output: "Playing: A Promised Land – Barack Obama"
        audiobook.pause();  // Output: "Paused: A Promised Land – Barack Obama"
        audiobook.stop();   // Output: "Stopped: A Promised Land – Barack Obama"
        System.out.println();

        // Test unique behaviors for each media type

        // Test Movie-specific behavior (rewind)
        Movie movieWithRewind = (Movie) movie;  // Cast to Movie for specific method
        movieWithRewind.rewind(30);  // Output: "Rewinding movie: Avengers End Game by 30 seconds"
        System.out.println();

        // Test Audiobook-specific behavior (setPlaybackSpeed)
        Audiobook audiobookWithSpeed = (Audiobook) audiobook;  // Cast to Audiobook for specific method
        audiobookWithSpeed.setPlaybackSpeed(1.5);  // Output: "Setting playback speed of audiobook: A Promised Land – Barack Obama 1.5x"
        System.out.println();

        // Test Music-specific behavior (addToPlaylist)
        Music musicWithPlaylist = (Music) music;  // Cast to Music for specific method
        musicWithPlaylist.addToPlaylist("Favorites");  // Output: "Added Still a Friend - Incognito to Favorites playlist"
        System.out.println();
    }
}
