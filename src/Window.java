import javax.swing.*;
import java.lang.ref.PhantomReference;


public class Window  extends JFrame {
    public final int WIDTH=600;
    public final int HEIGHT=450;
    private BMIcalculate bmIcalculate;
    public Window(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.bmIcalculate=new BMIcalculate();
        this.add(bmIcalculate);
        this.setVisible(true);

    }

}
