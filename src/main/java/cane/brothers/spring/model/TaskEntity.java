package cane.brothers.spring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TASK")
public class TaskEntity extends BaseEntity {
	
	@NotNull
	private String name;           // Task name
	private String description;    // Task description
	private String cronExpression; // Task cron expression
	
	private Date created;          // Date when the task has been created
	private Date running;		   // Date when the task has been run
	private Date completed;		   // Date when the task has been completed
	
	// TODO counter
	//private Long successfullNumber;
	//private Long failNumber;
	//private boolean lastStatus;
	
	//TODO
	//private User owner; // task creator id
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public String getCronExpression() {
		return cronExpression;
	}
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
	
	public void setRunning(Date running) {
		this.running = running;
		//setCompleted(null);
	}
	public boolean isRunning() {
		return running != null;
	}
	
	public void setCompleted(Date completed) {
		this.completed = completed;
		//setRunning(null);
	}
	public boolean isCompleted() {
		return completed != null;
	}
	
}
