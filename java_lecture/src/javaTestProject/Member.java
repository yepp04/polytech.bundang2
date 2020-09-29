package javaTestProject;

import java.util.Date;

public class Member implements Comparable<Member> {

	private String id = "";
	private String firstName = "";
	private String lastName = "";
	private String email = "";
	private String gender = "";
	private String signUpDate = "";
	private Date lastLoginDate;
	private String lastLoginTime = "";
	private String point = "";

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

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return id + "," + firstName + " " + lastName + "," + email + "," + gender + "," + signUpDate + ","
				+ lastLoginDate + "," + lastLoginTime + "," + point;
	}

	public Member() {
		super();
	}

	public Member(String id, String firstName, String lastName, String email, String gender, String signUpDate,
			Date lastLoginDate, String lastLoginTime, String point) {
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastLoginDate == null) {
			if (other.lastLoginDate != null)
				return false;
		} else if (!lastLoginDate.equals(other.lastLoginDate))
			return false;
		if (lastLoginTime == null) {
			if (other.lastLoginTime != null)
				return false;
		} else if (!lastLoginTime.equals(other.lastLoginTime))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		if (signUpDate == null) {
			if (other.signUpDate != null)
				return false;
		} else if (!signUpDate.equals(other.signUpDate))
			return false;
		return true;
	}

	// last_login 전용
	@Override
	public int compareTo(Member o) {
		// TODO Auto-generated method stub
		return this.lastLoginDate.compareTo(o.lastLoginDate);
	}

}
