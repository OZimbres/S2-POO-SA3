import javax.swing.JFrame;

public class FrameApp extends JFrame {
    public FrameApp() {
        super("S2-POO-SA3");
        this.add(new TabbedApp());

        //Setando janela
        this.setBounds(500, 250, 500, 500);
        this.setDefaultCloseOperation(2);
        this.setVisible(true);
    }
}
