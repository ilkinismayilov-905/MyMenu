package com.example.MyMenu.service.impl;

import com.example.MyMenu.entity.about.AboutWebsite;
import com.example.MyMenu.repository.AboutRestaurantRepository;
import com.example.MyMenu.repository.AboutWebsiteRepository;
import com.example.MyMenu.service.AboutWebsiteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AboutWebsiteServiceImpl implements AboutWebsiteService {

    private final AboutWebsiteRepository aboutWebsiteRepository;

    @Autowired
    public AboutWebsiteServiceImpl(AboutWebsiteRepository aboutWebsiteRepository) {
        this.aboutWebsiteRepository = aboutWebsiteRepository;
    }



    @Override
    public void deleteById(Long id) {
        if(aboutWebsiteRepository.existsById(id)){

            aboutWebsiteRepository.deleteById(id);
        }
    }

    @Override
    public AboutWebsite save(AboutWebsite entity) {
        return aboutWebsiteRepository.save(entity);
    }

    @Override
    public Optional<AboutWebsite> getById(Long id) {
        Optional<AboutWebsite> website = aboutWebsiteRepository.findById(id);

        if(website.isEmpty()){
            throw new RuntimeException("Error");
        }
        return website;
    }

    @Override
    public List<AboutWebsite> getAll() {
        return aboutWebsiteRepository.findAll();
    }
}
