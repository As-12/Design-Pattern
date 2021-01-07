package FacadePattern;

/* Facade Pattern provides a unified interface to a set of interfaces in a subsystem.
 * This also decouple client dependency to the subsystems, making it easier to change.
 *
 * Facade Pattern should follow Least Knowledge Principle.
 *  Object should only talk to:
 *      - the object itself
 *      - object passed as a parameter
 *      - object that it creates
 *      - Any component of the object
 */


class MoviePlayer {
    public void playMovie(String title) {
        System.out.println("Playing movie " + title);
    }
}

class Speaker {
    public void playSpeaker(String title) {
        System.out.println("Playing sound from " + title + " movie");
    }
}

class Light {
    public void turnOn() {
        System.out.println("Light is on!");
    }
    public void turnOff() {
        System.out.println("Light is off!");
    }
}

class TV {
    public void turnOn() {
        System.out.println("TV is on!");
    }
    public void turnOff() {
        System.out.println("TV is off!");
    }
}


class LivingRoomFacade {
    private final TV tv;
    private final Light light;
    private final Speaker speaker;
    private final MoviePlayer player;

    LivingRoomFacade(TV tv, Light light, Speaker speaker, MoviePlayer player) {
        this.tv = tv;
        this.light = light;
        this.speaker = speaker;
        this.player = player;
    }
    public void watchMovie(String title) {
        System.out.println("----- Watching Movie ------");
        this.tv.turnOn();
        this.light.turnOff();
        this.player.playMovie(title);
        this.speaker.playSpeaker(title);
    }

    public void endMovie() {
        System.out.println("----- Ending Movie ------");
        this.tv.turnOff();
        this.light.turnOn();
    }
}
public class main {
    public static void main(String[] args) {

        LivingRoomFacade facade = new LivingRoomFacade(new TV(), new Light(), new Speaker(), new MoviePlayer());
        facade.watchMovie("Batman");
        facade.endMovie();
    }
}
