package com.ppc.common.model;

	import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="User")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = -557498810091741647L;
	private long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date birthDate;
	private String gender;
	private String address;
	private String contactNo;
	private String kennelName;
	private String role;
	
	private boolean isAdmin;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	private boolean isActive;
	
	
	private String username;
	private String password;
	private String email;
	
	private String approvedBy;
	private Date approvedDate;
	private boolean isApproved;
	
	private Pedigree pedigree;
	private User user;
	private Advertisement advertisement;
	 

	public User(int id) {
		this.id = id;
	}
	
	public User(String username){
		this.username = username;
	}
	
	public User(){}

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="ID")
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	@Column(name="FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="MIDDLE_NAME")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name="LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "BIRTHDATE")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getBirthDate(){
		return birthDate;
	}
	public void setBirthDate(Date birthDate){
		this.birthDate = birthDate;
	}
	
	@Column(name = "ADDRESS")
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
	
	@Column(name = "GENDER")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "CONTACT_NO")
	public String getContactNo(){
		return contactNo;
	}
	public void setContactNo(String contactNo){
		this.contactNo = contactNo;
	}
	
	@Column(name = "KENNEL_NAME")
	public String getKennelName(){
		return kennelName;
	}
	public void setKennelName(String kennelName){
		this.kennelName = kennelName;
	}
	
	@Column(name="USERNAME")
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "IS_ADMIN")
	public boolean getIsAdmin(){
	    return isAdmin;
	}
	public void setIsAdmin(boolean isAdmin){
		this.isAdmin = isAdmin;
	}
	
	@Column(name = "CREATED_BY")
	public String getCreatedBy(){
		return createdBy;
	}
	public void setCreatedBy(String createdBy){
		this.createdBy = createdBy;
	}
	
	@Column(name = "CREATED_DATE")
	public Date getCreatedDate(){
		return createdDate;
	}
	public void setCreatedDate(Date createdDate){
		this.createdDate = createdDate;
	}
	
	@Column(name = "UPDATED_BY")
	public String getUpdatedBy(){
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy){
		this.updatedBy = updatedBy;
	}
	
	@Column(name = "UPDATED_DATE")
	public Date getUpdatedDate(){
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate){
		this.updatedDate = updatedDate;
	}
	
	@Column(name = "IS_ACTIVE")
	public boolean getIsActive(){
		return isActive;
	}
	public void setIsActive(boolean isActive){
		this.isActive = isActive;
	}
	
	@Column(name = "APPROVED_BY")
	public String getApprovedBy() {
		return approvedBy;
	}
	
	
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	
	@Column(name = "APPROVED_DATE")
	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
	
	@Column(name = "IS_APPROVED")
	public boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	@Column(name="ROLE")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	@OneToOne
    @PrimaryKeyJoinColumn
	public Advertisement getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(Advertisement advertisement) {
		this.advertisement = advertisement;
	}
	
	@Transient
	public String getCompleteName() {
		return getFirstName() + " " + getMiddleName().substring(0, 1) + " " + getLastName();
	}
	
	@OneToOne
    @PrimaryKeyJoinColumn
	public Pedigree getPedigree() {
		return pedigree;
	}

	public void setPedigree(Pedigree pedigree) {
		this.pedigree = pedigree;
	}
	
}
