package com.example;

import java.math.BigDecimal;
import java.util.List;

public class GameStatus {

    private String name;
    private String description;
    private List<Tag> tags;
    private BigDecimal rawPrice;

    public GameStatus(String name, String description, List<Tag> tags, BigDecimal rawPrice) {
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.rawPrice = rawPrice;
    }

    public GameStatus(String name, String description, List<Tag> tags, String rawPrice) {
        this.name = name;
        this.description = description;
        this.tags = tags;
        if (!rawPrice.isBlank() && !rawPrice.isEmpty()) {
            this.rawPrice = new BigDecimal(rawPrice);
        } else {
            this.rawPrice = null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String dsc) {
        this.description = dsc;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    public BigDecimal getRawPrice() {
        return this.rawPrice;
    }

    public void setRawPrice(BigDecimal rawPrice) {
        this.rawPrice = rawPrice;
    }

    public void setRawPrice(String rawPrice) {
        this.rawPrice = new BigDecimal(rawPrice);
    }

}
