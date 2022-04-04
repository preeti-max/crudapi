package com.example.dataaccess.dao;

import java.sql.*;
import java.util.List;
import com.example.dataaccess.model.Worker;

public interface WorkerDAO {
    public int addWorker(Worker worker)
            throws SQLException;

    public int deleteById(int workerId)
            throws SQLException;

    public Worker getWorkerById(int workerId)
            throws SQLException;

    public List<Worker> getWorkers()
            throws SQLException;

    public int updateByEmail(int worker_id,String email)
            throws SQLException;
}