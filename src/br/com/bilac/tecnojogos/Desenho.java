package br.com.bilac.tecnojogos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

        import java.awt.BasicStroke;
        import java.awt.Color;
        import java.awt.Graphics2D;
        import java.awt.event.MouseEvent;
        import javax.swing.JPanel;

public class Desenho {

    int X;
    int Y;

    //COR DE DEFAULT DO PINCEL, PRETO
    Color color = new Color(0, 0, 0);

    public Desenho() {

    }


    // METODO PARA PEGAR O X E Y
    public void lerCoordenadas(MouseEvent ev) {
        if (!ev.isMetaDown()) {

            X = ev.getX();
            Y = ev.getY();
        }
    }

    // METODO PARA PINTAR NO CLIQUE DO MOUSE
    public void pintar(MouseEvent ev, int size) {

        if (!ev.isMetaDown()) {
            //CRIAR OBJETO NO GRAPHICS
            Graphics2D g2d = (Graphics2D) ((JPanel) ev.getSource()).getGraphics();
            g2d.setStroke(new BasicStroke(size));
            g2d.setColor(color);

            //PONTO FINAL DA LINHA
            int x = ev.getX();
            int y = ev.getY();
            g2d.drawLine(X, Y, x, y);
            g2d.dispose();

            X = x;
            Y = y;
        } else {
        }
    }

}
