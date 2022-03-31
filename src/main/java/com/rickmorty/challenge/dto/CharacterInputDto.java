package com.rickmorty.challenge.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterInputDto {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String[] episode;
    private OriginInputDto origin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getEpisode() {
        return episode;
    }

    public void setEpisode(String[] episode) {
        this.episode = episode;
    }

    public OriginInputDto getOrigin() {
        return origin;
    }

    public void setOrigin(OriginInputDto origin) {
        this.origin = origin;
    }
}
