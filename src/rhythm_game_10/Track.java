package rhythm_game_10;

public class Track {
	private String titleImage;	// ���� �̹���
	private String startImage;	// ���� ���� �̹���
	private String gameImage;	// ���� ȭ��
	private String gameMusic;	// ���� ��
	
	public String getTitleImage() { return titleImage; }
	public String getStartImage() { return startImage; }
	public String getGameImage() { return gameImage; }
	public String getGameMusic() { return gameMusic; }
	public void setTitleImage(String titleImage) { this.titleImage = titleImage; }
	public void setStartImage(String startImage) { this.startImage = startImage; }
	public void setGameImage(String gameImage) { this.gameImage = gameImage; }
	public void setGameMusic(String gameMusic) { this.gameMusic = gameMusic; }
	
	public Track(String titleImage, String startImage, String gameImage, String gameMusic) {
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImage = gameImage;
		this.gameMusic = gameMusic;
	}	
}
