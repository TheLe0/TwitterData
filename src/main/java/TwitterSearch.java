import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;

public class TwitterSearch {

    private Query query;
    private QueryResult result;
    private ConfigurationBuilder cb;
    private TwitterFactory tf;
    private Twitter twitter;

    public TwitterSearch() {

        this.cb = new ConfigurationBuilder();
        this.cb.setDebugEnabled(true)
                .setOAuthConsumerKey("VPqvA6pvxWAhuW3PO2zn8zJxw")
                .setOAuthConsumerSecret("2sVCraV1zC4BnmNDHs6IkAg5fwD4frls0bYsoSXbFJ4JDiSzDO")
                .setOAuthAccessToken("1539801186-bHMOHOJ9WVAVgjCWf3FEIhSqa6qL5YW9zKSUCtW")
                .setOAuthAccessTokenSecret("VO3qpORS2NLcR1IevZJNTbPf4vmFoSDu3263xTBnWI1ni");
        this.tf = new TwitterFactory(cb.build());
        this.twitter = tf.getInstance();
    }

    public void search() {

        try {
            this.query = new Query("Reforma da Previdência");
            this.query.setCount(100);
            this.result = this.twitter.search(query);

            ArquivoTXT arq = new ArquivoTXT();
            for (Status status : result.getTweets()) {

                String text = status.getText();
                text = text.replaceAll("\n", "").replaceAll("\r", "");
                arq.write(status.getId()+";"+text);
            }
        } catch(TwitterException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
