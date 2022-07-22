/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuário
 */
public class ParticipanteChat extends Participante{
    
    private String name;
    
    public ParticipanteChat(MediatorChat mediatorChat, String participanteName){
        this.name = participanteName;
        mediator = mediatorChat;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void enviar(String mensagem) {
        mediator.enviar(this, mensagem);
        //JOptionPane.showMessageDialog(null, name + ", sua mensagem foi enviada!");
    }
    
    @Override
    public void receber(String mensagem, Participante participante) {
        //JOptionPane.showMessageDialog(null, name + " enviou uma mensagem!");
    }
}
