package com.example;

public class Companies {

    private Developer developer;
    private Distributor distributor;

    public Companies(Developer dev, Distributor dis) {
        this.developer = dev;
        this.distributor = dis;
    }

    public Developer getDeveloper() {
        return this.developer;
    }

    public void setDeveloper(Developer dev) {
        this.developer = dev;
    }

    public Distributor getDistributor() {
        return this.distributor;
    }

    public void setDistributor(Distributor dis) {
        this.distributor = dis;
    }
}
