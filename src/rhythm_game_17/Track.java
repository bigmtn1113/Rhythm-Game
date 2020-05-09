package rhythm_game_17;

public class Track {
	private String titleImage;	// 제목 이미지
	private String startImage;	// 음악 선택 이미지
	private String gameImage;	// 게임 화면
	private String gameMusic;	// 게임 음악
	private String titleName;	// 음악 제목
	
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
