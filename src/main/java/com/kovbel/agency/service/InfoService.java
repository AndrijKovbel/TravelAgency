package com.kovbel.agency.service;

import com.kovbel.agency.entity.Info;

import java.util.List;

public interface InfoService {

    List<Info> findAllByCountry(String country);
    Info findById(Long id);
    List<Info> findAll();
    void deleteById(Long id);
    void save(Info info);
}
