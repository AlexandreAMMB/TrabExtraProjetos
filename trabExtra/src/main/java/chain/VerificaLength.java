/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chain;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuário
 */
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
