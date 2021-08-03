package com.STESAJ.processservice.controller;

import com.STESAJ.processservice.entity.Process;
import com.STESAJ.processservice.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/processes")
public class ProcessController {

    @Autowired
    private ProcessService processService;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<Process>> listProcess(){
        List<Process> processes = new ArrayList<>();
            processes = processService.listAllProcess();
            if (processes.isEmpty()){
                return ResponseEntity.noContent().build();
            }



        return ResponseEntity.ok(processes);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Process> getProcess(@PathVariable("id") Long id) {
        Process process =  processService.getProcess(id);
        if (null==process){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(process);
    }
}
