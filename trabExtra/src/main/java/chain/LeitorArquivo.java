
package chain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeitorArquivo {
    
    private ArrayList<String> palavras;
    
    public LeitorArquivo() {
        palavras = new ArrayList<>();
    }
    
    public ArrayList<String> ler(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
	while (true) {
            if (linha != null) {
                palavras.add(linha);
            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
        return palavras;
    }
}
