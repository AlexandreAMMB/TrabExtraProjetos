/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chain;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Usuário
 */
public class ProcessadorDeVerificacao {
    private ArrayList<IVerifica> verificadores;
    
    public ProcessadorDeVerificacao() throws IOException {
        verificadores = new ArrayList<>();
        verificadores.add(new VerificaLength());
        verificadores.add(new VerificaBrand());
        verificadores.add(new VerificaHTML());
    }
    
    public String processar(String mensagem) {
        for(IVerifica verificador : verificadores) {
            if (verificador.accept(mensagem) != true) {
                return verificador.executa(mensagem);
            }
        }
        return mensagem;
    }
}
