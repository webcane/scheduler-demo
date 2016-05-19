package cane.brothers.spring.web;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.core.style.ToStringCreator;

public class CronCreateForm {

	/**
	 * every 5 seconds by default
	 */
    @NotEmpty
    private String cron = "0/5 * * * * *";
    
    @NotEmpty
    private String name = "";
    
    public String getCron() {
        return cron;
    }
    
    public String getName() {
		return name;
	}
    
    public void setCron(String cron) {
    	this.cron = cron;
    }

	public void setName(String name) {
		this.name = name;
	}

	@Override
    public String toString() {
        return new ToStringCreator(this)
                .append("name", this.getName())
                .append("cron", this.getCron())
                .toString();
    }
}
