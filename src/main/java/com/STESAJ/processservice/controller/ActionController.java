package com.STESAJ.processservice.controller;

import com.STESAJ.processservice.entity.Action;
import com.STESAJ.processservice.entity.Process;
import com.STESAJ.processservice.service.ActionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping (value = "/actions")
public class ActionController {

    @Autowired
    private ActionService actionService;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<Action>> listAction(@RequestParam(name = "processId", required = false) Long processId){
        List<Action> actions = new ArrayList<>();
        if (null ==  processId){
            actions = actionService.listAllActions();
            if (actions.isEmpty()){

                return ResponseEntity.noContent().build();
//                return new ResponseEntity(HttpStatus.NO_CONTENT);

            }
        }else{
            actions = actionService.findByProcess(Process.builder().process_id(processId).build());
            if (actions.isEmpty()){

                return ResponseEntity.noContent().build();
            }
        }


        return ResponseEntity.ok(actions);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Action> getAction(@PathVariable("id") Long id) {
        Action action =  actionService.getAction(id);
        if (null==action){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(action);
    }


    @PostMapping
    public ResponseEntity<Action> createAction(@Valid @RequestBody Action action, BindingResult result){
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Action actionCreate =  actionService.createAction(action);
        return ResponseEntity.status(HttpStatus.CREATED).body(actionCreate);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Action> updateAction(@PathVariable("id") Long id, @RequestBody Action action){
        action.setActions_id(id);
        Action actionDB =  actionService.updateAction(action);
        if (actionDB == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actionDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Action> deleteAction(@PathVariable("id") Long id){
        Action productDelete = actionService.deleteAction(id);
        if (productDelete == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDelete);
    }

    private String formatMessage( BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String>  error =  new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;

                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }


}
