package app;
public class LibraryApp {
    private static final String appName = "Biblioteka v1.3";
    public static void main(String[] args) {

        System.out.println(appName);
        LIbraryControl libControl = new LIbraryControl();
        libControl.controlLoop();

    }
}
