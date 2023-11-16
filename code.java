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

            // 게이지 패널들 추가
            gaugePanel.add(Box.createRigidArea(new Dimension(20, 20)));
            gaugePanel.add(createGuagePanel(" Cup "));
            gaugePanel.add(Box.createRigidArea(new Dimension(20, 20)));

            gaugePanel.add(createGuagePanel("Coffee"));
            gaugePanel.add(Box.createRigidArea(new Dimension(20, 20)));
            gaugePanel.add(createGuagePanel("Water"));
            gaugePanel.add(Box.createRigidArea(new Dimension(20, 20)));
            gaugePanel.add(createGuagePanel("Sugar"));
            gaugePanel.add(Box.createRigidArea(new Dimension(20, 20)));
            gaugePanel.add(createGuagePanel("Cream"));
            gaugePanel.add(Box.createRigidArea(new Dimension(20, 20)));

            add(gaugePanel, BorderLayout.NORTH);  // 게이지 패널들을 North 영역에 추가

            // 이미지 추가
            ImageIcon coffeeImage = new ImageIcon("coffee.jpg");
            JLabel imageLabel = new JLabel(coffeeImage);
            imageLabel.setHorizontalAlignment(JLabel.CENTER);  // 이미지를 가운데 정렬
            add(imageLabel, BorderLayout.CENTER);  // 이미지를 Center 영역에 추가
        }
        private JPanel createGuagePanel(String name){
            JPanel guagePanel = new JPanel();
            guagePanel.setLayout(new BorderLayout());

            JLabel nameLabel = new JLabel(name, SwingConstants.CENTER);
            JProgressBar progressBar = new JProgressBar(JProgressBar.VERTICAL, 0,100);
            progressBar.setValue(100);

            guagePanel.add(progressBar, BorderLayout.CENTER);  // 게이지를 CENTER에 추가
            guagePanel.add(nameLabel, BorderLayout.SOUTH);  // 요소 이름을 SOUTH에 추가
            return guagePanel;
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
