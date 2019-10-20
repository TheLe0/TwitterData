package arquivo;

import java.io.*;
import java.net.URL;

abstract class Arquivo
{

    protected String nomeArquivo;
    protected FileReader reader;
    protected BufferedReader br;
    protected FileWriter fw;
    protected BufferedWriter bw;
    protected File fileIn;
    protected File fileOut;
    protected String idTwitter;
    protected String name;
    protected String tweetContent;
    protected String sendDate;
    protected String hashtags;

    public void open()
    {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(this.nomeArquivo);
        this.fileOut = new File(resource.getFile());

    }

    public void close() throws IOException
    {
        this.bw.close();
    }

    public void limitFields(String str, DataTypes type)
    {
        switch(type)
        {
            case ID_TWITTER:
                str = str.substring(0,18).trim();
                this.idTwitter = str;
                break;
            case NAME:
                str = str.substring(0,25).trim();
                this.name = str;
                break;
            case CONTENT:
                str = str.substring(0,255).trim();
                this.tweetContent = str;
                break;
            case DATE:
                str = str.substring(0,9).trim();
                this.sendDate = str;
                break;
            case HASHTAGS:
                str = str.substring(0,10);
                this.hashtags = str;
        }
    }
}
