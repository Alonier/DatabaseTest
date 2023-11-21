package src;

public class Fest {
    public static long id = 0;
    public static String name;

    public static String getFestName() {
        return name;
    }

    public static long getFestId() {
        return id;
    }

    public static void setFestName(String arr) {
        name = arr;
    }

    public static void setFestId(long value) {
        id = value;
    }
}
