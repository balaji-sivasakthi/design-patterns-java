# Iterator Design Pattern Example

## Table of Contents

- [Introduction](#introduction)
- [Motivation](#motivation)
- [Real-World Example](#real-world-example)

## Introduction

This project provides an example implementation of the Iterator design pattern in Java. The Iterator pattern is a
behavioral design pattern that provides a way to access elements of an aggregate object sequentially without exposing
its underlying representation. It is commonly used for traversing collections or lists.

## Motivation

The Iterator design pattern is beneficial when:

- You want to provide a uniform way to access elements of a collection without exposing its internal structure.
- You need to support multiple traversal methods for a collection.
- You aim to simplify client code and decouple it from the collection's implementation details.
- You want to enable traversal of custom data structures.

This pattern simplifies the process of iterating through collections and makes it more flexible.

## Real-World Example

**Scenario**: In a music player application, you have a playlist of songs, and you want to provide a way to traverse the
songs in the playlist. The Iterator pattern can be used to create an iterator that allows you to access the songs
sequentially.

```java
// Aggregate interface
interface Playlist {
    Iterator<Song> createIterator();
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

// Iterator interface
interface Iterator<T> {
    boolean hasNext();

    T next();
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
```