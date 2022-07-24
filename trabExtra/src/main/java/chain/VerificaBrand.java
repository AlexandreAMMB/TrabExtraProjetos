
package chain;

import java.io.IOException;
import java.util.ArrayList;

public class VerificaBrand implements IVerifica {
    
    private ArrayList<String> palavras;
    private LeitorArquivo leitor;
    
    public VerificaBrand() throws IOException {
        leitor = new LeitorArquivo();
        palavras = leitor.ler("brandList.txt");
    }

    @Override
    public boolean accept(String mensagem) {
        for(String palavra : palavras) {
            if(mensagem.contains(palavra)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String executa(String mensagem) {
        String substituto = "";
        for(String palavra : palavras) {
            if(mensagem.contains(palavra)) {
                for (int i = 0; i < palavra.length(); i++) {
                    substituto = substituto.concat("*");
                }
                mensagem = mensagem.replaceAll(palavra, substituto);
            }
        }
        return mensagem;
    }
    
}
