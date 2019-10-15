import montaArquivos.GeraArquivoHashtags;

import java.io.IOException;

public class Inicio {
    public static void main(String[] args) throws IOException {

        GeraArquivoHashtags obj = new GeraArquivoHashtags();
        obj.open();
        obj.monta();
    }
}
