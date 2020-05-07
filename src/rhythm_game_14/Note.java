package rhythm_game_14;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x, y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;	// 1초 뒤 판정라인에 도착.
	private String noteType;
	
	public Note(String noteType) {		
		if (noteType.equals("S")) {
			x = 228;
		}
		else if (noteType.equals("D")) {
			x = 332;
		}
		else if (noteType.equals("F")) {
			x = 436;
		}
		else if (noteType.equals("Space")) {
			x = 540;
		}
		else if (noteType.equals("J")) {
			x = 744;
		}
		else if (noteType.equals("K")) {
			x = 848;
		}
		else if (noteType.equals("L")) {
			x = 952;
		}
		
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		if (!noteType.equals("Space")) {
			g.drawImage(noteBasicImage, x, y, null);
		}
		else {
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
			 while (true) {	// 1초면 100번 실행. 즉 노드가 1초에 NOTE_SPEED * 100픽셀만큼 밑으로 내려감
				 drop();
				 Thread.sleep(Main.SLEEP_TIME);	// 멈추는 시간이 없으면 순식간에 지나가버림
			 }
		 } catch(Exception e) {
			 System.err.println(e.getMessage());
		 }
	}
}
