package wsu.team1.a2016.peglproxy;


import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class Client extends AsyncTask<Void, Void, Void> {


    @Override
    protected Void doInBackground(Void... params) {


        try (Socket kkSocket = new Socket(MainActivity.ip, MainActivity.port);
             PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));) {

            String fromServer;

            // while connection is alive
            while ((fromServer = in.readLine()) != null) {
//                out.println((20+ Math.random() *10) + ", 30");
                out.println(MainActivity.droneLocationLat + ", " + MainActivity.droneLocationLng);

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } catch (UnknownHostException e) {
        } catch (IOException e) {
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
//        textResponse.setText(response);
        super.onPostExecute(result);
    }
}
