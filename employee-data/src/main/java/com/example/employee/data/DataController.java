package com.example.employee.data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class DataController {
	
	@Autowired
	private DataService dataService;
	
	@RequestMapping("/data")
	public List<Data> getAllData(){
		return dataService.getAllData();
	}
	
	@RequestMapping("/data/{id}")
	public Optional<Data> getData(@PathVariable String id) {
		return dataService.getData(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value = "/data")
	public void addTopic(@RequestBody Data data) {
	   dataService.addTopic(data);	
	}
	
	@RequestMapping(method=RequestMethod.PUT,value = "/data/{id}")
	public void updateTopic(@RequestBody Data data,@PathVariable String id) {
	   dataService.updateTopic(data,id);	
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value = "/data/{id}")
	public void deleteTopic(@PathVariable String id) {
	   dataService.deleteTopic(id);	
	}
		

}