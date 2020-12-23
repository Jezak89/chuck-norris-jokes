package pl.jezak;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ChuckNorrisJokes {
    public static void main(String[] args) throws IOException {
        //For loop execute a set of statements repeatedly, increments ten times
        for (int i = 0; i < 10; i++) {
            //Invoke downloadJoke() method
            Joke joke = downloadJoke();
            System.out.println(joke.value);
        }
    }

    private static Joke downloadJoke() throws IOException {
        //It's used to create an instance of the URL class
        URL url = new URL("https://api.chucknorris.io/jokes/random");

        //Represent a communications link between the application and URL
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Chrome");

        //It's used to create an instance of the Scanner class that produces
        // values scanned from the specified input stream
        Scanner scanner = new Scanner(connection.getInputStream());
        String chuckJsonString = scanner.nextLine();

        //It's used to create an instance of the GSON class
        Gson gson = new Gson();

        //Return deserialization JSON as a result
        return gson.fromJson(chuckJsonString, Joke.class);
    }
}
