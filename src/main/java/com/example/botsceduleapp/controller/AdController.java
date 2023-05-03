package com.example.botsceduleapp.controller;

import com.example.botsceduleapp.model.Ads.Ad;
import com.example.botsceduleapp.service.ads.AdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdController {
    private final AdService adService;

    AdController(AdService adService){
        this.adService = adService;
    }

    @GetMapping(value = "/ad")
    public ResponseEntity<List<Ad>> readAll(){
        final List<Ad> ads = adService.readAll();

        return ads != null && !ads.isEmpty()
                ? new ResponseEntity<>(ads, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/ad/{id}")
    public ResponseEntity<Ad> read(@PathVariable(name = "id") String id){
        Ad ad = adService.read(id);
        return ad != null
                ? new ResponseEntity<>(ad,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping(value = "/ad")
    public ResponseEntity<?> create(@RequestBody Ad ad){

        adService.create(ad);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/ad/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") String id){
        boolean deleted = adService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "/ad/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") String id, @RequestBody Ad ad){
        boolean updated = adService.update(id, ad);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/ad/{group}/list")
    public ResponseEntity<List<Ad>> GroupFilter(@PathVariable(name = "group") String group){
        List<Ad> list = adService.GroupFilter(group);
        return list != null && !list.isEmpty()
                ? new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
