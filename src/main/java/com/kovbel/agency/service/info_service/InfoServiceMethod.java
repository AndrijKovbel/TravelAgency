package com.kovbel.agency.service.info_service;

import com.kovbel.agency.entity.Info;
import com.kovbel.agency.repository.InfoRepository;
import com.kovbel.agency.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class InfoServiceMethod implements InfoService {

    public InfoServiceMethod(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    @Autowired
    InfoRepository infoRepository;


    @Override
    public List<Info> findAllByCountry(String country) {
        return infoRepository.findAllByCountry(country);
    }


    @Override
    public void deleteById(Long id) {
        infoRepository.deleteById(id);
    }

    @Override
    public Info findById(Long id) {
        return infoRepository.findById(id).get();
    }

    @Override
    public List<Info> findAll() {
        return infoRepository.findAll();
    }


    @Override
    public void save(Info info) {
        infoRepository.save(info);
    }


}

