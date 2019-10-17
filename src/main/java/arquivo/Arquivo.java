package arquivo;

import java.io.*;
import java.net.URL;

abstract class Arquivo {

    protected String nomeArquivo;
    protected FileReader reader;
    protected BufferedReader br;
    protected FileWriter fw;
    protected BufferedWriter bw;
    protected File fileIn;
    protected File fileOut;

    public void open() {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(this.nomeArquivo);
        this.fileOut = new File(resource.getFile());

    }

    public void close() throws IOException {
        this.bw.close();
    }
}
