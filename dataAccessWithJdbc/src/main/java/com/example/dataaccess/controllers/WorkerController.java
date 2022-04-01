package com.example.dataaccess.controllers;


import com.example.dataaccess.model.Worker;
import com.example.dataaccess.repository.WorkerRepository;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/worker")
public class WorkerController {
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping("/worker/{id}")
	public List<Worker> showWorker(@PathVariable int id) {
		try {
			
			return List.of(workerRepository.getWorker(id));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return List.of();
	}
	
	@GetMapping("/all")
	public List<Worker> showAllWorkers(){
		try {
			return workerRepository.getWorkers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return List.of();
	}
	
			
	@PostMapping("/create")
	@ResponseStatus(code=HttpStatus.CREATED)	
	public boolean createWorker(@RequestBody Worker worker){
		
		int rowsAffected=0;
		try {
			rowsAffected = this.workerRepository.add(worker);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rowsAffected == 1) {
			return true;
		}
		return false;	
		}
	@PatchMapping("/update/{id}")
	public boolean updateEmail(@PathVariable int id,@RequestBody Map<String,String>requestBody ){
		int rowsAffected=0;
		try {
			rowsAffected = this.workerRepository.update(id,requestBody.get("email"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rowsAffected == 1) {
			return true;
		}
		return false;	

					
	}
	@DeleteMapping("/delete/{id}")
	public boolean deleteWorker(@PathVariable int id){
		int rowsAffected=0;
		try {
			rowsAffected = this.workerRepository.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rowsAffected == 1) {
			return true;
		}
		return false;	

		
				
	}
}


