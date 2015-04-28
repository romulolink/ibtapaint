package br.com.bilac.tecnojogos;


        import java.awt.BorderLayout;
        import java.awt.Color;
        import java.awt.Graphics2D;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.MouseAdapter;
        import java.awt.event.MouseEvent;
        import java.awt.image.BufferedImage;
        import java.io.File;
        import java.io.IOException;
        import java.nio.file.Path;
        import java.util.logging.Level;
        import java.util.logging.Logger;

        import javax.imageio.ImageIO;
        import javax.swing.*;

public class Gui extends JFrame {
    private BufferedImage imagem;
    Desenho objDesenho = new Desenho();

    public Gui() {

        super("Menu Paint");
        int largura = 650;
        int altura = 600;
        setSize(largura, altura);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        initComponets();
    }

    public void initComponets() {

        //ADICIONANDO COMPONENTES AO PAINEL
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(barra, BorderLayout.NORTH);
        getContentPane().add(panel);

        //COLORIR O CLIQUE
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                objDesenho.lerCoordenadas(e);
                objDesenho.pintar(e, size.getValue());
            }

        });
        //COLORIR O AARASTAR DO MOUSE
        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                objDesenho.pintar(e, size.getValue());

            }

        });
        //ACAO ESCOLHER COR
        cor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PaletaCor(objDesenho);
            }

        });


        //ACAO DO BOTAO LIMPAR PAINEL TODO
        limpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.repaint();
            }
        });
        //ACAO DE SALVAR
        salvar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ev) {
                BufferedImage image = new BufferedImage(650, 600, BufferedImage.TYPE_INT_RGB);
                JFileChooser jFile = new JFileChooser();
                jFile.showSaveDialog(null);
                Path pth = jFile.getSelectedFile().toPath();
                JOptionPane.showMessageDialog(null, "Imagem salva com sucesso!");
                try {

                    Graphics2D g = image.createGraphics();
                    //g.drawImage(image, 0, 0, null);
                    paint(g);
                    ImageIO.write(image, "png", new File(pth.toString() + ".png"));

                } catch (IOException ox) {

                    ox.printStackTrace();

                }
            }

        });

        abrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });

        //DEFINICAO DA COR DE FUNDO DO PAINEL
        panel.setBackground(Color.WHITE);

        //SET O TAMANHO QUE O PINCEL IRA INICIALIZAR
        size.setMaximum(15);

        //ADICIONANDO BOTOES A BARRA
        barra.add(menu);
        barra.add(size);
        menu.add(cor);
        //menu.add(borracha);
        menu.add(limpar);
        menu.add(salvar);
        menu.add(abrir);

    }
    // DEFINICAO DOS BOTOES
    JMenuBar barra = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    JMenuItem cor = new JMenuItem("Mudar Cor");
    JMenuItem limpar = new JMenuItem("Limapr painel");
    JMenuItem salvar = new JMenuItem("Salvar");
    // JMenuItem borracha = new JMenuItem("Borracha");
    JMenuItem abrir = new JMenuItem("Abrir Arquivo");
    JSlider size = new JSlider();
    JPanel panel = new JPanel();
}
