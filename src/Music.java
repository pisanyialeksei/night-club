import java.util.Random;

public class Music {

    private static String[] musicStyle = { "hip-hop", "electro", "pop" };

    public static String playingMusic() {
        Random random = new Random();
        int index = random.nextInt(musicStyle.length);
        System.out.println("\nNow playing: " + musicStyle[index]);
        return musicStyle[index];
    }
}