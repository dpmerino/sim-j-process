package com.STESAJ.processservice.service;

import com.STESAJ.processservice.entity.Action;
import com.STESAJ.processservice.entity.Process;

import java.util.List;

//interfaz donde se declaran los metodos a utilizar
public interface ActionService {
    public List<Action> listAllActions();
    public Action getAction(Long id);
    public Action createAction(Action action);
    public Action updateAction(Action action);
    public  Action deleteAction(Long id);
    public List<Action> findByProcess(Process process);
}
