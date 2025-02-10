package loginregister;

public class Student {

	    private String usn;
	    private String email;
	    private String phone;
	    private String username;
	    private String password;

	    public Student(String usn, String email, String phone, String username, String password) {
	        this.usn = usn;
	        this.email = email;
	        this.phone = phone;
	        this.username = username;
	        this.password = password;
	    }

	
	    public String getUsn() {
	        return usn;
	    }

	    public void setUsn(String usn) {
	        this.usn = usn;
	    }


	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}
}

