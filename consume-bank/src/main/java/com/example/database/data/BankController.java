package com.example.database.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BankController {

	@Autowired
	RestTemplate restTemplate;
	@GetMapping("/bank")
	public String showDetails()
	{
		Data d  = restTemplate.getForObject("http://employee-data:9000/data/4000102",Data.class);
		String str = "<html><body style='background-color:#afeeee;'><center><b><font size=\"6\">Bank Database</font></b></center></body></html> \n";
		String s = "Person Account No is "+ d.getAccNO() + "\n" + "Person Bank Name is "+ d.getbankName();
		return str+s;
	}

}
