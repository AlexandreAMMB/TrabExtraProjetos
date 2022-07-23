/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import chain.ProcessadorDeVerificacao;
import java.io.IOException;
import java.util.ArrayList;
import presenter.ChatPresenter;

/**
 *
 * @author Usuário
 */
public class SalaChat implements MediatorChat {
    
    private SalaChatReal real;
    private ProcessadorDeVerificacao processador;

    public SalaChat() throws IOException {
        real = new SalaChatReal();
        processador = new ProcessadorDeVerificacao();
    }

    @Override
    public void enviar(Participante participante, String mensagem) {
        mensagem = processador.processar(mensagem);
        if (mensagem.equals("N") == false) {
            real.enviar(participante, mensagem);
        }
    }

    @Override
    public Participante criarParticipante(MediatorChat mediator, String name) {
        return real.criarParticipante(mediator, name);
    }
    
    /*public boolean accept(String mensagem) {
        if (processador.processar(mensagem) != mensagem) {
            return false;
        }
        return true;
    }*/
    
    public ArrayList<ChatPresenter> getPresenters() {
        return real.getPresenters();
    }
}
