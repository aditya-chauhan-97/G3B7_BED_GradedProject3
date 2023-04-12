package com.greatlearning.tta.entity;


import jakarta.persistence.*;


@Entity
@Table(name = "tickets")
public class Ticket {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "title", nullable = false)
    private String title;


    @Column(name = "short_description")
    private String shortDescription;


    @Column(name = "content")
    private String content;
    
    @Column(name = "date_created_on")
    private String dateCreatedOn; 


    public Ticket() {


    }


    public Ticket(String title, String shortDescription, String content, String dateCreatedOn) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.content = content;
        this.dateCreatedOn = dateCreatedOn;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }
    
    public String getDateCreatedOn() {
    	return dateCreatedOn;
    }
    
    public void setDateCreatedOn(String dateCreatedOn) {
    	this.dateCreatedOn = dateCreatedOn;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getShortDescription() {
        return shortDescription;
    }


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

}

