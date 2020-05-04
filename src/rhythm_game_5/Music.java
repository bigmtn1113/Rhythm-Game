package rhythm_game_5;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{	// Thread. 하나의 작은 프로그램
	/*
	 * javazoom.net -> projects -> JLayer -> JLayer 1.0.1 다운
	 * 프로젝트 -> Build Path -> Configure Build Path... -> Libraries -> Add Externals JARs... 
	 */
	private Player player;	// 추가한 외부 라이브러리 중 하나
	private boolean isLoop;	// 무한 반복 여부 결정
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/" + name).toURI());	// 파일 가져오기
			fis = new FileInputStream(file);	// 파일을 바이트 스트림으로 읽기
			bis = new BufferedInputStream(fis);	// 바이트 스트림에 연결되어 자신의 내부 버퍼크기만큼 데이터를 읽고 버퍼에 저장
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() {	// 현재 음악이 실행되고 있는 시간. 10초면 10000 리턴. 0.001 단위
		if (player == null) return 0;
		return player.getPosition();
	}
	
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();	// Thread 종료
	}
	
	@Override
	public void run() {	// Thread를 상속받으면 무조건 작성
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
