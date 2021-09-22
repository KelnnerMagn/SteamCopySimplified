package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Game {

    private String name;
    private String description;
    private List<Tag> tags;
    private Developer developer;
    private Distributor distributor;
    private BigDecimal rawPrice;
    private LocalDate realeseDate;

    public Game(String name, String description, List<Tag> tags, Developer developer, Distributor distributor,
            BigDecimal rawPrice, LocalDate realeseDate) {

        this.name = name;
        this.description = description;
        this.tags = tags;
        this.developer = developer;
        this.distributor = distributor;
        this.rawPrice = rawPrice;
        this.realeseDate = realeseDate;
    }

    /**
     * 
     * @param name
     * @param description
     * @param tags
     * @param developer
     * @param distributor
     * @param rawPrice
     * 
     * @apiNote if the String "rawPrice" is empty or blank, the price will be set as
     *          null
     */
    public Game(String name, String description, List<Tag> tags, Developer developer, Distributor distributor,
            String rawPrice, LocalDate realeseDate) {

        this.name = name;
        this.description = description;
        this.tags = tags;
        this.developer = developer;
        this.distributor = distributor;
        this.realeseDate = realeseDate;
        if (!rawPrice.isBlank() && !rawPrice.isEmpty()) {
            this.rawPrice = new BigDecimal(rawPrice);
        } else {
            this.rawPrice = null;
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public BigDecimal getRawPrice() {
        return rawPrice;
    }

    public LocalDate getRealeseDate() {
        return realeseDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Game other = (Game) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}