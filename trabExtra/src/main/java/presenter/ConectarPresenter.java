
package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import model.SalaChat;
import view.ConectarView;

public class ConectarPresenter {
    private ConectarView conectarView;
    private String name;
    private SalaChat salaChat;
    
    public ConectarPresenter() throws IOException{
        conectarView = new ConectarView();
        salaChat = new SalaChat();
        
        conectarView.getBtnConectar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = conectarView.getTxtConectar().getText();
                ChatPresenter chatPresenter = new ChatPresenter(salaChat, salaChat.criarParticipante(salaChat, name));
                salaChat.getPresenters().add(chatPresenter);
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
