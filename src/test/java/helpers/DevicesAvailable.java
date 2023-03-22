package helpers;

public enum DevicesAvailable {
    PIXEL2_ANDROID13("pixel2Android13"),
    PIXEL2_ANDROID10("pixel2Android10");
    private String name;

    DevicesAvailable(String deviceName) {
        this.name = deviceName;
    }

    public String getDeviceName() {
        return name;
    }
}
