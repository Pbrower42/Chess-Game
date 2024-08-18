
public class Piece {
	
	//The name of the piece
	private String name;
	
	//The team the piece is on
	private String team;
	
	//The piece's position on the board
	private String position;
	
	//The piece's capture status
	protected boolean captureFlag;
	
	//The piece's value to be used for the evaluation of a game state
	private int value;
	
	//For pieces that have the potential to have other versions of itself
	public Piece(String pTeam, String pPosition) {
		team = pTeam;
		position = pPosition;
		captureFlag = false;
	}
	
	
	
	public String getTeam() {
		return team;
	}
	
	public String getPosition(){
		return position;
	}
	
	public boolean getFlag() {
		return captureFlag;
	}
	
	public void setTeam(String t) {
		team = t;
	}
	
	public void setPosition(String p) {
		position = p;
	}
	
	public void setFlag(boolean f) {
		captureFlag = f;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public int getValue() {
		return value;
	}
}
