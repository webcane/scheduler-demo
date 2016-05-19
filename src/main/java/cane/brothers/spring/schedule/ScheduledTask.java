package cane.brothers.spring.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cane.brothers.spring.model.TaskEntity;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ScheduledTask implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	private Optional<TaskEntity> task;
	
	public TaskEntity getTask() {
		return task.get();
	}

	public void setTask(TaskEntity task) {
		this.task = Optional.of(task);
	}

	public ScheduledTask() {
	}
	
	public ScheduledTask(TaskEntity task) {
		this.task = Optional.of(task);
	}
	
	public void doWork() {
		printMessage();
		// TODO real work
		
		// use mayInterruptIfRunning to cancel
	}

	private void printMessage() {
		log.info("{}: time to work: {}", task.map(TaskEntity::getName).orElse(""), dateFormat.format(new Date()));
	}

	@Override
	public void run() {
		doWork();
	}
}
