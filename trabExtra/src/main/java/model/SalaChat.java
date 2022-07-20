/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Usuário
 */
public class SalaChat implements MediatorChat{
    
    private ArrayList<Participante> participantes;
    
    public SalaChat(){
        
    }

    @Override
    public void enviar(Participante participante, String mensagem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Participante criarParticipante(MediatorChat mediator, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
