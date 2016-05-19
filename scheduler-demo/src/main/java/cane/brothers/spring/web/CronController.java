package cane.brothers.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cane.brothers.spring.service.ScheduleService;

@Controller
@RequestMapping(value = "/cron")
public class CronController {

	@Autowired
	private ScheduleService scheduleService;
	
	/**
	 * provide CronCreateForm model object to empty form 
	 * 
	 * @return model and view
	 */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCronForm() {
        return new ModelAndView("cron", "form", new CronCreateForm());
    }
    
    /**
     * create new cron task
     * 
     * @param form
     * @return view name
     */
    @RequestMapping(method = RequestMethod.POST)
    public String handleCronForm(@ModelAttribute("form") CronCreateForm form) {
        
        // add cron task into schedule
    	scheduleService.scheduleTask(form);
        
        // ok, redirect
        return "redirect:/tasks";
    }
}
