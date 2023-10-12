package Behavioural.Iterator;

// Aggregate interface
interface Playlist {
    Iterator<Song> createIterator();
}

// Iterator interface
interface Iterator<T> {
    boolean hasNext();

    T next();
}

// Concrete aggregate
class SongPlaylist implements Playlist {
    private Song[] songs;

    SongPlaylist(Song[] songs) {
        this.songs = songs;
    }

    public Iterator<Song> createIterator() {
        return new ArrayIterator(songs);
    }
}

// Song class
class Song {
    private String title;

    Song(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

// Concrete iterator
class ArrayIterator implements Iterator<Song> {
    private Song[] songs;
    private int position;

    ArrayIterator(Song[] songs) {
        this.songs = songs;
        this.position = 0;
    }

    public boolean hasNext() {
        return position < songs.length;
    }

    public Song next() {
        if (hasNext()) {
            return songs[position++];
        }
        return null;
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Song[] songs = {
                new Song("Song 1"),
                new Song("Song 2"),
                new Song("Song 3")
        };

        Playlist playlist = new SongPlaylist(songs);
        Iterator<Song> iterator = playlist.createIterator();

        while (iterator.hasNext()) {
            Song song = iterator.next();
            System.out.println("Playing: " + song.getTitle());
        }
    }
}