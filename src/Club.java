import java.util.ArrayList;

public class Club {

    private static ArrayList<Visitor> club = new ArrayList<>();
    private static ArrayList<Visitor> danceFloor = new ArrayList<>();
    private static ArrayList<Visitor> bar = new ArrayList<>();

    private static void clubOpened(int numberOfVisitors) {
        for (int i = 0; i < numberOfVisitors; i++) {
            club.add(Visitor.visitorsGenerator());
        }

        System.out.println("Visitors coming to the club:");
        for (Visitor visitor : club) {
            System.out.println(Visitor.getValue(visitor));
        }
    }

    private static void visitorsActivity(String music) {
        for (Visitor visitor : club) {
            if (visitor.activity(music)) {
                danceFloor.add(visitor);
            } else {
                bar.add(visitor);
            }
        }

        System.out.println("\nOn the dancefloor " + danceFloor.size() + " persons: " + danceFloor);
        System.out.println("\nIn the bar " + bar.size() + " persons: " + bar);

        danceFloor = new ArrayList<>();
        bar = new ArrayList<>();
    }

    private static void party() {
        Thread run = new Thread(() -> {
            while(true){
                try {
                    String music = Music.playingMusic();
                    visitorsActivity(music);
                    Thread.sleep(5000);
                } catch (InterruptedException ignored) {

                }
            }
        });
        run.start();
    }

    public static void main(String[] args) {
        clubOpened(6);
        party();
    }
}