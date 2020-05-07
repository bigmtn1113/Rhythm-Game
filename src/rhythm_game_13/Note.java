package rhythm_game_13;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x, y = 580 - 1000 / Main.SLEEP_TIME * Main.NOTE_SPEED;	// 1초 뒤 판정라인에 도착. -120(y) + 700(1초 뒤) = 580(판정라인)
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
			 while (true) {	// 1초면 100번 실행. 즉 노드가 1초에 700픽셀만큼 밑으로 내려감
				 drop();
				 Thread.sleep(Main.SLEEP_TIME);	// 멈추는 시간이 없으면 순식간에 지나가버림
			 }
		 } catch(Exception e) {
			 System.err.println(e.getMessage());
		 }
	}
}
