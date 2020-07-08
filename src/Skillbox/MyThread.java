package Skillbox;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread {

    DbxClientV2 client;
    InputStream in;
    ByteArrayOutputStream os;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");

    MyThread(DbxClientV2 client, InputStream in) {
        this.client = client;
        this.in = in;
    }

    @Override
    public void run() {

        try {
            client.files().uploadBuilder("/" + formatter.format(new Date()) + ".png").uploadAndFinish(in);
        } catch (DbxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
