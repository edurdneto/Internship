package entities;

public class Soldier {
	
	String Lname;
	String Fname;
	String birthday;
	String Rank;
	String Regimental;
	String Reference;
	
	public Soldier(String lname, String fname, String birthday, String rank,
			String regimental, String reference) {
		super();
		Lname = lname;
		Fname = fname;
		this.birthday = birthday;
		Rank = rank;
		Regimental = regimental;
		Reference = reference;
	}
	
	public Soldier() {
		
	}

	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getRank() {
		return Rank;
	}
	public void setRank(String rank) {
		Rank = rank;
	}
	public String getRegimental() {
		return Regimental;
	}
	public void setRegimental(String regimental) {
		Regimental = regimental;
	}
	public String getReference() {
		return Reference;
	}
	public void setReference(String reference) {
		Reference = reference;
	}
		
}
