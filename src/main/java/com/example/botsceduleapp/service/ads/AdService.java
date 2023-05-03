package com.example.botsceduleapp.service.ads;

import com.example.botsceduleapp.model.Ads.Ad;
import jakarta.persistence.Id;


import java.util.List;

public interface AdService {
     List<Ad> readAll();
     Ad read(String id);
     void create(Ad ad);
     boolean delete(String id);
     boolean update(String id,Ad ad);


}
