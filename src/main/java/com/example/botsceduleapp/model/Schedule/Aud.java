package com.example.botsceduleapp.model.Schedule;

import jakarta.persistence.*;

@Entity
@Table(name = "aud")
public class Aud {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "corpus")
    private String corpus;
    @Column(name = "number")
    private String number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorpus() {
        return corpus;
    }

    public String getNumber() {
        return number;
    }

    public void setCorpus(String corpus) {
        this.corpus = corpus;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
