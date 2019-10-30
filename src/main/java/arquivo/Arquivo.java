package arquivo;

import java.io.*;
import java.net.URL;

public class Arquivo {
    private File file;
    private FileWriter fw;
    private BufferedWriter bw;

    public Arquivo() {
        this.open();
    }

    public void open() {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("tweets.txt");
        this.file = new File(resource.getFile());


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
