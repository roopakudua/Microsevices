package com.example.employee.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class DataService {
	@Autowired
	private DataRepository dataRepository;
	
	public List<Data> datas = new ArrayList<>(Arrays.asList(
			new Data("4000101","Avinash",5,"SBI4000101",5000,"State Bank")
			));
	
		
	public List<Data>getAllData(){
		
	  List<Data>datas = new ArrayList<>();
	  dataRepository.findAll().forEach(datas::add);
	  return datas;
	}

	public Optional<Data> getData(String id) {
		return dataRepository.findById(id);
	}
	
	public void addTopic(Data data) {
		   dataRepository.save(data);
		}
	
	public void updateTopic( Data data,String id) {
		   for(int i=0;i<datas.size();i++) {
			   Data d = datas.get(i);
			   if(d.getId().equals(id)) {
				   datas.set(i,data);
				   return;
			   }
		   }
		}
		
		public void deleteTopic(String id) {
			datas.removeIf(t ->t.getId().equals(id));
		}
		
}
