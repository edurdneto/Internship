/**
 * 
 */
package entities;

/**
 * @author eduardo
 *
 */
public class Name {
	String Lname;
	String Fname;
	String Rank;
	String Regiment;
	int times;
	float freq;
	
	public String getRegiment() {
		return Regiment;
	}

	public void setRegiment(String regiment) {
		Regiment = regiment;
	}
	
	public Name(String Lname, int times) {
		super();
		this.Lname = Lname;
		this.times = times;
		this.freq=0;
	}
	
	public Name(String Lname, String Fname,int times) {
		super();
		this.Lname = Lname;
		this.Fname=Fname;
		this.times = times;
		this.freq=0;
	}
	
	public Name(String Lname, String Fname,String rank,int times) {
		super();
		this.Lname = Lname;
		this.Fname=Fname;
		this.times = times;
		this.Rank=rank;
		this.freq=0;
	}
	
	/**
	 * 
	 */
	public Name() {
		this.Lname = null;
		this.Fname= null;
		this.times = 0;
		this.Regiment = " ";
		this.Rank= null;
		this.freq= 0;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String name) {
		this.Lname = name;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getRank() {
		return Rank;
	}

	public void setRank(String rank) {
		Rank = rank;
	}

	public float getFreq() {
		return freq;
	}
	public void setFreq(float freq) {
		this.freq = freq;
	}
}
