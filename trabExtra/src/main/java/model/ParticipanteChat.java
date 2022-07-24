
package model;

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
    }
    
    @Override
    public void receber(String mensagem, Participante participante) {
        
    }
}
