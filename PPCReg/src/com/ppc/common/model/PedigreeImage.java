package com.ppc.common.model;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PedigreeImage")
public class PedigreeImage implements Serializable{

	private static final long serialVersionUID = 5856964688577104271L;

	private long id;
	private String fileName;
	private String description;
	private String contentType;
	private Long fileSize;
	private Pedigree pedigree;
	private PedigreeImage pedigreeimage;
	
	
	
	public PedigreeImage(){
		
	}
	
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="ID")
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	@Column(name="FILENAME")
	public String getFileName(){
		return fileName;
	}
	
	public void setFileName(String fileName){
		this.fileName = fileName;
	}

	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="CONTENTTYPE")
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Column(name="FILESIZE")
	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	
	@OneToOne
    @PrimaryKeyJoinColumn
	public Pedigree getPedigree() {
		return pedigree;
	}

	public void setPedigree(Pedigree pedigree) {
		this.pedigree = pedigree;
	}

	@OneToOne
    @PrimaryKeyJoinColumn
	public PedigreeImage getPedigreeimage() {
		return pedigreeimage;
	}

	public void setPedigreeimage(PedigreeImage pedigreeimage) {
		this.pedigreeimage = pedigreeimage;
	}
}
