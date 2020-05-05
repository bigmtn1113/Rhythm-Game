package rhythm_game_6;

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
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	
	private Image titleImage = new ImageIcon(Main.class.getResource("../images/Animal Title Image.png")).getImage();
	private Image selectedImage = new ImageIcon(Main.class.getResource("../images/Animal Game Image.png")).getImage();
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground.png")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);

	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;	// �� ���� ȭ��

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
			public void mousePressed(MouseEvent e) {	// ���콺 Ŭ�� ȿ���� ��� 
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
		
		startButton.setBounds(1000, 100, 145, 150);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) { 
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				startButton.setVisible(false);
				quitButton.setVisible(false);
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.png")).getImage();	// �̹��� ��ü
				isMainScreen = true;
			}
		});
		add(startButton);
		
		quitButton.setBounds(1000, 300, 145, 150);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) { 
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);
		
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) { 
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				// ���� ��ư �̺�Ʈ
			}
		});
		add(leftButton);
		
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) { 
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				// ������ ��ư �̺�Ʈ
			}
		});
		add(rightButton);
		
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
		g.drawImage(background, 0, 0, null);	// �������� �̹��� �׸� �� ���.
		if (isMainScreen) {
			g.drawImage(selectedImage, 340, 200, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		paintComponents(g); // �������� �ʴ� �������� ��ҵ� �׸� �� ���. add�� �߰��� ��ҵ� �׸� �� ���
		this.repaint(); // �ٽ� paint�� ȣ���� �� �������� ȭ���� ǥ����.
	}
}
