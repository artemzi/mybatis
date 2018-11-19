package ru.innopolis.stc12.hibernate.dao.dto;

public class Owner {
    private Long owner_id;
    private String name;
    private int age;

    public Owner() {
    }

    public Owner(Long owner_id, String name, int age) {
        this.owner_id = owner_id;
        this.name = name;
        this.age = age;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "owner_id=" + owner_id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
