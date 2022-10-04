package MyPack;

public class student implements java.io.Serializable {
	//Instance Variables
	private String roll;
    private String Fname;
	private String Lname;
	private String fatherName;
	private String gender;
	private String phone;
	private String address;
	private String city;
	private String email;
	private String hifz;
	private String degree;

    public student() {
		
    }
	
	public void setRoll(String roll)
	{
		this.roll= roll;
	}
	
	public void setFname(String Fname)
	{
		this.Fname= Fname;
	}
	
	public void setLname(String Lname)
	{
		this.Lname= Lname;
	}
	
	public void setFatherName(String fatherName)
	{
		this.fatherName= fatherName;
	}
	
	public void setGender(String gender)
	{
		this.gender= gender;
	}
		
	public void setPhone(String phone)
	{
		this.phone= phone;
	}
	
	public void setHifz(String hifz)
	{
		this.hifz= hifz;
	}
	
	public void setDegree(String degree)
	{
		this.degree= degree;
	}
	
	public void setEmail(String email)
	{
		this.email= email;
	}
	
	public void setCity(String city)
	{
		this.city= city;
	}
	
	public void setAddress(String address)
	{
		this.address= address;
	}
	
	
	
	
	
	public String getRoll()
	{
		return roll;
	}
	
	public String getFname()
	{
		return Fname;
	}
	
	public String getLname()
	{
		return Lname;
	}
	
	public String getFatherName()
	{
		return fatherName;
	}
	
	public String getGender()
	{
		return gender;
	}
		
	public String getPhone()
	{
		return phone;
	}
	
	public String getHifz()
	{
		return hifz;
	}
	
	public String getDegree()
	{
		return degree;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getAddress()
	{
		return address;
	}
	
    //public String toString() {
    
    //}
}// end class PersonInfo