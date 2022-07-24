
package chain;

import javax.swing.JOptionPane;

public class VerificaHTML implements IVerifica {

    @Override
    public boolean accept(String mensagem) {
        boolean accepted = true;
        if (mensagem.contains("<img") == true) {
            accepted = false;
        } else {
            if (mensagem.contains("<table") == true) {
                accepted = false;
            }  else {
                if (mensagem.contains("<p") == true) {
                    accepted = false;
                } else {
                    if (mensagem.contains("<a href") == true) {
                        accepted = false;
                    }
                }
            }
        }
        if (accepted == false) {
            JOptionPane.showMessageDialog(null, "Mensagem removida por conter conteúdo não autorizado");
        }
        
        return accepted;
    }

    @Override
    public String executa(String mensagem) {
        return "N";
    }
}
