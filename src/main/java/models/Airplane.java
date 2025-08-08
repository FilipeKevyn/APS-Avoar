package models;

import java.io.Serializable;

public class Airplane implements Serializable {
    private String model;
    private String company;
    private Integer totalCapacity;
    private Integer quantityEconomic;
    private Integer quantityExecutive;
    private Integer quantityFirstClass;

    public Airplane(String model, String company, Integer totalCapacity) {
        this.model = model;
        this.company = company;
        this.totalCapacity = totalCapacity;
        setSeatForClass(totalCapacity);
    }

    public void setSeatForClass(int totalCapacity) {
        this.quantityEconomic = (int) Math.floor(totalCapacity * 0.60);
        this.quantityExecutive = (int) Math.floor(totalCapacity * 0.30);
        this.quantityFirstClass = totalCapacity - (quantityEconomic + quantityExecutive);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(Integer totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public Integer getQuantityEconomic() {
        return quantityEconomic;
    }

    public void setQuantityEconomic(Integer quantityEconomic) {
        this.quantityEconomic = quantityEconomic;
    }

    public Integer getQuantityExecutive() {
        return quantityExecutive;
    }

    public void setQuantityExecutive(Integer quantityExecutive) {
        this.quantityExecutive = quantityExecutive;
    }

    public Integer getQuantityFirstClass() {
        return quantityFirstClass;
    }

    public void setQuantityFirstClass(Integer quantityFirstClass) {
        this.quantityFirstClass = quantityFirstClass;
    }
}
