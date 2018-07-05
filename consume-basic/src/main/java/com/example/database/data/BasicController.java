package com.example.database.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BasicController {

	@Autowired
	RestTemplate restTemplate;
	@GetMapping("/details")
	public String showDetails()
	{
		Data d  = restTemplate.getForObject("http://employee-data:9000/data/4000101",Data.class);
		String str = "<html><body style='background-color:#ff90b0;'><center><b><font size=\"8\">Employee Database</font></b></center></body></html> \n";
		String s = "Person Id is "+ d.getId() +"\n" + "Person Name is "+ d.getName() + "\n" + "Person Experience is "+ d.getExp();
		return str + s;
	}

}
