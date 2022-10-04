package MyPack;
public class employee implements java.io.Serializable{
	//Instance Variables
    private String Fname;
    private String Lname;
    private String gender;
    private String id;
    private String email;
    private String password;

    public employee() {
	    }
	
	
	public void setFname(String Fname)
	{
		this.Fname=Fname;
	}
	
	public void setLname(String Lname)
	{
		this.Lname=Lname;
	}
	
	public void setGender(String gender)
	{
		this.gender=gender;
	}
	
	public void setId(String id)
	{
		this.id=id;
	}
	
	public void setPassword(String password)
	{
		this.password=password;
	}
	
	public void setEmail(String email)
	{
		this.email=email;
	}
	
	
	
	
	
	
	public String getFname()
	{
		return Fname;
	}
	
	public String getLname()
	{
		return Lname;
	}
	
	public String getGender()
	{
		return gender;
	}
	
	public String getId()
	{
		return id;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	
	
    //public String toString() {
    
    //}
}// end class PersonInfo