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
		setTitle("Rhythm Game");	// â ���� ����
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);	 // â ������ ����
		setResizable(false);	// â ������ ���� �Ұ�
		setLocationRelativeTo(null);	// â�� ȭ�� ���߾ӿ� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// â�� ������ ���α׷��� ����. �̸� �� �ϸ� â�� �ݾƵ� ���α׷��� ���ư�.
		setVisible(true);	// â�� ȭ�鿡 ���
		
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();	// �̹��� �ʱ�ȭ
	}
	
	public void paint(Graphics g) {	// ���� ���� ȭ���� ǥ�����ִ� �޼ҵ�
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);	// 0, 0 ��ġ�� screenImage�� �׷���.
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		this.repaint();	// �ٽ� paint�� ȣ���� �� �������� ȭ���� ǥ����.
	}
}
