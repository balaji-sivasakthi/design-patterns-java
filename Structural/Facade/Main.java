package Structural.Facade;

// Subsystem components
class DVDPlayer {
    void on() { /* Implementation */ }

    void play(String movie) { /* Implementation */ }

    void stop() { /* Implementation */ }
}

class Amplifier {
    void on() { /* Implementation */ }

    void setSurroundSound() { /* Implementation */ }

    void setVolume(int volume) { /* Implementation */ }
}

class Projector {
    void on() { /* Implementation */ }

    void setInput(DVDPlayer dvdPlayer) { /* Implementation */ }

    void wideScreenMode() { /* Implementation */ }
}

class Screen {
    void down() { /* Implementation */ }

    void up() { /* Implementation */ }
}

// Facade
class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Amplifier amplifier;
    private Projector projector;
    private Screen screen;

    HomeTheaterFacade(DVDPlayer dvdPlayer, Amplifier amplifier, Projector projector, Screen screen) {
        this.dvdPlayer = dvdPlayer;
        this.amplifier = amplifier;
        this.projector = projector;
        this.screen = screen;
    }

    void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        screen.down();
        projector.on();
        projector.setInput(dvdPlayer);
        amplifier.on();
        amplifier.setSurroundSound();
        amplifier.setVolume(7);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    void endMovie() {
        System.out.println("Shutting down the movie...");
        dvdPlayer.stop();
        dvdPlayer.on();
        screen.up();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        DVDPlayer dvdPlayer = new DVDPlayer();
        Amplifier amplifier = new Amplifier();
        Projector projector = new Projector();
        Screen screen = new Screen();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, amplifier, projector, screen);

        homeTheater.watchMovie("The Matrix");
        homeTheater.endMovie();
    }
}
