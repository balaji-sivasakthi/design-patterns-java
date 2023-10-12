package Structural.Proxy;

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