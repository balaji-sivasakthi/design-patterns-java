# Proxy Design Pattern Example

## Table of Contents
- [Introduction](#introduction)
- [Motivation](#motivation)
- [Real-World Example](#real-world-example)

## Introduction

This project provides an example implementation of the Proxy design pattern in Java. The Proxy pattern is a structural design pattern that provides a surrogate or placeholder for another object to control access to it. It is often used to add an extra level of control, such as lazy initialization, access control, or logging, without changing the actual behavior of the real subject.

## Motivation

The Proxy design pattern is beneficial when:

- You need to control access to an object.
- You want to add additional functionality without modifying the real subject.
- You aim to improve performance by implementing lazy initialization.
- You want to create a virtual proxy for expensive-to-create objects.
- You need to perform access control, logging, or monitoring.

This pattern provides a way to manage interactions with the real subject while keeping the client code unaware of the added control.

## Real-World Example

**Scenario**: In a file downloading application, you want to provide the user with a way to download files. However, some files are large and expensive to download. You can use the Proxy pattern to implement a `FileDownloader` proxy that loads the actual file content only when requested.

```java
// Subject interface
interface File {
    void download();
}

// Real Subject
class RealFile implements File {
    private String filename;

    RealFile(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading file: " + filename);
    }

    public void download() {
        System.out.println("Downloading file: " + filename);
    }
}

// Proxy
class FileDownloaderProxy implements File {
    private RealFile realFile;
    private String filename;

    FileDownloaderProxy(String filename) {
        this.filename = filename;
    }

    public void download() {
        if (realFile == null) {
            realFile = new RealFile(filename);
        }
        realFile.download();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        File file = new FileDownloaderProxy("large_file.zip");

        // File content is loaded only when requested
        file.download();
    }
}
```