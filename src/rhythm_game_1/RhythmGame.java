package rhythm_game_1;

import javax.swing.JFrame;

public class RhythmGame extends JFrame{
	public RhythmGame() {
		setTitle("Rhythm Game");	// 창 제목 설정
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);	 // 창 사이즈 조절
		setResizable(false);	// 창 사이즈 조절 불가
		setLocationRelativeTo(null);	// 창을 화면 정중앙에 위치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 창을 닫으면 프로그램도 종료. 이를 안 하면 창을 닫아도 프로그램은 돌아감.
		setVisible(true);	// 창을 화면에 출력
	}
}
