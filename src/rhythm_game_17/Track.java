package rhythm_game_17;

public class Track {
	private String titleImage;	// ���� �̹���
	private String startImage;	// ���� ���� �̹���
	private String gameImage;	// ���� ȭ��
	private String gameMusic;	// ���� ����
	private String titleName;	// ���� ����
	
	public String getTitleImage() { return titleImage; }
	public String getStartImage() { return startImage; }
	public String getGameImage() { return gameImage; }
	public String getGameMusic() { return gameMusic; }
	public String getTitleName() { return titleName; }
	public void setTitleImage(String titleImage) { this.titleImage = titleImage; }
	public void setStartImage(String startImage) { this.startImage = startImage; }
	public void setGameImage(String gameImage) { this.gameImage = gameImage; }
	public void setGameMusic(String gameMusic) { this.gameMusic = gameMusic; }
	public void setTitleName(String titleName) { this.titleName = titleName; }
	
	public Track(String titleImage, String startImage, String gameImage, String gameMusic, String titleName) {
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImage = gameImage;
		this.gameMusic = gameMusic;
		this.titleName = titleName;
	}	
}
