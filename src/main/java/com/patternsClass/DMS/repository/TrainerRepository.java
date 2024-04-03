package com.patternsClass.DMS.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;

import com.patternsClass.DMS.Models.Trainer;
@Primary
public interface TrainerRepository extends CrudRepository<Trainer, Integer> {

}
