package twitter;

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
            this.query = new Query("valor aposentadoria");
            this.query.setCount(100);
            this.result = this.twitter.search(query);

            GeraArquivoTXT arq = new GeraArquivoTXT();
            for (Status status : result.getTweets()) {

                String dateInString = status.getCreatedAt().toString();
                String mes = dateInString.split(" ")[1].trim();
                String codMes;

                if(mes.equals("Jan")) {
                    codMes = "01";
                } else if(mes.equals("Feb")) {
                    codMes = "02";
                } else if(mes.equals("Mar")) {
                    codMes = "03";
                } else if(mes.equals("Apr")) {
                    codMes = "04";
                } else if(mes.equals("May")) {
                    codMes = "05";
                } else if(mes.equals("Jun")) {
                    codMes = "06";
                } else if(mes.equals("Jul")) {
                    codMes = "07";
                } else if(mes.equals("Aug")) {
                    codMes = "08";
                } else if(mes.equals("Sep")) {
                    codMes = "09";
                } else if(mes.equals("Oct")) {
                    codMes = "10";
                } else if(mes.equals("Nov")) {
                    codMes = "11";
                } else {
                    codMes = "12";
                }

                String dataFormatada = dateInString.split(" ")[2]+"/"+codMes+"/"+dateInString.split(" ")[5];

                String text = status.getText();
                text = text.replaceAll("\n", "").replaceAll("\r", "");
                HashtagEntity[] hashTag = status.getHashtagEntities();
                StringBuilder hashTags = new StringBuilder("(");

                if(hashTag.length > 0 ) {
                    for (int i = 0; i < hashTag.length; i++) {
                        hashTags.append(hashTag[i].getText());

                        if ( (i+1)  != hashTag.length) {
                            hashTags.append(",");
                        }
                    }
                }
                hashTags.append(")");

                arq.write(status.getId()+";"+status.getUser().getScreenName()+";"+text+";"+ dataFormatada+";"+status.getLang()+";"+hashTags);
            }
        } catch(TwitterException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
