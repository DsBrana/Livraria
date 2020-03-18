package data;

/**
 *
 * @author Júlio Oliveira
 */

import views.principal;
import java.awt.Dimension;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class inicial extends JWindow {
    AbsoluteLayout abs;
    AbsoluteConstraints absImage, absBarra;
    ImageIcon img;
    JLabel inicial;
    JProgressBar barra;
    
    principal telaA;
    
    public inicial() throws ParseException {
        abs = new AbsoluteLayout();
        absImage = new AbsoluteConstraints (0,0);
        absBarra = new AbsoluteConstraints (200,376);
        
        inicial = new JLabel();
        img = new ImageIcon (this.getClass().getResource("../imagens/livraria.jpg"));
        inicial.setIcon(img);
        
        barra = new JProgressBar();
        barra.setPreferredSize(new Dimension(234, 05));
        this.getContentPane().setLayout(abs);
        this.getContentPane().add(inicial, absImage);
        this.getContentPane().add(barra, absBarra);
        
        new Thread() {
            public void run() {
                int i = 0;
                
                while (i<101) {
                    barra.setValue(i);
                    i++;
                    
                    try {
                        sleep(20);
                    } catch (InterruptedException bar) {
                        JOptionPane.showMessageDialog (null, "Erro ao executar o programa! Erro: " + bar );
                    }
                }
                dispose();
                try {
                         telaA = new principal();
                } catch (ParseException bar2) {
                    JOptionPane.showMessageDialog (null, "Erro ao abrir a tela Principal! Erro: " + bar2);
                }            
               telaA. setVisible(true);
               telaA.setLocationRelativeTo(null);
            }
        }.start();
            this.pack();
            this.setVisible(true);
            this.setLocationRelativeTo(null);
    }
    
    public static void main (String args[]) throws ParseException {
        new inicial();
        principal main = new principal();
    }
}
