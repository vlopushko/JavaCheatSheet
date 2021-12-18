import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFiles {

    //ЗАПИСЬ
    public void write() {
        try (OutputStream output = new FileOutputStream("resources/config.properties")) {

            Properties prop = new Properties();

            prop.setProperty("db.url", "localhost");
            prop.setProperty("db.user", "user");
            prop.setProperty("db.password", "password");

            prop.store(output, null);

            System.out.println(prop);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    //ЧТЕНИЕ
    public void read() {
        //try (InputStream input = new FileInputStream("resources/config.properties")) {
        //try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
        try (InputStream input = PropertiesFiles.class.getClassLoader().getResourceAsStream("config.properties")) {

            Properties prop = new Properties();

            prop.load(input);

            System.out.println(prop.getProperty("db.url"));

            prop.forEach((key, value) -> System.out.println("Key: " + key + "; Value: "+ value));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PropertiesFiles propertiesFiles = new PropertiesFiles();
        propertiesFiles.write();
        propertiesFiles.read();
    }
}
