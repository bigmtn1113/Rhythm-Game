package rhythm_game_1;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class RhythmGame extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground;
	
	public RhythmGame() {
		setTitle("Rhythm Game");	// 창 제목 설정
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);	 // 창 사이즈 조절
		setResizable(false);	// 창 사이즈 조절 불가
		setLocationRelativeTo(null);	// 창을 화면 정중앙에 위치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 창을 닫으면 프로그램도 종료. 이를 안 하면 창을 닫아도 프로그램은 돌아감.
		setVisible(true);	// 창을 화면에 출력
		
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();	// 이미지 초기화
	}
	
	public void paint(Graphics g) {	// 가장 먼저 화면을 표시해주는 메소드
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);	// 0, 0 위치에 screenImage가 그려짐.
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		this.repaint();	// 다시 paint를 호출해 매 순간마다 화면을 표시함.
	}
}
