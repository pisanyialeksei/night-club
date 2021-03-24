import java.util.Random;

public class Music {

    private static String[] musicStyle = { "hip-hop", "electro", "pop" };

    public static String playingMusic() {
        Random random = new Random();
        int index = random.nextInt(musicStyle.length);
        return musicStyle[index];
    }

    public static void main(String[] args) {

    }
}