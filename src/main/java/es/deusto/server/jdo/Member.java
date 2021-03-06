package es.deusto.server.jdo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.Key;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Serialized;

/**
 * A simple member class.
 * @author Team 05
 *
 */
@PersistenceCapable
public class Member{

	/**
	 * User implements Serializable to be transferred to the RMI client
	 */
	private static final long serialVersionUID = 1L;
	String email = "";
	@PrimaryKey
	String name = "4lp4rg4t4";
	String password = "4lp4rg4t4";
	int premium = 0;

	@Persistent(mappedBy = "member", dependentElement = "true")
	@Join
	List<Comment> commentsM = new ArrayList<Comment>();

	/**
	 * Constructor method
	 */
	public Member(){}
	
	/**
	 * Constructor with parameters
	 * @param email
	 * @param name
	 * @param password
	 * @param commentsM
	 * @param premium
	 */
	public Member(String email, String name, String password, List<Comment> commentsM, int premium) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.commentsM = commentsM;
		this.premium = premium;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return premium
	 */
	public int getPremium(){
		return this.premium;
	}
	
	/**
	 * @param premium
	 */
	public void setPremium(int premium){
		this.premium = premium;
	}

}
