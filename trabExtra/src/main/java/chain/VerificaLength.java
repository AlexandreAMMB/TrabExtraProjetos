
package chain;

import javax.swing.JOptionPane;

public class VerificaLength implements IVerifica {

    @Override
    public boolean accept(String mensagem) {
        if (mensagem.length() > 280) {
            JOptionPane.showMessageDialog(null, "A mensagem digitada ultrapassa o limite de 280 caracteres!!!");
            return false;
        }
        return true;
    }

    @Override
    public String executa(String mensagem) {
        return "N";
    }
}
