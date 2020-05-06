package rhythm_game_11;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

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
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground.png")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);

	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;	// ���� ���� ȭ��
	private boolean isGameScreen = false;	// ���� ���� �� ���� ȭ��
	
	ArrayList<Track> trackList = new ArrayList<Track>();	// ���� ����Ʈ
	
	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;
	private Music introMusic = new Music("introMusic.mp3", true); // ���� ����, ���� ������ ���� �ݺ� = true
	private int nowSelected = 0; // ���� ����Ʈ �ε���

	public static Game game = new Game();	// ������ �ϳ��� ����Ǿ�� ��. ������Ʈ �� ���� �ϳ��� �����ؾ� ��
	
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

		addKeyListener(new KeyListener());
		
		introMusic.start();
		
		trackList.add(new Track("Animal Title Image.png", "Animal Start Image.png",
				"Game Play Image.png", "Debris & RudeLies - Animal (feat. Jex).mp3"));
		trackList.add(new Track("Rich Title Image.png", "Rich Start Image.png",
				"Game Play Image.png", "Raven & Kreyn - RICH.mp3"));
		trackList.add(new Track("Shadows Title Image.png", "Shadows Start Image.png",
				"Game Play Image.png", "3rd Prototype - Shadows.mp3"));
		
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
				enterMain();
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
				selectLeft();
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
				selectRight();
			}
		});
		add(rightButton);
		
		easyButton.setVisible(false);
		easyButton.setBounds(375, 580, 250, 70);
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) { 
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				gameStart(nowSelected, "easy");
			}
		});
		add(easyButton);
		
		hardButton.setVisible(false);
		hardButton.setBounds(655, 580, 250, 70);
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonEnteredImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) { 
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				gameStart(nowSelected, "hard");
			}
		});
		add(hardButton);
		
		backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) { 
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				backMain();
			}
		});
		add(backButton);
		
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
	}

	public void paint(Graphics g) { // ���� ���� ȭ���� ǥ�����ִ� �޼ҵ�
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D)screenGraphic);	// �۾� ���� ���ֱ�. Graphics �ڽ����ν� 2D �׷��� ȯ���� ������ ����
		g.drawImage(screenImage, 0, 0, null); // 0, 0 ��ġ�� screenImage�� �׷���.
	}

	public void screenDraw(Graphics2D g) {	// �۾� ���� ���ֱ�
		g.drawImage(background, 0, 0, null);	// �������� �̹��� �׸� �� ���.
		
		if (isMainScreen) {
			g.drawImage(selectedImage, 340, 200, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		
		if (isGameScreen) {
			game.screenDraw(g);
		}
		
		paintComponents(g); // �������� �ʴ� �������� ��ҵ� �׸� �� ���. add�� �߰��� ��ҵ� �׸� �� ���
		this.repaint(); // �ٽ� paint�� ȣ���� �� �������� ȭ���� ǥ����.
	}
	
	public void enterMain() {
		introMusic.close();
		startButton.setVisible(false);
		quitButton.setVisible(false);
		
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.png")).getImage();
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		selectTrack(0);	// ù ���� ���� â
	}
	
	public void selectTrack(int nowSelected) {
		if (selectedMusic != null)
			selectedMusic.close();
		
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getGameMusic(), true);
		selectedMusic.start();
	}
	
	public void selectLeft() {
		if (nowSelected == 0)
			nowSelected = trackList.size() - 1;	// ù ������ ��� left�ϸ� �� �������� �̵�
		else
			--nowSelected;
		
		selectTrack(nowSelected);
	}
	
	public void selectRight() {
		if (nowSelected == trackList.size() - 1)
			nowSelected = 0;	// �� ������ ��� right�ϸ� ù �������� �̵�
		else
			++nowSelected;
		
		selectTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected, String difficulty) {
		if (selectedMusic != null)
			selectedMusic.close();
		
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		
		background = new ImageIcon(Main.class.getResource("../images/Game Play Image.png")).getImage();
		isGameScreen = true;
		backButton.setVisible(true);
		setFocusable(true);	// â�� ��ȯ�Ǹ鼭 Ű���� ��Ŀ���� �� ���� �� �����Ƿ� ���� �����ӿ� ��Ŀ�� ���ֱ�
	}
	
	public void backMain() {
		backButton.setVisible(false);
		isGameScreen = false;
		
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.png")).getImage();
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		selectTrack(nowSelected);
	}
}
