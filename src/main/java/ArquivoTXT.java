import java.io.*;
import java.net.URL;

public class ArquivoTXT {
    private File file;
    private FileReader reader;
    private BufferedReader br;
    private FileWriter fw;
    private BufferedWriter bw;

    public ArquivoTXT() {
        this.open();
    }

    public void open() {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("tweets.txt");
        this.file = new File(resource.getFile());


    }

    public void read() throws IOException {

        if (this.file == null) return;

        try {
            this.reader = new FileReader(this.file);
            this.br = new BufferedReader(this.reader);

            String line;
            while ((line = this.br.readLine()) != null) {
                System.out.println(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            this.reader.close();
            this.br.close();
        }
    }

    public void write(String linha) throws IOException {
        if (this.file == null) return;

        try {
            this.fw = new FileWriter(this.file, true);
            this.bw = new BufferedWriter(this.fw);

            this.bw.write(linha);
            this.bw.newLine();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            this.bw.close();
        }

    }
}
