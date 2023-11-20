package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class Main extends JFrame {
	CenterPanel centerPanel;

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("java programming report");

		Container c = getContentPane();

		centerPanel = new CenterPanel();
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(centerPanel, BorderLayout.CENTER);
		c.add(new SouthPanel(), BorderLayout.SOUTH);

		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}

	class NorthPanel extends JPanel {
		public NorthPanel() {
			setBackground(Color.GREEN);
			setOpaque(true);
			setLayout(new FlowLayout(FlowLayout.CENTER));
			add(new JLabel("반갑습니다. YU커피입니다."));
		}
	}

	class CenterPanel extends JPanel {
		JPanel cupBar, coffeeBar, waterBar, sugarBar, creamBar;
		JLabel coffeeImageLabel;

		public CenterPanel() {
			setLayout(new BorderLayout());
			JPanel progressBarPanel = new JPanel();
			progressBarPanel.setLayout(new GridLayout(1, 5));

			cupBar = createProgressBar("Cup");
			coffeeBar = createProgressBar("Coffee");
			waterBar = createProgressBar("Water");
			sugarBar = createProgressBar("Sugar");
			creamBar = createProgressBar("Cream");
			progressBarPanel.add(Box.createRigidArea(new Dimension(20, 20)));
			progressBarPanel.add(cupBar);
			progressBarPanel.add(Box.createRigidArea(new Dimension(20, 20)));
			progressBarPanel.add(coffeeBar);
			progressBarPanel.add(Box.createRigidArea(new Dimension(20, 20)));
			progressBarPanel.add(waterBar);
			progressBarPanel.add(Box.createRigidArea(new Dimension(20, 20)));
			progressBarPanel.add(sugarBar);
			progressBarPanel.add(Box.createRigidArea(new Dimension(20, 20)));
			progressBarPanel.add(creamBar);
			progressBarPanel.add(Box.createRigidArea(new Dimension(20, 20)));

			this.add(progressBarPanel, BorderLayout.NORTH);

			coffeeImageLabel = new JLabel();
			coffeeImageLabel.setHorizontalAlignment(JLabel.CENTER);
			coffeeImageLabel.setIcon(new ImageIcon("coffee.jpg"));
			this.add(coffeeImageLabel, BorderLayout.CENTER);
		}

		private JPanel createProgressBar(String name) {
			JPanel barPanel = new JPanel(new BorderLayout());
			JProgressBar bar = new JProgressBar(JProgressBar.VERTICAL, 0, 100);
			bar.setValue(100);
			bar.setStringPainted(false);
			bar.setForeground(Color.LIGHT_GRAY);

			JLabel barLabel = new JLabel(name, SwingConstants.CENTER);
			barPanel.add(bar, BorderLayout.CENTER);
			barPanel.add(barLabel, BorderLayout.SOUTH);

			return barPanel;
		}
	}

	class SouthPanel extends JPanel {
		JButton btnCoffee, btnSugar, btnDabang, btnReset;

		public SouthPanel() {
			btnCoffee = createButton("Black Coffee");
			btnSugar = createButton("Sugar Coffee");
			btnDabang = createButton("Dabang Coffee");
			btnReset = createButton("Reset");

			btnCoffee.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					applyChanges(new JPanel[] { centerPanel.coffeeBar, centerPanel.waterBar, centerPanel.cupBar },
							new int[] { 20, 10, 10 });
				}
			});

			btnSugar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					applyChanges(new JPanel[] { centerPanel.coffeeBar, centerPanel.waterBar, centerPanel.sugarBar,
							centerPanel.cupBar }, new int[] { 10, 10, 10, 10 });
				}
			});

			btnDabang.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					applyChanges(new JPanel[] { centerPanel.coffeeBar, centerPanel.waterBar, centerPanel.sugarBar,
							centerPanel.creamBar, centerPanel.cupBar }, new int[] { 10, 10, 10, 10, 10 });
				}
			});

			btnReset.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					resetAll();
				}
			});
		}

		private JButton createButton(String name) {
			JButton button = new JButton(name);
			this.add(button);
			return button;
		}

		private void applyChanges(JPanel[] bars, int[] values) {
			for (int i = 0; i < bars.length; i++) {
				JProgressBar bar = (JProgressBar) bars[i].getComponent(0);
				int newValue = bar.getValue() - values[i];
				if (newValue < 0) {
					JOptionPane.showMessageDialog(null, "재료가 부족합니다.");
					return;
				}
				bar.setValue(newValue);
				if (newValue <= 30) {
					bar.setForeground(Color.RED);
				} else {
					bar.setForeground(Color.LIGHT_GRAY);
				}
			}
		}

		private void resetAll() {
			JPanel[] bars = new JPanel[] { centerPanel.cupBar, centerPanel.coffeeBar, centerPanel.waterBar,
					centerPanel.sugarBar, centerPanel.creamBar };
			for (JPanel barPanel : bars) {
				JProgressBar bar = (JProgressBar) barPanel.getComponent(0);
				bar.setValue(100);
				bar.setForeground(Color.LIGHT_GRAY);

			}

			JOptionPane.showMessageDialog(null, "재료 충전완료~");
		}
	}
}
