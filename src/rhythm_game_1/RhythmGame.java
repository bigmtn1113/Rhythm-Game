package rhythm_game_1;

import javax.swing.JFrame;

public class RhythmGame extends JFrame{
	public RhythmGame() {
		setTitle("Rhythm Game");	// â ���� ����
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);	 // â ������ ����
		setResizable(false);	// â ������ ���� �Ұ�
		setLocationRelativeTo(null);	// â�� ȭ�� ���߾ӿ� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// â�� ������ ���α׷��� ����. �̸� �� �ϸ� â�� �ݾƵ� ���α׷��� ���ư�.
		setVisible(true);	// â�� ȭ�鿡 ���
	}
}
