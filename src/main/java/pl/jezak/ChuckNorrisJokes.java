package pl.jezak;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ChuckNorrisJokes {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            Joke joke = downloadJoke();
            System.out.println(joke.value);
        }
    }
    
    private static Joke downloadJoke() throws IOException {
        URL url = new URL("https://api.chucknorris.io/jokes/random");
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Chrome");

        Scanner scanner = new Scanner(connection.getInputStream());
        String chuckJsonString = scanner.nextLine();

        Gson gson = new Gson();

        return gson.fromJson(chuckJsonString, Joke.class);
    }
}
