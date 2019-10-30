import twitter.TwitterSearch;

import java.io.IOException;

public class Inicio {
    public static void main(String[] args) throws IOException {
        try {

            TwitterSearch twitter = new TwitterSearch();
            twitter.search();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
