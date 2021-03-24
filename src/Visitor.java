import java.util.ArrayList;
import java.util.Random;

public class Visitor {

    public String gender;
    public String danceStyle;

    private static String[] genders = { "male", "female"};
    private static String[] danceStyles = { "hip-hop", "electro", "pop"};

    public Visitor(String gender, String danceStyle) {
        this.gender = gender;
        this.danceStyle = danceStyle;
    }

//    public String activity(String music) {
//        String activity;
//        if (music.equals(danceStyle)) {
//            activity = "Dancing!";
//        }
//        else {
//            activity = "Going for drink!";
//        }
//        return activity;
//    }

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

    /* for test */
    public static void main(String[] args) {
        ArrayList<Visitor> club = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            club.add(visitorsGenerator());
        }

        for (Visitor visitor : club) {
            System.out.println(getValue(visitor));
        }
    }
}