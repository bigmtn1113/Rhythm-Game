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
		setUndecorated(true); // 기본적으로 존재하는 메뉴바를 보이지 않게 함.
		setTitle("Rhythm Game"); // 창 제목 설정
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 창 사이즈 조절
		setResizable(false); // 창 사이즈 조절 불가
		setLocationRelativeTo(null); // 창을 화면 정중앙에 위치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 프로그램도 종료. 이를 안 하면 창을 닫아도 프로그램은 돌아감.
		setVisible(true); // 창을 화면에 출력
		setBackground(new Color(0, 0, 0, 0)); // 배경을 하얀색으로 지정
		setLayout(null); // 배치관리자를 null로 설정. 직접 배치하겠다는 뜻.

		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false); // 버튼 테두리 제거
		exitButton.setContentAreaFilled(false); // 버튼 영역 배경 표시 제거
		exitButton.setFocusPainted(false); // 버튼 선택(focus) 시 생기는 테두리 표시 안함.
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {	// 마우스를 버튼 위에 올렸을 시
				exitButton.setIcon(exitButtonEnteredImage);	// 이미지 변경
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	// 손 모양으로 변경
				
			}
			@Override
			public void mouseExited(MouseEvent e) {	// 마우스가 버튼 위에서 나왔을 시
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	// 기본 모양으로 변경
			}
			@Override
			public void mousePressed(MouseEvent e) {	// 창 닫는 효과음 재생 
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);	// 해당 음악을 한 번만 실행
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);	// 1초 동안 멈추기
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
		menuBar.setBounds(0, 0, 1280, 30); // menuBar 위치(x, y, width, height) 지정
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	// 마우스 클릭 시 클릭한 좌표 파악하기
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {	// 마우스 드래그 시 드래그한 좌표 파악하기
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);	// 드래그 한 곳에 창을 표시
			}
		});
		add(menuBar);

		Music introMusic = new Music("introMusic.mp3", true); // 곡 이름, 종료 전까지 무한 반복 = true
		introMusic.start();
	}

	public void paint(Graphics g) { // 가장 먼저 화면을 표시해주는 메소드
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null); // 0, 0 위치에 screenImage가 그려짐.
	}

	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		paintComponents(g); // 움직이지 않는 고정적인 요소들 그릴때 사용
		this.repaint(); // 다시 paint를 호출해 매 순간마다 화면을 표시함.
	}
}
