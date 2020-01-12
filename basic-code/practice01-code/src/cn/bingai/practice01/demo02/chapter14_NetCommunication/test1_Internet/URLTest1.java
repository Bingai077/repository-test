package cn.bingai.practice01.demo02.chapter14_NetCommunication.test1_Internet;

import javax.net.ssl.HttpsURLConnection;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author bingai
 * @create 2019-11-11 23:07
 */
public class URLTest1 {
    public static void main(String[] args)  {

        HttpsURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("https://nba.stats.qq.com/player/?id=4563");

            urlConnection = (HttpsURLConnection) url.openConnection();

            urlConnection.connect();

            is = urlConnection.getInputStream();
            fos = new FileOutputStream("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter14_NetCommunication\\test1_Internet\\1.html");

            byte[] by = new byte[1024];
            int len;
            while((len = is.read(by)) != -1){
                fos.write(by,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(urlConnection != null){
                urlConnection.disconnect();
            }

        }






    }
}
