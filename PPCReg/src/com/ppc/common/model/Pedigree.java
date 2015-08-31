package com.ppc.common.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.sun.org.apache.xpath.internal.operations.Bool;

@Entity
@Table(name = "Pedigree")
public class Pedigree implements java.io.Serializable{
	
	 private static final long serialVersionUID = -557498810091741647L;
     private long id;
     private String registrationNo;
     private String pedigreeFor;
     private String name;
     private int sire;
     private int dam;
     private String breeder;
     private String breed;
     private Date birthDate;
     private String sex;
     private String colorMarking;
     private String status;
     
     private String createdBy;
     private Date createdDate;
     private String updatedBy;
     private Date updatedDate;
     
     private Boolean isApproved;
     private String approvedBy;
     private Date approvedDate;
     private boolean isActive;
     private long userID;
     private long imageID;
     
     private User user;
     private Image image;
     private Print print;
     private PedigreeImage pedigreeimage;
     
	public Pedigree() {
		// TODO Auto-generated constructor stub
	}
	public Pedigree(long id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}
	@Id
 	@GeneratedValue(strategy=IDENTITY)
 	@Column(name="ID")
    public long getId(){
    	 return id;
    }
    public void setId(long id){
    	 this.id = id;
    }
    
    @Column(name="REGISTRATION_NO")
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	
	@Column(name="PEDIGREE_FOR")
	public String getPedigreeFor() {
		return pedigreeFor;
	}
	public void setPedigreeFor(String pedigreeFor) {
		this.pedigreeFor = pedigreeFor;
	}
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="SIRE")
	public int getSire() {
		return sire;
	}
	public void setSire(int sire) {
		this.sire = sire;
	}
	
	@Column(name="DAM")
	public int getDam() {
		return dam;
	}
	public void setDam(int dam) {
		this.dam = dam;
	}
	
	@Column(name="BREEDER")
	public String getBreeder() {
		return breeder;
	}
	public void setBreeder(String breeder) {
		this.breeder = breeder;
	}
	
	@Column(name="BREED")
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	@Column(name="BIRTHDATE")
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Column(name="SEX")
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Column(name="COLOR_MARKING")
	public String getColorMarking() {
		return colorMarking;
	}
	public void setColorMarking(String colorMarking) {
		this.colorMarking = colorMarking;
	}
	
	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name="CREATED_DATE")
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Column(name="UPDATED_DATE")
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Column(name="IS_APPROVED")
	public Boolean getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	@Column(name="APPROVED_BY")
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	
	@Column(name="APPROVED_DATE")
	public Date getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
	
	@Column(name="IS_ACTIVE")
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name="USER_ID_FK", updatable = false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToOne(targetEntity = Image.class, fetch = FetchType.EAGER)
    @JoinColumn(name="IMAGE_ID_FK")
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	
	
	
	@OneToOne(targetEntity = PedigreeImage.class, fetch = FetchType.EAGER)
	@JoinColumn(name="PEDIGREEIMAGE_ID_FK")
	public PedigreeImage getPedigreeimage() {
		return pedigreeimage;
	}
	public void setPedigreeimage(PedigreeImage pedigreeimage) {
		this.pedigreeimage = pedigreeimage;
	}
	
	@OneToOne
    @PrimaryKeyJoinColumn
	public Print getPrint() {
		return print;
	}
	public void setPrint(Print print) {
		this.print = print;
	}
	
	
	
	
	/*
	@OneToOne(targetEntity = PedigreeImage.class, fetch = FetchType.EAGER)
    @JoinColumn(name="PEDIGREEIMAGE_ID_FK")
	public PedigreeImage getPedigreeimage() {
		return pedigreeimage;
	}
	public void setPedigreeimage(PedigreeImage pedigreeimage) {
		this.pedigreeimage = pedigreeimage;
	}
	*/
}