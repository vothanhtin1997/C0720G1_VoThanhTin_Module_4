package com.codegym.service;

import com.codegym.entity.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AddressService {
    void save(Address address);
}
