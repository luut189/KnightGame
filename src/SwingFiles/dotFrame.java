package SwingFiles;

import javax.swing.JFrame;

public class dotFrame extends JFrame {
    dotPanel panel;
    
    dotFrame() {
        panel = new dotPanel();
        
        this.setTitle("Knight Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
