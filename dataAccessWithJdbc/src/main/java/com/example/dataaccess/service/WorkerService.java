package com.example.dataaccess.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dataaccess.model.Worker;
import com.example.dataaccess.repository.WorkerRepository;
@Service
public class WorkerService {
	@Autowired
	private WorkerRepository workerRepository;
	
	
	public List<Worker> showWorker(Integer id) {
		try {
			
			return List.of(workerRepository.getWorkerById(id));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return List.of();
	}
	

	public List<Worker> showAllWorkers(){
		try {
			return workerRepository.getWorkers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return List.of();
	}
	
			
		
	public boolean createWorker(Worker worker){
		
		int rowsAffected=0;
		try {
			rowsAffected = this.workerRepository.addWorker(worker);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rowsAffected == 1) {
			return true;
		}
		return false;	
		}
	
	public boolean updateEmail(Integer id,String email ){
		int rowsAffected=0;
		try {
			rowsAffected = this.workerRepository.updateByEmail(id,email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rowsAffected == 1) {
			return true;
		}
		return false;	

					
	}
	
	public boolean deleteWorker(Integer id){
		int rowsAffected=0;
		try {
			rowsAffected = this.workerRepository.deleteById(id);
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
