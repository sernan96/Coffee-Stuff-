package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Main extends JFrame {
	CenterPanel centerPanel;

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("java programming report");
		Container c = getContentPane();

		centerPanel = new CenterPanel();
		c.add(centerPanel, BorderLayout.CENTER);
		c.add(new SouthPanel(), BorderLayout.SOUTH);

		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}

	class CenterPanel extends JPanel {
		JProgressBar cupBar, coffeeBar, waterBar, sugarBar, creamBar;

		public CenterPanel() {
			setLayout(new GridLayout(1, 5));

			cupBar = createProgressBar("Cup");
			coffeeBar = createProgressBar("Coffee");
			waterBar = createProgressBar("Water");
			sugarBar = createProgressBar("Sugar");
			creamBar = createProgressBar("Cream");
		}

		private JProgressBar createProgressBar(String name) {
			JProgressBar bar = new JProgressBar(JProgressBar.VERTICAL, 0, 100);
			bar.setValue(100);
			bar.setStringPainted(true);
			bar.setString(name);
			bar.setForeground(Color.LIGHT_GRAY);
			this.add(bar);
			return bar;
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
					applyChanges(new JProgressBar[] { centerPanel.coffeeBar, centerPanel.waterBar, centerPanel.cupBar },
							new int[] { 20, 10, 10 });
				}
			});

			btnSugar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					applyChanges(new JProgressBar[] { centerPanel.coffeeBar, centerPanel.waterBar, centerPanel.sugarBar,
							centerPanel.cupBar }, new int[] { 10, 10, 10, 10 });
				}
			});

			btnDabang.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					applyChanges(new JProgressBar[] { centerPanel.coffeeBar, centerPanel.waterBar, centerPanel.sugarBar,
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

		private void applyChanges(JProgressBar[] bars, int[] values) {
			for (int i = 0; i < bars.length; i++) {
				int newValue = bars[i].getValue() - values[i];
				if (newValue < 0) {
					JOptionPane.showMessageDialog(null, "재료가 부족합니다.");
					return;
				}
				bars[i].setValue(newValue);
				if (newValue <= 30) {
					bars[i].setForeground(Color.RED);
				} else {
					bars[i].setForeground(Color.LIGHT_GRAY);
				}
			}
		}

		private void resetAll() {
			JProgressBar[] bars = new JProgressBar[] { centerPanel.cupBar, centerPanel.coffeeBar, centerPanel.waterBar,
					centerPanel.sugarBar, centerPanel.creamBar };
			for (JProgressBar bar : bars) {
				bar.setValue(100);
				bar.setForeground(Color.LIGHT_GRAY);
			}
		}
	}
}
