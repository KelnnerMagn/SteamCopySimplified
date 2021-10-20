package com.example;

import java.io.Serializable;

public class Companies implements Serializable {

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((developer == null) ? 0 : developer.hashCode());
        result = prime * result + ((distributor == null) ? 0 : distributor.hashCode());
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
        Companies other = (Companies) obj;
        if (developer == null) {
            if (other.developer != null)
                return false;
        } else if (!developer.equals(other.developer))
            return false;
        if (distributor == null) {
            if (other.distributor != null)
                return false;
        } else if (!distributor.equals(other.distributor))
            return false;
        return true;
    }
}
