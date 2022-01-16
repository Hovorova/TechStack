package io.techstack.beforeActionAndTestResources;

public class WaitUtils {
    public static void threadSleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
