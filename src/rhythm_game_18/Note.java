package rhythm_game_18;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x, y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;	// Main.REACH_TIME초 뒤 판정라인에 도착.
	private String noteType;
	private boolean proceeded = true;	// 노트 진행 여부
	
	public int getY() { return y; }
	public String getNoteType() { return noteType; }
	public boolean isProceeded() { return proceeded; }
	public void close() { proceeded = false; }
	
	public Note(String noteType) {		
		if (noteType.equals("S")) { x = 228; }
		else if (noteType.equals("D")) { x = 332; }
		else if (noteType.equals("F")) { x = 436; }
		else if (noteType.equals("Space")) { x = 540; }
		else if (noteType.equals("J")) { x = 744; }
		else if (noteType.equals("K")) { x = 848; }
		else if (noteType.equals("L")) { x = 952; }
		
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
		
		if (y > 620)	// 노트가 판정 라인을 넘어서면 
			close();
	}
	
	@Override
	public void run() {
		 try {
			 while (true) {	// 1초면 100번 실행. 즉 노드가 1초에 NOTE_SPEED * 100픽셀만큼 밑으로 내려감
				 drop();
				 
				 if (proceeded)
					 Thread.sleep(Main.SLEEP_TIME);	// 멈추는 시간이 없으면 순식간에 지나가버림
				 else {
					 interrupt();
					 break;
				 }
			 }
		 } catch(Exception e) {
			 System.err.println(e.getMessage());
		 }
	}
	
	public String judge() {
		if (y >= 613) {
			close();
			return "Late";
		}
		else if (y >= 600) {
			close();
			return "Good";
		}
		else if (y >= 587) {
			close();
			return "Great";
		}
		else if (y >= 573) {
			close();
			return "Perfect";
		}
		else if (y >= 565) {
			close();
			return "Great";
		}
		else if (y >= 550) {
			close();
			return "Good";
		}
		else if (y >= 535) {
			close();
			return "Early";
		}
		
		return "None";
	}
}
