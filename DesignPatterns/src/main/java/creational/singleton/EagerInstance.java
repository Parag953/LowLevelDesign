package creational.singleton;

public class EagerInstance {
    private static final EagerInstance instance = new EagerInstance();

    private EagerInstance() {}

    public static EagerInstance getInstance() {
        return instance;
    }

}
