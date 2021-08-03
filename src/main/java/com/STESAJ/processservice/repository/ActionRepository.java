package com.STESAJ.processservice.repository;

import com.STESAJ.processservice.entity.Action;
import com.STESAJ.processservice.entity.Process;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {

    public List<Action> findByProcess(Process process);
}
