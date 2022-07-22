/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.ParticipanteChat;
import model.SalaChat;
import view.ConectarView;

/**
 *
 * @author Usuário
 */
public class ConectarPresenter {
    private ConectarView conectarView;
    private String name;
    private SalaChat salaChat;
    
    public ConectarPresenter(){
        conectarView = new ConectarView();
        salaChat = new SalaChat();
        
        conectarView.getBtnConectar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = conectarView.getTxtConectar().getText();
                ChatPresenter chatPresenter = new ChatPresenter(salaChat, salaChat.criarParticipante(salaChat, name));
                salaChat.getPresenters().add(chatPresenter);
                //JOptionPane.showMessageDialog(null, "Participante " + name + " se conectou!");
                conectarView.getTxtConectar().setText("");
            }
        });
        
        conectarView.getBtnSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });
        
        conectarView.setVisible(true);
    }
    
    public void fechar() {
        System.exit(0);
    }
}
