package rhythm_game_4;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RhythmGame extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	
	private Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.jpg")));
	private JButton exitButton = new JButton(exitButtonBasicImage);

	private int mouseX, mouseY;

	public RhythmGame() {
		setUndecorated(true); // �⺻������ �����ϴ� �޴��ٸ� ������ �ʰ� ��.
		setTitle("Rhythm Game"); // â ���� ����
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // â ������ ����
		setResizable(false); // â ������ ���� �Ұ�
		setLocationRelativeTo(null); // â�� ȭ�� ���߾ӿ� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // â�� ������ ���α׷��� ����. �̸� �� �ϸ� â�� �ݾƵ� ���α׷��� ���ư�.
		setVisible(true); // â�� ȭ�鿡 ���
		setBackground(new Color(0, 0, 0, 0)); // ����� �Ͼ������ ����
		setLayout(null); // ��ġ�����ڸ� null�� ����. ���� ��ġ�ϰڴٴ� ��.

		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false); // ��ư �׵θ� ����
		exitButton.setContentAreaFilled(false); // ��ư ���� ��� ǥ�� ����
		exitButton.setFocusPainted(false); // ��ư ����(focus) �� ����� �׵θ� ǥ�� ����.
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {	// ���콺�� ��ư ���� �÷��� ��
				exitButton.setIcon(exitButtonEnteredImage);	// �̹��� ����
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	// �� ������� ����
				
			}
			@Override
			public void mouseExited(MouseEvent e) {	// ���콺�� ��ư ������ ������ ��
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	// �⺻ ������� ����
			}
			@Override
			public void mousePressed(MouseEvent e) {	// â �ݴ� ȿ���� ��� 
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);	// �ش� ������ �� ���� ����
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);	// 1�� ���� ���߱�
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
		menuBar.setBounds(0, 0, 1280, 30); // menuBar ��ġ(x, y, width, height) ����
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	// ���콺 Ŭ�� �� Ŭ���� ��ǥ �ľ��ϱ�
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {	// ���콺 �巡�� �� �巡���� ��ǥ �ľ��ϱ�
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);	// �巡�� �� ���� â�� ǥ��
			}
		});
		add(menuBar);

		Music introMusic = new Music("introMusic.mp3", true); // �� �̸�, ���� ������ ���� �ݺ� = true
		introMusic.start();
	}

	public void paint(Graphics g) { // ���� ���� ȭ���� ǥ�����ִ� �޼ҵ�
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null); // 0, 0 ��ġ�� screenImage�� �׷���.
	}

	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		paintComponents(g); // �������� �ʴ� �������� ��ҵ� �׸��� ���
		this.repaint(); // �ٽ� paint�� ȣ���� �� �������� ȭ���� ǥ����.
	}
}
