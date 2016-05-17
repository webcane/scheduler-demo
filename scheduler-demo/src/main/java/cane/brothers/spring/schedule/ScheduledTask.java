package cane.brothers.spring.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ScheduledTask implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	private String name;
	
	// TODO add atomic counter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ScheduledTask withName(String name) {
		this.name = name;
		return this;
	}

	public void doWork() {
		printMessage();
		// TODO real work
	}

	private void printMessage() {
		log.info("{}: time to work: {}", name, dateFormat.format(new Date()));
	}

	@Override
	public void run() {
		doWork();
	}
}
