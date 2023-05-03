package com.example.botsceduleapp.repository.ads;

import com.example.botsceduleapp.model.Ads.Ad;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AdRepository extends MongoRepository<Ad,Long> {
    Optional<Ad> findAllByGroups(String name);
    Optional<Ad> findAdById(String id);
    Optional<Ad> deleteAdById(String id);

}
