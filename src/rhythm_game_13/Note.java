package rhythm_game_13;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x, y = 580 - 1000 / Main.SLEEP_TIME * Main.NOTE_SPEED;	// 1�� �� �������ο� ����. -120(y) + 700(1�� ��) = 580(��������)
	private String noteType;
	
	public Note(int x, String noteType) {
		this.x = x;
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		if (noteType.equals("short")) {
			g.drawImage(noteBasicImage, x, y, null);
		}
		else if (noteType.equals("long")) {
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x + 100, y, null);
		}
	}
	
	public void drop() {
		y += Main.NOTE_SPEED;
	}
	
	@Override
	public void run() {
		 try {
			 while (true) {	// 1�ʸ� 100�� ����. �� ��尡 1�ʿ� 700�ȼ���ŭ ������ ������
				 drop();
				 Thread.sleep(Main.SLEEP_TIME);	// ���ߴ� �ð��� ������ ���İ��� ����������
			 }
		 } catch(Exception e) {
			 System.err.println(e.getMessage());
		 }
	}
}
