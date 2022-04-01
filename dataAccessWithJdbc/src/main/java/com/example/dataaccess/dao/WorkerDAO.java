package com.example.dataaccess.dao;

import java.sql.*;
import java.util.List;
import com.example.dataaccess.model.Worker;

public interface WorkerDAO {
    public int add(Worker worker)
            throws SQLException;

    public int delete(int workerId)
            throws SQLException;

    public Worker getWorker(int workerId)
            throws SQLException;

    public List<Worker> getWorkers()
            throws SQLException;

    public int update(int worker_id,String email)
            throws SQLException;
}