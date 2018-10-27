import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Gui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(frame.getContentPane(), popupMenu);
		popupMenu.setBounds(64, 0, -48, 16);
		
		JLabel label = new JLabel("THe Man");
		label.setBounds(28, 43, 70, 15);
		frame.getContentPane().add(label);
		
		JLabel lblEarth = new JLabel("Earth");
		lblEarth.setBounds(64, 53, 70, 61);
		frame.getContentPane().add(lblEarth);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(167, 149, 148, 14);
		frame.getContentPane().add(progressBar);
		
		JSlider slider = new JSlider();
		slider.setBounds(57, 192, 200, 16);
		frame.getContentPane().add(slider);
		
		JMenu mnNewMenu = new JMenu("New menu");
		mnNewMenu.setBounds(152, 39, 95, 61);
		frame.getContentPane().add(mnNewMenu);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
