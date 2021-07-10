package com.sys.axsos.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="questions")
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull(message="DONT leave it blanc")
	private String question;
	
	@OneToMany(mappedBy="question", fetch = FetchType.LAZY)
	private List<Answer> answers;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	        name = "questions_tags", 
	        joinColumns = @JoinColumn(name = "question_id"), 
	        inverseJoinColumns = @JoinColumn(name = "tag_id")
	    )
	private List<Tag> tags;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="MM-dd-yyyy")
    private Date createdAt;
	@DateTimeFormat(pattern="MM-dd-yyyy")
    private Date updatedAt;

    
    public Question() {
		super();
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * @return the answers
	 */
	public List<Answer> getAnswers() {
		return answers;
	}
	/**
	 * @return the tags
	 */
	public List<Tag> getTags() {
		return tags;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
}
