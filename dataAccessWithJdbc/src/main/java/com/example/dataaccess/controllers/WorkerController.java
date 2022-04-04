package com.example.dataaccess.controllers;


import com.example.dataaccess.model.Worker;
import com.example.dataaccess.repository.WorkerRepository;
import com.example.dataaccess.service.WorkerService;

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
	private WorkerService workerService;
	
	@GetMapping("/worker/{id}")
	public List<Worker> showWorker(@PathVariable int id) {
		return workerService.showWorker(id);
	}
	
	@GetMapping("/all")
	public List<Worker> showAllWorkers(){
		return workerService.showAllWorkers();
	}
	
			
	@PostMapping("/create")
	@ResponseStatus(code=HttpStatus.CREATED)	
	public boolean createWorker(@RequestBody Worker worker){
		
		return workerService.createWorker(worker);
		}
	
	@PatchMapping("/update/{id}")
	public boolean updateEmail(@PathVariable int id,@RequestBody Map<String,String>requestBody ){
		return workerService.updateEmail(id, requestBody.get("email"));
					
	}
	@DeleteMapping("/delete/{id}")
	public boolean deleteWorker(@PathVariable int id){
		return workerService.deleteWorker(id);
		
				
	}
}


