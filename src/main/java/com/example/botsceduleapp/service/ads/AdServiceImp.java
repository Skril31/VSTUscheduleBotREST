package com.example.botsceduleapp.service.ads;

import com.example.botsceduleapp.model.Ads.Ad;
import com.example.botsceduleapp.repository.ads.AdRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class AdServiceImp implements AdService {
    private final AdRepository adRepository;

    AdServiceImp(AdRepository adRepository){
        this.adRepository = adRepository;
    }

    @Override
    public List<Ad> readAll() {
        return adRepository.findAll();
    }

    @Override
    public void create(Ad ad) {
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
}
