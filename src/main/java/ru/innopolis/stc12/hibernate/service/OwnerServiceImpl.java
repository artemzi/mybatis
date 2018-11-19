package ru.innopolis.stc12.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc12.hibernate.dao.OwnerMapper;
import ru.innopolis.stc12.hibernate.dao.dto.Owner;

import java.util.List;

@Service(value = "ownerService")
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerMapper ownerMapper;

    public OwnerServiceImpl() {
    }

    @Override
    public Owner getOwner(Integer ownerId) {
        return ownerMapper.getOwner(ownerId);
    }

    @Override
    public void insertOwner(Owner owner) {
        ownerMapper.insertOwner(owner);
    }

    @Override
    public List<Owner> getAllOwners() {
        return ownerMapper.getAllOwners();
    }

    @Override
    public void updateOwner(Owner owner) {
        ownerMapper.updateOwner(owner);
    }

    @Override
    public void deleteOwner(Integer ownerId) {
        ownerMapper.deleteOwner(ownerId);
    }
}
