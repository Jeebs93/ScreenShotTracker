package Skillbox;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import static java.lang.Thread.sleep;

public class Main {

    private final static String ACCESS_TOKEN = "";

    public static void main(String[] args) throws AWTException, IOException {
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
        InputStream in;
        ByteArrayOutputStream os;
        BufferedImage image;


        for (int i = 0; i < 10; i++) {


            try {
                sleep(10000);
                image =
                        new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                os = new ByteArrayOutputStream();
                ImageIO.write(image, "jpeg", os);
                in = new ByteArrayInputStream(os.toByteArray());
                MyThread thread = new MyThread(client, in);
                thread.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


    }

}