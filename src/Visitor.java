import java.util.Random;

public class Visitor {

    private String gender;
    private String danceStyle;

    private static final String[] genders = { "male", "female"};
    private static final String[] danceStyles = { "hip-hop", "electro", "pop"};

    private Visitor(String gender, String danceStyle) {
        this.gender = gender;
        this.danceStyle = danceStyle;
    }

    public boolean activity(String music) {
        return music.equals(danceStyle);
    }

    public static Visitor visitorsGenerator() {
        Random random = new Random();
        int randomGenderIndex = random.nextInt(genders.length);
        int randomDanceStyleIndex = random.nextInt(danceStyles.length);

        String randomGender = genders[randomGenderIndex];
        String randomDanceStyle = danceStyles[randomDanceStyleIndex];
        return new Visitor(randomGender, randomDanceStyle);
    }

    @Override
    public String toString() {
        return gender + " " + danceStyle;
    }

    public static String getValue(Visitor visitor) {
        return visitor.toString();
    }
}