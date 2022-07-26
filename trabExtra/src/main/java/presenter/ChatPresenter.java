
package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import model.Participante;
import model.SalaChat;
import view.ChatView;

public class ChatPresenter {
    private ChatView chatView;
    private SalaChat salaChat;
    private String mensagem;
    private Participante participante;
    
    public ChatPresenter(SalaChat salaChat, Participante participante) {
        chatView = new ChatView();
        this.salaChat = salaChat;
        this.participante = participante;
        
        chatView.setTitle(participante.getName());

        chatView.getBtnEnviar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mensagem = chatView.getTxtMensagem().getText();
                if (mensagem != null) {
                    System.out.println(mensagem);
                    participante.enviar(mensagem);
                }
                chatView.getTxtMensagem().setText("");
            }
        });
        
        chatView.getBtnLimpar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatView.getTxtMensagem().setText("");
            }
        });
        
        chatView.getBtnSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatView.dispose();
                salaChat.getPresenters().remove(this);
            }
        });
        
        chatView.getAreaChat().setEditable(false);
        chatView.setVisible(true);
    }

    public Participante getParticipante() {
        return participante;
    }
    
    public void receberMensagem(Participante participante, String mensagem) throws IOException {
        chatView.getAreaChat().append(participante.getName() + " diz -> " + mensagem + "\r\n");
    }
}
