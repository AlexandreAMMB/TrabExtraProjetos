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
