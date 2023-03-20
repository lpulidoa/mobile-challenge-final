package driverfactory;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {
            case ANDROID:
                driverManager = new AndroidDriverManager();
                break;
            case IOS:
                driverManager = new IOSDriverManager();
                break;
            default:
                driverManager = new AndroidDriverManager();
                break;
        }
        return driverManager;

    }
}
