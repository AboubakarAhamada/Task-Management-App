/**
 * 
 */
package com.aboubakar.TaskManangementSpringBoot;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Aboubakar
 *
 */

@Controller 
public class TaskController {
	
	@Autowired 
	private ITaskService taskService;
	
	@InitBinder
	public void initBinder( WebDataBinder binder) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
		
	}
	
	@RequestMapping(value="/list-tasks", method=RequestMethod.GET)
	public String showTasks( ModelMap model) {
		
		model.put("tasks",taskService.getAllTasks());
		
		return "list-tasks";
	}
	
	private String getLoggedInUserName(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }
	
	@RequestMapping(value="/add-task", method=RequestMethod.GET)
	public String showAddTaskPage(ModelMap model) {
		
		model.addAttribute("task", new Task());
		return "task";
	}
	
	@RequestMapping(value = "/delete-task", method = RequestMethod.GET)
    public String deleteTask(@RequestParam long id) {
        taskService.deleteTask(id);
        return "redirect:/list-tasks";
    }

    @RequestMapping(value = "/update-task", method = RequestMethod.GET)
    public String showUpdateTaskPage(@RequestParam long id, ModelMap model) {
        Task task = taskService.getTaskById(id).get();
        model.put("task", task);
        return "task";
    }

    @RequestMapping(value = "/update-task", method = RequestMethod.POST)
    public String updateTask(ModelMap model, @Valid Task task, BindingResult result) {

        if (result.hasErrors()) {
            return "task";
        }

       // task.setUserName(getLoggedInUserName(model));
        taskService.updateTask(task);
        return "redirect:/list-tasks";
    }

    @RequestMapping(value = "/add-task", method = RequestMethod.POST)
    public String addTask(ModelMap model, @Valid Task task, BindingResult result) {

        if (result.hasErrors()) {
            return "task";
        }

        //task.setUserName(getLoggedInUserName(model));
        taskService.saveTask(task);
        return "redirect:/list-tasks";
    }

}
