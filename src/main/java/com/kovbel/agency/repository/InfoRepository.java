package com.kovbel.agency.repository;

import com.kovbel.agency.entity.Info;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface InfoRepository extends CrudRepository<Info, Long> {

    List<Info> findAllByCountry(String country);

    Optional<Info> findById(Long id);

    List<Info> findAll();

    void deleteById(Long id);

    Info save(Info info);

    }
