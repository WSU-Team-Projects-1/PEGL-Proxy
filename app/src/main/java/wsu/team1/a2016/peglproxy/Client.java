package wsu.team1.a2016.peglproxy;


import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class Client extends AsyncTask<Void,Void,Void>{

    private Socket p(Object o){
        Log.d("I", o.toString());
        return null;
    }

    @Override
    protected Void doInBackground(Void... params) {


        System.out.println("client start");

        Log.d("I", MainActivity.ip +" " +MainActivity.port);

        try (Socket kkSocket = new Socket(MainActivity.ip, MainActivity.port);
             Socket aaaa = p("adfsd");
             PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));) {

            String fromServer;
            Log.d("I", "In there");

            // while connection is alive
            while ((fromServer = in.readLine()) != null) {
                // System.out.println("Server: " + fromServer);

//                GpsLocation gpsLocation = new GpsLocation(39.781361 + Math.random(), 84.067882);

//                out.println(gpsLocation.toString());
                out.println((20+ Math.random() *10) + ", 30");


                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        } catch (UnknownHostException e) {
            Log.d("I","Don't know about host " );
        } catch (IOException e) {
            Log.d("I","Couldn't get I/O for the connection to " );
        }

        Log.d("I", "it ended?");
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
//        textResponse.setText(response);
        super.onPostExecute(result);
    }
}
