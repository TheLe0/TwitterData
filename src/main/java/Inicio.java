import java.io.IOException;

public class Inicio {
    public static void main(String[] args) {
        try {
            TwitterSearch twitter = new TwitterSearch();
            twitter.search();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
