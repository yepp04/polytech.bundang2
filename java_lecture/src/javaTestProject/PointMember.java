package javaTestProject;

public class PointMember implements Comparable<PointMember> {

	private String id = "";
	private String firstName = "";
	private String lastName = "";
	private String email = "";
	private String gender = "";
	private String signUpDate = "";
	private String lastLoginDate;
	private String lastLoginTime = "";
	private Double point = 0.0;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(String signUpDate) {
		this.signUpDate = signUpDate;
	}

	public String getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Double getPoint() {
		return point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return id + "," + firstName + " " + lastName + "," + email + "," + gender + "," + signUpDate + ","
				+ lastLoginDate + "," + lastLoginTime + "," + point;
	}

	public PointMember() {
		super();
	}

	public PointMember(String id, String firstName, String lastName, String email, String gender, String signUpDate,
			String lastLoginDate, String lastLoginTime, Double point) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.signUpDate = signUpDate;
		this.lastLoginDate = lastLoginDate;
		this.lastLoginTime = lastLoginTime;
		this.point = point;
	}

	// 포인트 전용
	@Override
	public int compareTo(PointMember o) {
		// TODO Auto-generated method stub
		return this.point.compareTo(o.point) * -1;
	}

}
