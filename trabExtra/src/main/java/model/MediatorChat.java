/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import presenter.ChatPresenter;

/**
 *
 * @author Usuário
 */
public interface MediatorChat {
    public void enviar(Participante participante, String mensagem);
    public Participante criarParticipante(MediatorChat mediator, String name);
}
