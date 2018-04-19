package submittedcoursework2;

public class Match implements Comparable<Match>{

	private String MatchName;
	private int restOfTicket;
	//剩余的票数
	public Match(String matchName,int restOfTicket) {
		super();
		this.restOfTicket = restOfTicket;
		MatchName = matchName;
	}
	
	public int getRestOfTicket() {
		return restOfTicket;
	}
	public void setRestOfTicket(int restOfTicket) {
		this.restOfTicket = restOfTicket;
	}
	public String getMatchName() {
		return MatchName;
	}
	public void setMatchName(String matchName) {
		MatchName = matchName;
	}
	@Override
	public String toString(){
		return "matchName is :" + MatchName + ", number of restOfTicket are:" + restOfTicket;
	}

	@Override
	public int compareTo(Match o) {
	
		return this.MatchName.compareTo(o.MatchName);
	}
	
}
