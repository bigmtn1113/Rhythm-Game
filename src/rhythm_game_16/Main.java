package rhythm_game_16;

public class Main {
	
	public static final int SCREEN_WIDTH = 1280;	// â ���� ������ ����
	public static final int SCREEN_HEIGHT = 720;	// â ���� ������ ����
	public static final int NOTE_SPEED = 3;			// �������� �ӵ�
	public static final int SLEEP_TIME = 10;		// �������� �ð� ����. 0.01��
	public static final int REACH_TIME = 2;			// ���� ���ο� �����ϴ� �ð�

	public static void main(String[] args) {
		new RhythmGame();
	}

}