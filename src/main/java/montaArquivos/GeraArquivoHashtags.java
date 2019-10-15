package montaArquivos;

import java.io.*;
import java.net.URL;

public class GeraArquivoHashtags {

    private String nomeArquivo;
    private FileReader reader;
    private BufferedReader br;
    private FileWriter fw;
    private BufferedWriter bw;
    private File fileIn;
    private File fileOut;

    public GeraArquivoHashtags() {

        this.nomeArquivo = "hashtags.txt";
    }

    public void open() {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("tweets.txt");
        this.fileIn = new File(resource.getFile());

        resource = classLoader.getResource(this.nomeArquivo);
        this.fileOut = new File(resource.getFile());

    }

    public void monta() throws IOException {

        if (this.fileIn == null || this.fileOut == null) return;

        try {
            this.reader = new FileReader(this.fileIn);
            this.br = new BufferedReader(this.reader);

            this.fw = new FileWriter(this.fileOut, true);
            this.bw = new BufferedWriter(this.fw);

            String line;
            while ((line = this.br.readLine()) != null) {
                    this.bw.write(line);
                    this.bw.newLine();
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            this.reader.close();
            this.br.close();
            this.bw.close();
        }
    }

}
