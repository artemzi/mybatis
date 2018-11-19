package ru.innopolis.stc12.hibernate.dao.dto;

public class Mobile {
    private Long mobile_id;
    private String model;
    private String developer;
    private Integer cost;

    public Mobile() {
    }

    public Mobile(Long mobile_id, String model, String developer, Integer cost) {
        this.mobile_id = mobile_id;
        this.model = model;
        this.developer = developer;
        this.cost = cost;
    }

    public Long getMobile_id() {
        return mobile_id;
    }

    public void setMobile_id(Long mobile_id) {
        this.mobile_id = mobile_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "mobile_id=" + mobile_id +
                ", model='" + model + '\'' +
                ", developer='" + developer + '\'' +
                ", cost=" + cost +
                '}';
    }
}
