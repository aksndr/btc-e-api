/**
 * User: a.arzamastsev Date: 27.02.14 Time: 12:52
 */

import ru.avks.btce.exchange.BTCRUR;
import ru.avks.btce.model.personal.InfoObject;
import ru.avks.btce.net.HttpConnection;
import ru.avks.btce.traider.Exchange;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MainTest {
    private static Properties prop;

    private static String key;
    private static String secret;

    private static String proxyHost;
    private static int proxyPort;
    private static String user;
    private static String password;

    public static void main(String[] args) {
        try {
            readProperties();

            HttpConnection httpConnection = new HttpConnection(proxyHost, proxyPort, user, password);
            Exchange exchange = new Exchange(key, secret);
            exchange.setHttpConnection(httpConnection);
            exchange.setCurrencyObject(new BTCRUR());
            InfoObject infoObject = exchange.getInfo();
            System.out.print(infoObject.getBTC());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private static void readProperties() throws IOException {
        prop = new Properties();
        InputStream input = null;

        try {
            input = MainTest.class.getResourceAsStream("app.properties");
            prop.load(input);
            if (prop.size()>0){
                key = prop.getProperty("key");
                secret = prop.getProperty("secret");

                proxyHost = prop.getProperty("proxyHost");
                proxyPort = Integer.parseInt(prop.getProperty("proxyPort"));
                user = prop.getProperty("user");
                password = prop.getProperty("password");

            } else {
                throw new IllegalArgumentException("Property file is empty");
            }

//        } catch (IOException ex) {
//            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
