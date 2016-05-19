package cane.brothers.spring.service;

import cane.brothers.spring.web.CronCreateForm;

public interface ScheduleService {

	boolean scheduleTask(CronCreateForm form);
}
