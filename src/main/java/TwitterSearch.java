import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterSearch {

    private Query query;
    private QueryResult result;
    private ConfigurationBuilder cb;
    private TwitterFactory tf;
    private Twitter twitter;

    public TwitterSearch() {

        this.cb = new ConfigurationBuilder();
        this.cb.setDebugEnabled(true)
                .setOAuthConsumerKey("//TODO")
                .setOAuthConsumerSecret("//TODO")
                .setOAuthAccessToken("//TODO")
                .setOAuthAccessTokenSecret("//TODO");
        this.tf = new TwitterFactory(cb.build());
        this.twitter = tf.getInstance();
    }

    public void search() {

        try {
            this.query = new Query("source:twitter4j yusukey");
            this.result = this.twitter.search(query);

            for (Status status : result.getTweets()) {
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
            }
        } catch(TwitterException e) {
            e.printStackTrace();
        }
    }

}
