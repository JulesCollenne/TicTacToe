import javax.swing.*;

public class Animation extends JFrame {

    Panneau pan = new Panneau();

    public Animation(){
        this.setTitle("TicTacToe");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(pan);
        this.setVisible(true);
    }
}
