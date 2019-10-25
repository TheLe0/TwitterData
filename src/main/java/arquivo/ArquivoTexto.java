package arquivo;

import java.io.*;
import java.net.URL;

public class ArquivoTexto extends Arquivo{

    public ArquivoTexto() {

        this.nomeArquivo = "tweets.txt";
        this.open();
    }

    public void setArquivoIn(String arquivo)
    {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(arquivo);
        this.fileIn = new File(resource.getFile());
    }

    public void write(String linha) throws IOException {
        if (this.fileOut == null) return;

        try {
            this.fw = new FileWriter(this.fileOut, true);
            this.bw = new BufferedWriter(this.fw);

            this.bw.write(linha);
            this.bw.newLine();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }

    }

    public void writeLImited() throws IOException {

        if (this.fileIn == null || this.fileOut == null) return;

        try {
            this.reader = new FileReader(this.fileOut);
            this.br = new BufferedReader(this.reader);

            this.fw = new FileWriter(this.fileIn, true);
            this.bw = new BufferedWriter(this.fw);

            String line;
            String[] colunas;
            while ((line = this.br.readLine()) != null) {

                System.out.println(line);
                colunas = line.split(";");

                this.limitFields(colunas[0], DataTypes.ID_TWITTER);
                this.limitFields(colunas[1], DataTypes.NAME);
                this.limitFields(colunas[2], DataTypes.CONTENT);
                this.limitFields(colunas[3], DataTypes.DATE);
                this.limitFields(colunas[4], DataTypes.HASHTAGS);

                this.bw.write(this.idTwitter+this.name+this.tweetContent+this.sendDate+this.hashtags);
                this.bw.newLine();
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
    }
}
