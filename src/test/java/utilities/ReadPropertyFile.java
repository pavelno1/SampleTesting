package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Paweł on 24.10.2022.
 */
public class ReadPropertyFile {

    public static void reader() throws IOException {

        FileReader fr = new FileReader("C:\\Users\\Paweł\\IdeaProjects\\SampleTesting\\src\\test\\resources\\configfiles\\config.properties");

        Properties p = new Properties();

        p.load(fr);

        System.out.println(p.getProperty("browser"));
        System.out.println(p.getProperty("initialUrl"));

    }

}
