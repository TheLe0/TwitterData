package arquivo;

import java.io.*;
import java.net.URL;

public class ArquivoBinario extends Arquivo{

    public ArquivoBinario() {

        this.nomeArquivo = "tweets_bin.txt";
        this.open();
    }

    @Override
    public void open() {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("tweets.txt");
        this.fileIn = new File(resource.getFile());

        resource = classLoader.getResource(this.nomeArquivo);
        this.fileOut = new File(resource.getFile());

    }

    @Override
    public void close() throws IOException {
        this.reader.close();
        this.br.close();
        this.bw.close();
    }


    public void write() throws IOException {

        if (this.fileIn == null || this.fileOut == null) return;

        try {
            this.reader = new FileReader(this.fileIn);
            this.br = new BufferedReader(this.reader);

            this.fw = new FileWriter(this.fileOut, true);
            this.bw = new BufferedWriter(this.fw);

            String line;
            StringBuilder finalLine =  new StringBuilder();
            byte[] lineBin;
            String[] colunas;
            while ((line = this.br.readLine()) != null) {

                    colunas = line.split(";");

                    this.limitFields(colunas[0], DataTypes.ID_TWITTER);
                    this.limitFields(colunas[1], DataTypes.NAME);
                    this.limitFields(colunas[2], DataTypes.CONTENT);
                    this.limitFields(colunas[3], DataTypes.DATE);
                    this.limitFields(colunas[4], DataTypes.HASHTAGS);

                    lineBin = (line).getBytes("UTF-8");
                    for(byte i : lineBin) {
                        finalLine.append(Integer.toBinaryString(i)+" ");
                    }

                    this.bw.write(String.valueOf(finalLine));
                    this.bw.newLine();
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
    }

}
