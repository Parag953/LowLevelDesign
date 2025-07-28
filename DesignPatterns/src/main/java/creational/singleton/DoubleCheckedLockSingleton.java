package creational.singleton;

public class DoubleCheckedLockSingleton {
    private static volatile DoubleCheckedLockSingleton instance;

    private DoubleCheckedLockSingleton() {}

    public static DoubleCheckedLockSingleton getInstance(){
        if(instance == null){
            synchronized (DoubleCheckedLockSingleton.class){
                if(instance == null){
                    instance = new DoubleCheckedLockSingleton();
                }
            }
        }
        return instance;
    }
}
