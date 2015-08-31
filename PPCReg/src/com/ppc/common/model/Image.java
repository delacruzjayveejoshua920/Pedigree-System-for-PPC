package com.ppc.common.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="image")
public class Image implements java.io.Serializable{
	private static final long serialVersionUID = -557498810091741647L;
	private int id;
	private String fileName;
	private String fileType;
	private double width;
	private double height;
	private String position;
	
	private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
    private boolean isActive;
	
    @Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="ID")
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	
	@Column(name="FILE_NAME")
	public String getFileName(){
		return fileName;
	}
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	
	@Column(name="FILE_TYPE")
	public String getFileType(){
		return fileType;
	}
	public void setFileType(String fileType){
		this.fileType = fileType;
	}
	
	@Column(name="WIDTH")
	public double getWidth(){
		return width;
	}
	public void setWidth(double width){
		this.width = id;
	}
	
	@Column(name="HEIGHT")
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	@Column(name="POSITION")
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
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
}
