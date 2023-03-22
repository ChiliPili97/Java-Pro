package homeWork8.game;

public class DemoGame {
    public static void main(String[] args) {

        Participant[] participants = new Participant[3];
        participants[0] = new Participant("human", 1, 1000);
        participants[1] = new Participant("cat", 3, 700);
        participants[2] = new Participant("robot", 2, 2000);
        Barrier[] barriers = new Barrier[2];
        barriers[0] = new Wall(2);
        barriers[1] = new Racetrack(800);

        Competition.start(participants, barriers);
    }
}
