
package model;

public interface MediatorChat {
    public void enviar(Participante participante, String mensagem);
    public Participante criarParticipante(MediatorChat mediator, String name);
}
