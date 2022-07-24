
package model;

import java.io.IOException;
import java.util.ArrayList;
import presenter.ChatPresenter;

class SalaChatReal implements MediatorChat {
    
    private ArrayList<ChatPresenter> presenters;
    
    protected SalaChatReal() {
        presenters = new ArrayList<>();
    }

    @Override
    public void enviar(Participante participante, String mensagem) {
        for(ChatPresenter p : presenters) {
            try {
                p.receberMensagem(participante, mensagem);
            } catch (IOException ex) {
                System.err.println(ex);
            }
            p.getParticipante().receber(mensagem, participante);
        }
    }

    @Override
    public Participante criarParticipante(MediatorChat mediator, String name) {
        Participante participante = new ParticipanteChat(mediator, name);
        return participante;
    }

    public ArrayList<ChatPresenter> getPresenters() {
        return presenters;
    }
}
