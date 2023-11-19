package Main;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    public Main(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("java programming report");
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
            setLayout(new BorderLayout());

            JPanel gaugePanel = new JPanel();
            gaugePanel.setLayout(new GridLayout(1,5));  // GridLayout으로 게이지 패널들을 수평 배치
            gaugePanel.add(Box.createRigidArea(new Dimension(20, 20)));
            // 게이지 패널들 추가
            //cupPanel
            JPanel cupPanel = new JPanel(new BorderLayout());
            JProgressBar cupBar = new JProgressBar(JProgressBar.VERTICAL, 0,100);
            cupBar.setValue(100);
            cupPanel.add(cupBar, BorderLayout.NORTH);
            JLabel cupLabel = new JLabel("Cup", SwingConstants.CENTER);
            cupPanel.add(cupLabel, BorderLayout.SOUTH);
            gaugePanel.add(cupPanel);

            gaugePanel.add(Box.createRigidArea(new Dimension(20, 20)));
            //coffeePanel 추가
            JPanel coffeePanel = new JPanel(new BorderLayout());
            JProgressBar coffeeBar = new JProgressBar(JProgressBar.VERTICAL, 0,100);
            coffeeBar.setValue(100);
            coffeePanel.add(coffeeBar, BorderLayout.NORTH);
            JLabel coffeeLabel = new JLabel("Coffee", SwingConstants.CENTER);
            coffeePanel.add(coffeeLabel, BorderLayout.SOUTH);
            gaugePanel.add(coffeePanel);

            gaugePanel.add(Box.createRigidArea(new Dimension(20, 20)));
            //waterPanel 추가
            JPanel waterPanel = new JPanel(new BorderLayout());
            JProgressBar waterBar = new JProgressBar(JProgressBar.VERTICAL, 0,100);
            waterBar.setValue(100);
            waterPanel.add(waterBar, BorderLayout.NORTH);
            JLabel waterLabel = new JLabel("Water", SwingConstants.CENTER);
            waterPanel.add(waterLabel, BorderLayout.SOUTH);
            gaugePanel.add(waterPanel);
            
            gaugePanel.add(Box.createRigidArea(new Dimension(20, 20)));
            //sugarPanel 추가
            JPanel sugarPanel = new JPanel(new BorderLayout());
            JProgressBar sugarBar = new JProgressBar(JProgressBar.VERTICAL, 0,100);
            sugarBar.setValue(100);
            sugarPanel.add(sugarBar, BorderLayout.NORTH);
            JLabel sugarLabel = new JLabel("Sugar", SwingConstants.CENTER);
            sugarPanel.add(sugarLabel, BorderLayout.SOUTH);
            gaugePanel.add(sugarPanel);
            
            gaugePanel.add(Box.createRigidArea(new Dimension(20, 20)));
            //creamPanel추가
            JPanel creamPanel = new JPanel(new BorderLayout());
            JProgressBar creamBar = new JProgressBar(JProgressBar.VERTICAL, 0,100);
            creamBar.setValue(100);
            creamPanel.add(creamBar, BorderLayout.NORTH);
            JLabel creamLabel = new JLabel("Cream", SwingConstants.CENTER);
            creamPanel.add(creamLabel, BorderLayout.SOUTH);
            gaugePanel.add(creamPanel);
            
            gaugePanel.add(Box.createRigidArea(new Dimension(20, 20)));
            add(gaugePanel, BorderLayout.NORTH);  // 게이지 패널들을 North 영역에 추가

            // 이미지 추가
            ImageIcon coffeeImage = new ImageIcon("coffee.jpg");
            JLabel imageLabel = new JLabel(coffeeImage);
            imageLabel.setHorizontalAlignment(JLabel.CENTER);  // 이미지를 가운데 정렬
            add(imageLabel, BorderLayout.CENTER);  // 이미지를 Center 영역에 추가
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
