package rhythm_game_12;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (RhythmGame.game == null)	// 게임 실행 중이 아니라면
			return;
		
		if (e.getKeyCode() == KeyEvent.VK_S) {
			RhythmGame.game.pressS();
		}
		else if (e.getKeyCode() == KeyEvent.VK_D) {
			RhythmGame.game.pressD();
		}
		else if (e.getKeyCode() == KeyEvent.VK_F) {
			RhythmGame.game.pressF();
		}
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			RhythmGame.game.pressSpace();
		}
		else if (e.getKeyCode() == KeyEvent.VK_J) {
			RhythmGame.game.pressJ();
		}
		else if (e.getKeyCode() == KeyEvent.VK_K) {
			RhythmGame.game.pressK();
		}
		else if (e.getKeyCode() == KeyEvent.VK_L) {
			RhythmGame.game.pressL();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if (RhythmGame.game == null)
			return;
		
		if (e.getKeyCode() == KeyEvent.VK_S) {
			RhythmGame.game.releaseS();
		}
		else if (e.getKeyCode() == KeyEvent.VK_D) {
			RhythmGame.game.releaseD();
		}
		else if (e.getKeyCode() == KeyEvent.VK_F) {
			RhythmGame.game.releaseF();
		}
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			RhythmGame.game.releaseSpace();
		}
		else if (e.getKeyCode() == KeyEvent.VK_J) {
			RhythmGame.game.releaseJ();
		}
		else if (e.getKeyCode() == KeyEvent.VK_K) {
			RhythmGame.game.releaseK();
		}
		else if (e.getKeyCode() == KeyEvent.VK_L) {
			RhythmGame.game.releaseL();
		}
	}
}
