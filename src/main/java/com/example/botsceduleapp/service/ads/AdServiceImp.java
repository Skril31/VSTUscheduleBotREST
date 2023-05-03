package com.example.botsceduleapp.service.ads;

import com.example.botsceduleapp.model.Ads.Ad;
import com.example.botsceduleapp.repository.ads.AdRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class AdServiceImp implements AdService {
    private final AdRepository adRepository;
    MongoTemplate mongoTemplate;

    AdServiceImp(AdRepository adRepository, MongoTemplate mongoTemplate){

        this.adRepository = adRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Ad> readAll() {
        return adRepository.findAll();
    }

    @Override
    public void create(Ad ad) {
        ad.setLocalDateTime(LocalDateTime.now());
        adRepository.save(ad);
    }

    @Override
    public Ad read(String id) {
        Ad ad = adRepository.findAdById(id).get();
        return ad;
    }

    @Override
    public boolean delete(String id) {
        Ad ad = adRepository.findAdById(id).get();
        if(ad != null){
            adRepository.delete(ad);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(String id , Ad ad) {
        Ad ad1 = adRepository.findAdById(id).get();
        if(ad1 != null){
            ad.setId(id);
            adRepository.save(ad);
            return true;
        }
        return false;
    }

    @Override
    public List<Ad> GroupFilter(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("groups").is(name));
        return mongoTemplate.find(query,Ad.class);
    }
}
