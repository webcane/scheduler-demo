package cane.brothers.spring.service;

import cane.brothers.spring.web.CronCreateForm;

public interface TaskService {

	boolean createTask(CronCreateForm form);
}
