package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {
    public static Properties readProperties() {
        InputStream inputStreamUser = null;
        InputStream inputStreamLogin = null;
        InputStream inputStreamHome = null;
        Properties properties = null;
        InputStream inputStreamEnv = null;

        try {
            properties = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            inputStreamUser = loader.getResourceAsStream("user.properties");
            properties.load(inputStreamUser);

            inputStreamLogin = loader.getResourceAsStream("login.properties");
            properties.load(inputStreamLogin);

            inputStreamHome = loader.getResourceAsStream("home.properties");
            properties.load(inputStreamHome);

            inputStreamEnv = loader.getResourceAsStream("environment.properties");
            properties.load(inputStreamEnv);

        } catch (IOException e) {
            e.printStackTrace();
        }

            finally {
            if (inputStreamUser != null) {
                try {
                    inputStreamUser.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (inputStreamLogin != null) {
                try {
                    inputStreamLogin.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (inputStreamHome != null) {
                try {
                    inputStreamHome.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (inputStreamEnv != null) {
                try {
                    inputStreamEnv.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return properties;
    }
}
