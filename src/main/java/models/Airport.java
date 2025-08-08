package models;

public class Airport {
    private String name;
    private String city;
    private String state;
    private String country;
    private String codeIATA;

    public Airport(String name, String city, String state, String country, String codeIATA) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.country = country;
        this.codeIATA = codeIATA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCodeIATA() {
        return codeIATA;
    }

    public void setCodeIATA(String codeIATA) {
        this.codeIATA = codeIATA;
    }
}
