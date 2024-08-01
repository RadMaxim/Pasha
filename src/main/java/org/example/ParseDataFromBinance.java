package org.example;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class ParseDataFromBinance {
    public static ArrayList<Crypto> getData()  {
        try {
            URL url = new URL("https://api.binance.com/api/v3/ticker/price");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String data = bufferedReader.readLine();
            JSONArray jsonArray = new JSONArray(data);
            return ReplaceArray.replaceData(jsonArray);
        } catch (MalformedURLException e) {
            System.err.println("Link is not correct.....");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.err.println("The problem take data.....");
            throw new RuntimeException(e);
        }

    }
}
