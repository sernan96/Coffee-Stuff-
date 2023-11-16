import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
    public Main(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.add(new NorthPanel(), BorderLayout.NORTH);
        c.add(new CenterPanel(), BorderLayout.CENTER);
        c.add(new SouthPanel(), BorderLayout.SOUTH);
        setSize(500, 500);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }
    class NorthPanel extends JPanel{
        public NorthPanel(){
            setBackground(Color.GREEN);
            setOpaque(true);
            setLayout(new FlowLayout(FlowLayout.CENTER));
            add(new JLabel("반갑습니다. YU커피입니다."));
        }
    }
    class CenterPanel extends JPanel{
        public CenterPanel(){
            setBackground(Color.LIGHT_GRAY);
            setLayout(null);
            setLayout(new FlowLayout(FlowLayout.LEFT));
        }
    }
    class SouthPanel extends JPanel{
        public SouthPanel() {
            setBackground(Color.LIGHT_GRAY);
            setOpaque(true);
            setLayout(new FlowLayout(FlowLayout.CENTER));
            add(new JButton("Black Coffee"));
            add(new JButton("Sugar Coffee"));
            add(new JButton("Dabang Coffee"));
            add(new JButton("Reset"));
        }
    }

}
