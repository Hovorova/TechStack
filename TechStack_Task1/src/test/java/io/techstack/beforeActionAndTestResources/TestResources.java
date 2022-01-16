package io.techstack.beforeActionAndTestResources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestResources {
    private static final String TEST_RESOURCE = "src/test/resources/TestResources.properties";
    private static FileInputStream fileInputStream;
    private static Properties properties;

    static {
        try {
            fileInputStream = new FileInputStream(TEST_RESOURCE);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Can not open resource file", e);
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException("Can not close input stream", e);
                }
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

