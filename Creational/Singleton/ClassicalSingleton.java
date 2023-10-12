package Creational.Singleton;

class ClassicalSingleton {
    private static ClassicalSingleton instance;

    private ClassicalSingleton() {
    }

    public static ClassicalSingleton getInstance() {
        if (instance == null) {
            instance = new ClassicalSingleton();
        }
        return instance;
    }
}