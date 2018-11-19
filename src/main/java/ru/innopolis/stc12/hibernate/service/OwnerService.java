package ru.innopolis.stc12.hibernate.service;

import ru.innopolis.stc12.hibernate.dao.dto.Owner;

import java.util.List;

public interface OwnerService {
    Owner getOwner(Integer ownerId);

    void insertOwner(Owner owner);

    List<Owner> getAllOwners();

    void updateOwner(Owner owner);

    void deleteOwner(Integer ownerId);
}
