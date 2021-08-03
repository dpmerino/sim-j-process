package com.STESAJ.processservice.service;
import com.STESAJ.processservice.entity.Process;



import java.util.List;

public interface ProcessService {
    public List<Process> listAllProcess();
    public Process getProcess(Long id);
}
