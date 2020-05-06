package rhythm_game_10;

public class Track {
	private String titleImage;	// 제목 이미지
	private String startImage;	// 음악 선택 이미지
	private String gameImage;	// 게임 화면
	private String gameMusic;	// 게임 곡
	
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
