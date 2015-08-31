package com.ppc.common.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "printtrack")
public class Print implements java.io.Serializable{
	private static final long serialVersionUID = -557498810091741647L;
	private long id;
	private String name;
	private Date dateIssue;
	private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
    private boolean isActive;
    private double price;
    private String dogName;
    
    private boolean isApproved;
    private String approvedBy;
    private Date approvedDate;
    
    private Pedigree pedigree;
    private User user;
    
    private long userId;
    
    public Print(int id) {
		this.id = id;
	}
    
    public Print() {
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
    
    @Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="DATE_ISSUE")
	public Date getDateIssue() {
		return dateIssue;
	}
	public void setDateIssue(Date dateIssue) {
		this.dateIssue = dateIssue;
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
	
	@Column(name="IS_ACTIVE")
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
	@Column(name="IS_APPROVED")
	public boolean getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(boolean isApproved) {
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
	
	
	@OneToOne(targetEntity = Pedigree.class, fetch = FetchType.EAGER)
	@JoinColumn(name="PEDIGREE_ID_FK")
	public Pedigree getPedigree() {
		return pedigree;
	}

	public void setPedigree(Pedigree pedigree) {
		this.pedigree = pedigree;
	}
	
	@Column(name="DOG_NAME")
	public String getDogName() {
		return dogName;
	}
	
	
	public void setDogName(String dogName) {
		this.dogName = dogName;
	}
	/*
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="Pedigree", joinColumns={@JoinColumn(name="USER_ID_FK", referencedColumnName="ID")}
    , inverseJoinColumns={@JoinColumn(name="PEDIGREEIMAGE_ID_FK", referencedColumnName="ID")})
	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}
	
	*/
	
	@Column(name="PRICE")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name="USER_ID_FK")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	
	
	
	
}