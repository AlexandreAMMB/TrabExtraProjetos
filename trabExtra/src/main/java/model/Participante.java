
package model;

public abstract class Participante {
    
    protected MediatorChat mediator;
    
    public abstract String getName();
    public abstract void enviar(String mensagem);
    public abstract void receber(String mensagem, Participante participante);
}
