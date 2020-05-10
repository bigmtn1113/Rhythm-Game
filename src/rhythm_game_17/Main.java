package rhythm_game_17;

public class Main {
	
	public static final int SCREEN_WIDTH = 1280;	// 창 가로 사이즈 설정
	public static final int SCREEN_HEIGHT = 720;	// 창 세로 사이즈 설정
	public static final int NOTE_SPEED = 6;			// 떨어지는 속도
	public static final int SLEEP_TIME = 10;		// 떨어지는 시간 조절. 0.01초
	public static final int REACH_TIME = 1;			// 판정 라인에 도착하는 시간

	public static void main(String[] args) {
		new RhythmGame();
	}

}
