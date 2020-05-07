package rhythm_game_14;

public class Beat {
	private int time;	// 노트가 떨어지기 시작하는 시간. 몇 초 뒤에 노트가 떨어질 것인가 설정
	private String noteName;
	
	public Beat(int time, String noteName) {
		super();
		this.time = time;
		this.noteName = noteName;
	}

	public int getTime() { return time; }
	public String getNoteName() { return noteName; }
	public void setTime(int time) { this.time = time; }
	public void setNoteName(String noteName) { this.noteName = noteName; }
}
