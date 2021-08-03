package com.STESAJ.processservice.service;

import com.STESAJ.processservice.entity.Process;
import com.STESAJ.processservice.repository.ProcessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcessServiceImpl implements ProcessService{

    private final ProcessRepository processRepository;

    @Override
    public List<Process> listAllProcess() {
        return processRepository.findAll();
    }

    @Override
    public Process getProcess(Long id) {
        return processRepository.findById(id).orElse(null);
    }
}
