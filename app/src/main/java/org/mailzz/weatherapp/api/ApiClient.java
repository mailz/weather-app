package org.mailzz.weatherapp.api;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Dmitriy Trandin on 25.10.2015.
 * Implementation of HTTP Client, which executes api requests
 */
public class ApiClient {

    //config HttpURLConnection
    public static final int READ_TIMEOUT_MILLIS = 10000;
    public static final int CONNECT_TIMEOUT_MILLIS = 15000;
    //http codes
    public static final int RESPONSE_CODE_OK = 200;
    private final String DEBUG_TAG = "ApiClient";

    public ApiClient() {
    }

    public Observable<String> execute(final Request request){
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if(!subscriber.isUnsubscribed()) {
                    try {
                        String result = loadFromNetwork(request.getMethod(), request.getUrl());
                        subscriber.onNext(result);
                    } catch (Throwable t) {
                        subscriber.onError(t);
                    }
                    subscriber.onCompleted();
                }
            }
        });
    }

    private String loadFromNetwork(String method, String myurl){
        InputStream is = null;
        StringBuilder sb  = new StringBuilder();
        try {
            URL url = new URL(myurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(READ_TIMEOUT_MILLIS);
            connection.setConnectTimeout(CONNECT_TIMEOUT_MILLIS);
            connection.setRequestMethod(method);
            connection.setDoInput(true);
            // Starts the query
            connection.connect();
            int response = connection.getResponseCode();
            Log.d(DEBUG_TAG, "The response is: " + response);
            if(response != RESPONSE_CODE_OK){
                throw new Error("network error");
            }
            is = connection.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String decodedString;

            while ((decodedString = in.readLine()) != null) {
                System.out.println(decodedString);
                sb.append(decodedString);
            }
            in.close();
        } catch (Exception ex){
            throw new Error(ex);
        }finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}



//    ConnectivityManager connMgr = (ConnectivityManager)
//            getSystemService(Context.CONNECTIVITY_SERVICE);
//    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
//    if (networkInfo != null && networkInfo.isConnected()) {
//        // fetch data
//    } else {
//        // display error
//    }