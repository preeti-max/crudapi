package com.springboot.workers.springjdbcexample.repository;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.springboot.workers.springjdbcexample.dao.WorkerDAO;
import com.springboot.workers.springjdbcexample.mapper.WorkerMapper;
import com.springboot.workers.springjdbcexample.model.Worker;
@Repository
public class WorkerRepository implements WorkerDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	
		
	public void create(int worker_id, String first_name, String last_name, int salary, Date joining_date, String department,
            String email) {
		String query = """
                INSERT INTO Worker (
                    WORKER_ID,
                    FIRST_NAME,
                    LAST_NAME,
                    SALARY,
                    JOINING_DATE,
                    DEPARTMENT,
                    email)
                VALUES
                (?,?,?,?,?,?,? )""";
		
		
		jdbcTemplateObject.update(query, worker_id,first_name,last_name,salary,joining_date,department,email);
		
		System.out.println("Student " + first_name + " "+last_name+"'s record inserted successfully");
		return;
	}
	
	public Worker getWorkerById(Integer worker_id) {
		String sql = "SELECT * FROM worker WHERE worker_id = ?";
		Worker worker = jdbcTemplateObject.queryForObject(
				sql, 
				new Object[] {worker_id}, 
				new WorkerMapper()
				);
		
		return worker;
	}
	
	public List<Worker> getAllWorkers() {
		String sql = "SELECT * FROM worker";
		List<Worker> workers = jdbcTemplateObject.query(
				sql, 
				new WorkerMapper()
				);
		
		return workers;
	}
	
	public void update(int w) {
		 String query = "Update worker Set email='mfs.akash@gmail.com' where worker_id=?";
		
		jdbcTemplateObject.update(query,w);
		System.out.println("Record #" + w + "updated");
		return;
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM worker WHERE worker_id = ?";
		jdbcTemplateObject.update(sql, id);
		System.out.println("Record #" + id + " deleted");
		return;
	}

	
}