/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.util.ArrayList;
import presenter.ChatPresenter;

/**
 *
 * @author Usuário
 */
public class SalaChat implements MediatorChat{
    
    private ArrayList<Participante> participantes;
    private ArrayList<ChatPresenter> presenters;
    
    public SalaChat(){
        participantes = new ArrayList<>();
        presenters = new ArrayList<>();
    }

    @Override
    public void enviar(Participante participante, String mensagem) {
        for(ChatPresenter p : presenters) {
            if(p.getParticipante() != participante){
                try {
                    p.receberMensagem(participante, mensagem);
                } catch (IOException ex) {
                    System.err.println(ex);
                }
                p.getParticipante().receber(mensagem, participante);
            }
        }
    }

    @Override
    public Participante criarParticipante(MediatorChat mediator, String name) {
        Participante participante = new ParticipanteChat(mediator, name);
        participantes.add(participante);
        return participante;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public ArrayList<ChatPresenter> getPresenters() {
        return presenters;
    }
}
