package rhythm_game_17;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread{
	
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	
	private Image blueFlareImage;
	private Image judgeImage;
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	private Integer gameScore = 0;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		for (int i = 0; i < noteList.size(); ++i) {
			Note note = noteList.get(i);
			
			if (note.getY() > 620) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
			}
			if (!note.isProceeded()) {
				noteList.remove(i);
				--i;
			}
			else
				note.screenDraw(g);
		}
		
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);	// �۾� ���� ���ֱ�. ����ȣ ����(���� �ػ� ��ȣ�� ���� �ػ󵵿��� ��Ÿ�� �� ����� ����) �ּ�ȭ
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 30));	// �۾�ü, ����, ũ��
		g.drawString(titleName, 20, 702);	// ���� ����
		g.drawString(difficulty, 1190, 702);	// ���� ���̵�
		
		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font("Arial", Font.PLAIN, 30));	// PLAIN = ����
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 570, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString(gameScore.toString(), 620, 702);	// ����
		g.drawImage(blueFlareImage, 390, 440, null);
		g.drawImage(judgeImage, 460, 420, null);
	}
	
	public void pressS() {
		System.out.println(gameMusic.getTime() + " S");	// beat ������ ���� ���� ���.
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}
	public void pressD() {
		System.out.println(gameMusic.getTime() + " D");
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}
	public void pressF() {
		System.out.println(gameMusic.getTime() + " F");
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}
	public void pressSpace() {
		System.out.println(gameMusic.getTime() + " Space");
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}
	public void pressJ() {
		System.out.println(gameMusic.getTime() + " J");
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}
	public void pressK() {
		System.out.println(gameMusic.getTime() + " K");
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}
	public void pressL() {
		System.out.println(gameMusic.getTime() + " L");
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
	}
	public void releaseS() { noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); }
	public void releaseD() { noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); }
	public void releaseF() { noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); }
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void releaseJ() { noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); }
	public void releaseK() { noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); }
	public void releaseL() { noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage(); }
	
	public void dropNotes(String titleName) throws Exception {
		Beat[] beats = null;
		if (titleName.equals("3rd Prototype - Shadows") && difficulty.equals("Easy")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;	// ��Ʈ ���� �������� ����
			
			beats = new Beat[] {
					new Beat(startTime, "S"),
			};
		}
		else if (titleName.equals("3rd Prototype - Shadows") && difficulty.equals("Hard")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if (titleName.equals("Raven & Kreyn - RICH") && difficulty.equals("Easy")) {
			int beatCount = countBeat(titleName, difficulty);
			int[] time = new int[beatCount];
			String[] noteType = new String[beatCount];
			
			BufferedReader br = new BufferedReader(new FileReader(
					"C:\\Users\\user\\eclipse-workspace\\Rhythm Game\\src\\music_beats\\" +
							titleName + " [" + difficulty + "].txt"));
			
			int i = 0;
			String str;
			while ((str = br.readLine()) != null) {
				String[] temp = str.split(" ");
				time[i] = Integer.parseInt(temp[0]);
				noteType[i] = temp[1];
				++i;
			}
			
			br.close();
			
			int gap = 660 / Main.NOTE_SPEED * Main.SLEEP_TIME;
			
			beats = new Beat[beatCount];
			for (int j = 0; j < beatCount; ++j)
				beats[j] = new Beat(time[j] - gap, noteType[j]);
		}
		else if (titleName.equals("Raven & Kreyn - RICH") && difficulty.equals("Hard")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if (titleName.equals("Debris & RudeLies - Animal (feat. Jex)") && difficulty.equals("Easy")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if (titleName.equals("Debris & RudeLies - Animal (feat. Jex)") && difficulty.equals("Hard")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		
		gameMusic.start();	// Beat �迭 �ʱ�ȭ�ϴµ� �ð��ɸ��Ƿ� �ð������� ���̱� ���� �ʱ�ȭ �� ���� ��� 
		
		int i = 0;
		while (i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			
			if (beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				++i;
				dropped = true;
			}
			
			if (!dropped) {
				try {
					Thread.sleep(5);	// ��Ʈ�� �������� �ʾ��� �� �� �ֱ�
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public int countBeat(String titleName, String difficulty) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(
				"C:\\Users\\user\\eclipse-workspace\\Rhythm Game\\src\\music_beats\\" +
						titleName + " [" + difficulty + "].txt"));
		
		int beatCount = 0;
		while (br.readLine() != null)
			++beatCount;
		
		br.close();
		return beatCount;
	}
	
	public void judge(String input) {
		for (int i = 0; i < noteList.size(); ++i) {
			Note note = noteList.get(i);
			
			if (input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}
	
	public void judgeEvent(String judge) {
		if (!judge.equals("None")) {
			blueFlareImage = new ImageIcon(Main.class.getResource("../images/blueFlare.png")).getImage();
		}
		if (judge.equals("Late")) {
			gameScore += 10;
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeLate.png")).getImage();
		}
		else if (judge.equals("Good")) {
			gameScore += 50;
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGood.png")).getImage();
		}
		else if (judge.equals("Great")) {
			gameScore += 100;
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGreat.png")).getImage();
		}
		else if (judge.equals("Perfect")) {
			gameScore += 200;
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgePerfect.png")).getImage();
		}
		else if (judge.equals("Early")) {
			gameScore += 10;
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeEarly.png")).getImage();
		}
	}
	
	@Override
	public void run() {
		try {
			dropNotes(this.titleName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
}
