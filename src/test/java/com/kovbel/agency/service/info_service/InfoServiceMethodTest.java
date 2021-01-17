package com.kovbel.agency.service.info_service;

import com.kovbel.agency.entity.Info;
import com.kovbel.agency.repository.InfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class InfoServiceMethodTest {

    @Mock
    InfoRepository infoRepository;

    @Mock
    Info info;

    @InjectMocks
    InfoServiceMethod infoServiceMethod;


    @Test
    public void findAllByCountryTest() {
        List<Info> infoList = new ArrayList<>();
        Info USA = new Info();
        Info UK = new Info();
        Info Makedonia = new Info();
        USA.setCountry("USA");
        UK.setCountry("USA");
        Makedonia.setCountry("USA");
        infoList.add(USA);
        infoList.add(UK);
        infoList.add(Makedonia);
        when(infoRepository.findAllByCountry("USA")).thenReturn(infoList);
        Assert.assertEquals(infoServiceMethod.findAllByCountry("USA"), infoList);
    }

    @Test
    public void deleteByIdTest() {
        info.setId(12L);
        infoRepository.deleteById(12L);
        verify(infoRepository, times(1)).deleteById(12L);
    }

    @Test
    public void findByIdTest() {
        info.setId(12L);
        infoRepository.findById(12L);
        verify(infoRepository).findById(12l);
    }

    @Test
    public void findAllTest() {
        infoRepository.findAll();
        verify(infoRepository).findAll();
    }

    @Test
    public void saveTest() {
        infoRepository.save(info);
        verify(infoRepository, times(1)).save(info);
    }
}