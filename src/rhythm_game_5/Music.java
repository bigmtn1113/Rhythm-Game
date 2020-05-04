package rhythm_game_5;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{	// Thread. �ϳ��� ���� ���α׷�
	/*
	 * javazoom.net -> projects -> JLayer -> JLayer 1.0.1 �ٿ�
	 * ������Ʈ -> Build Path -> Configure Build Path... -> Libraries -> Add Externals JARs... 
	 */
	private Player player;	// �߰��� �ܺ� ���̺귯�� �� �ϳ�
	private boolean isLoop;	// ���� �ݺ� ���� ����
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/" + name).toURI());	// ���� ��������
			fis = new FileInputStream(file);	// ������ ����Ʈ ��Ʈ������ �б�
			bis = new BufferedInputStream(fis);	// ����Ʈ ��Ʈ���� ����Ǿ� �ڽ��� ���� ����ũ�⸸ŭ �����͸� �а� ���ۿ� ����
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() {	// ���� ������ ����ǰ� �ִ� �ð�. 10�ʸ� 10000 ����. 0.001 ����
		if (player == null) return 0;
		return player.getPosition();
	}
	
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();	// Thread ����
	}
	
	@Override
	public void run() {	// Thread�� ��ӹ����� ������ �ۼ�
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while (isLoop);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
