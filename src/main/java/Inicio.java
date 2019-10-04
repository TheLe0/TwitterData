import java.io.IOException;

public class Inicio {
    public static void main(String[] args) {
        try {
            ArquivoTXT arq = new ArquivoTXT();
            arq.write("Hello World!");
            arq.read();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
