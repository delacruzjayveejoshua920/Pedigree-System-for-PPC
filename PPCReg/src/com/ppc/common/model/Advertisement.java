package com.ppc.common.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.sun.org.apache.xpath.internal.operations.Bool;
@Entity

@Table(name = "Advertisement")
public class Advertisement implements java.io.Serializable{
	
	private static final long serialVersionUID = -557498810091741647L;
	private long id;
	private String advertiser;
	private int numberClicks;
	private double price;
	private String url;
	private String location;
	private String typeAd;
	
	private boolean isActive;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	private PedigreeImage pedigreeimage;
	
	private Boolean isApproved;
	private String approvedBy;
	private Date approvedDate;
	
	private long userId;
	private long imageId;
	
	private User user;
	private Image image;
	
	public Advertisement(int id){
		this.id = id;
	}
	
	public Advertisement(int id, String url, String location, int numberClicks){
		this.id = id;
		this.url = url;
		this.location = location;
		this.numberClicks = numberClicks;
	}
	
	public Advertisement() {
		// TODO Auto-generated constructor stub
	}



	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="ID")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="ADVERTISER")
	public String getAdvertiser() {
		return advertiser;
	}
	public void setAdvertiser(String advertiser) {
		this.advertiser = advertiser;
	}
	
	@Column(name="NUMBER_CLICKS")
	public int getNumberClicks() {
		return numberClicks;
	}
	public void setNumberClicks(int numberClicks) {
		this.numberClicks = numberClicks;
	}
	
	@Column(name="PRICE")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Column(name="URL")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Column(name="LOCATION")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Column(name="TYPE_AD")
	public String getTypeAd() {
		return typeAd;
	}
	public void setTypeAd(String typeAd) {
		this.typeAd = typeAd;
	}
	
	@Column(name="IS_ACTIVE")
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
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
	
	
	
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name="USER_ID_FK", updatable = false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToOne(targetEntity = Image.class, fetch = FetchType.EAGER)
    @JoinColumn(name="IMAGE_ID_FK", updatable = false)
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	
	@OneToOne(targetEntity = PedigreeImage.class, fetch = FetchType.EAGER)
	@JoinColumn(name="PEDIGREEIMAGE_ID_FK", updatable = false)
	public PedigreeImage getPedigreeimage() {
		return pedigreeimage;
	}
	public void setPedigreeimage(PedigreeImage pedigreeimage) {
		this.pedigreeimage = pedigreeimage;
	}
	
	
	
}
 