package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the AspNetUsers database table.
 * 
 */
@Entity
@Table(name="AspNetUsers")
@NamedQuery(name="AspNetUser.findAll", query="SELECT a FROM AspNetUser a")
public class AspNetUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private String id;

	@Column(name="AccessFailedCount")
	private int accessFailedCount;

	private String adress;

	private Timestamp birthDate;

	@Column(name="Discriminator")
	private String discriminator;

	@Column(name="Email")
	private String email;

	@Column(name="EmailConfirmed")
	private boolean emailConfirmed;

	@Column(name="FirstName")
	private String firstName;

	@Column(name="ImageName")
	private String imageName;

	@Column(name="Insuranceid")
	private int insuranceid;

	private String lastName;

	@Column(name="LockoutEnabled")
	private boolean lockoutEnabled;

	@Column(name="LockoutEndDateUtc")
	private Timestamp lockoutEndDateUtc;

	@Column(name="PasswordHash")
	private String passwordHash;

	@Column(name="PhoneNumber")
	private String phoneNumber;

	@Column(name="PhoneNumberConfirmed")
	private boolean phoneNumberConfirmed;

	@Column(name="SecurityStamp")
	private String securityStamp;

	@Column(name="Speciality")
	private int speciality;

	@Column(name="TwoFactorEnabled")
	private boolean twoFactorEnabled;

	@Column(name="UserName")
	private String userName;

	//bi-directional many-to-one association to Cours
	@ManyToOne
	@JoinColumn(name="course_CourseId")
	private Cours cours1;

	//bi-directional one-to-one association to Cours
	@OneToOne(mappedBy="aspNetUser", cascade={CascadeType.PERSIST})
	private Cours cours2;

	public AspNetUser() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAccessFailedCount() {
		return this.accessFailedCount;
	}

	public void setAccessFailedCount(int accessFailedCount) {
		this.accessFailedCount = accessFailedCount;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Timestamp getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	public String getDiscriminator() {
		return this.discriminator;
	}

	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getEmailConfirmed() {
		return this.emailConfirmed;
	}

	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public int getInsuranceid() {
		return this.insuranceid;
	}

	public void setInsuranceid(int insuranceid) {
		this.insuranceid = insuranceid;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean getLockoutEnabled() {
		return this.lockoutEnabled;
	}

	public void setLockoutEnabled(boolean lockoutEnabled) {
		this.lockoutEnabled = lockoutEnabled;
	}

	public Timestamp getLockoutEndDateUtc() {
		return this.lockoutEndDateUtc;
	}

	public void setLockoutEndDateUtc(Timestamp lockoutEndDateUtc) {
		this.lockoutEndDateUtc = lockoutEndDateUtc;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean getPhoneNumberConfirmed() {
		return this.phoneNumberConfirmed;
	}

	public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) {
		this.phoneNumberConfirmed = phoneNumberConfirmed;
	}

	public String getSecurityStamp() {
		return this.securityStamp;
	}

	public void setSecurityStamp(String securityStamp) {
		this.securityStamp = securityStamp;
	}

	public int getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(int speciality) {
		this.speciality = speciality;
	}

	public boolean getTwoFactorEnabled() {
		return this.twoFactorEnabled;
	}

	public void setTwoFactorEnabled(boolean twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Cours getCours1() {
		return this.cours1;
	}

	public void setCours1(Cours cours1) {
		this.cours1 = cours1;
	}

	public Cours getCours2() {
		return this.cours2;
	}

	public void setCours2(Cours cours2) {
		this.cours2 = cours2;
	}

	@Override
	public String toString() {
		return "AspNetUser [id=" + id + ", accessFailedCount=" + accessFailedCount + ", adress=" + adress
				+ ", birthDate=" + birthDate + ", discriminator=" + discriminator + ", email=" + email
				+ ", emailConfirmed=" + emailConfirmed + ", firstName=" + firstName + ", imageName=" + imageName
				+ ", insuranceid=" + insuranceid + ", lastName=" + lastName + ", lockoutEnabled=" + lockoutEnabled
				+ ", lockoutEndDateUtc=" + lockoutEndDateUtc + ", passwordHash=" + passwordHash + ", phoneNumber="
				+ phoneNumber + ", phoneNumberConfirmed=" + phoneNumberConfirmed + ", securityStamp=" + securityStamp
				+ ", speciality=" + speciality + ", twoFactorEnabled=" + twoFactorEnabled + ", userName=" + userName
				+ ", cours1=" + cours1 + ", cours2=" + cours2 + "]";
	}

	
}