package com.STESAJ.processservice.service;


import com.STESAJ.processservice.entity.Action;
import com.STESAJ.processservice.entity.Process;
import com.STESAJ.processservice.repository.ActionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//clase donde se crean los metodos a utilizar
@Service
@RequiredArgsConstructor
public class ActionServiceImpl implements ActionService{

    private final ActionRepository actionRepository;

    @Override
    public List<Action> listAllActions() {
        return actionRepository.findAll();
    }

    @Override
    public Action getAction(Long id) {
        return actionRepository.findById(id).orElse(null);
    }

    @Override
    public Action createAction(Action action) {
        return actionRepository.save(action);
    }

    @Override
    public Action updateAction(Action action) {
        Action actionDB = getAction(action.getActions_id());
        if (null == actionDB){
            return null;
        }
        actionDB.setNombre_act(action.getNombre_act());
        actionDB.setDesc_act(action.getDesc_act());
        actionDB.setN_steps(action.getN_steps());

        return actionRepository.save(actionDB);
    }

    @Override
//    modificar
    public Action deleteAction(Long id) {
        Action actionDB = getAction(id);
        if (null == actionDB){
            return null;
        }
        return actionRepository.save(actionDB);
    }

    @Override
    public List<Action> findByProcess(Process process){
        return actionRepository.findByProcess(process);
    }
}
