package br.com.bilac.tecnojogos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

        import java.awt.BorderLayout;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import javax.swing.JButton;
        import javax.swing.JColorChooser;
        import javax.swing.JDialog;

/**
 *
 * @author Talita
 */
public class PaletaCor extends JDialog implements ActionListener {

    JColorChooser jcolor = new JColorChooser();

    JButton btOK = new JButton("OK");
    Desenho d;

    PaletaCor(Desenho des) {
        d = des;
        btOK.addActionListener(this);
        add(jcolor, BorderLayout.CENTER);
        add(btOK, BorderLayout.SOUTH);

        setSize(550, 350);
        setTitle("Paleta de cores");
        setVisible(true);

    }

    @Override

    // MEODO PARA PEGAR A COR ESCOLHIDA QUANDO CLICADO NO BT OK
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btOK) {
            d.color = jcolor.getColor();
        }
        dispose();

    }
}
