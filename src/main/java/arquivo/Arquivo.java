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
                if(str.length() < 19) {
                    this.idTwitter= Arquivo.paddingLeft(str, 19);
                } else {
                    str = str.substring(0, 18).trim();
                    this.idTwitter = str;
                }
                break;
            case NAME:
                if(str.length() < 26) {
                    this.name= Arquivo.paddingLeft(str, 26);
                } else {
                    str = str.substring(0, 25).trim();
                    this.name = str;
                }
                break;
            case CONTENT:
                if(str.length() < 256) {
                    this.tweetContent= Arquivo.paddingLeft(str, 256);
                } else {
                    str = str.substring(0, 255).trim();
                    this.tweetContent = str;
                }
                break;
            case DATE:
                if(str.length() < 10) {
                    this.sendDate= Arquivo.paddingLeft(str, 10);
                } else {
                    str = str.substring(0, 9).trim();
                    this.sendDate = str;
                }
                break;
            case HASHTAGS:
                if(str.length() < 11) {
                    this.hashtags= Arquivo.paddingLeft(str, 11);
                } else {
                    str = str.substring(0,10);
                    this.hashtags = str;
                }
        }
    }

    public static String paddingLeft(String toPad, int width) {

        char fill = '<';

        return new String(new char[width - toPad.length()]).replace('\0', fill) + toPad;
    }
}
