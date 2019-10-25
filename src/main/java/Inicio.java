import arquivo.ArquivoTexto;

import java.io.IOException;

public class Inicio {
    public static void main(String[] args) throws IOException {

        ArquivoTexto obj = new ArquivoTexto();
        obj.setArquivoIn("tweets_limited.txt");
        obj.writeLImited();
    }
}
