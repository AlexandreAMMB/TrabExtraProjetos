
package model;

import chain.ProcessadorDeVerificacao;
import java.io.IOException;
import java.util.ArrayList;
import presenter.ChatPresenter;

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
    
    public ArrayList<ChatPresenter> getPresenters() {
        return real.getPresenters();
    }
}
