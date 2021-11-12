package com.nilmani.onetooneunidirectional.service

import com.nilmani.onetooneunidirectional.entiry.Address
import com.nilmani.onetooneunidirectional.repository.AddressRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AddressService {
    @Autowired
    private lateinit var addressRepository: AddressRepository

    fun createAddress(address: Address):Address{
        val newAddress = Address(
        building = address.building,
        street = address.street,
        city = address.city,
        state = address.state,
        country = address.country,
        zipCode = address.zipCode,
        //organization = address.organization
        )
        return addressRepository.save(newAddress)
    }
}
/**https://dzone.com/articles/introduction-to-spring-data-jpa-part-6-bidirection
https://dzone.com/articles/introduction-to-spring-data-jpa-part-5-unidirectio
https://dzone.com/articles/introduction-to-spring-data-jpa-part-4-bidirection

 Question:Which is better approach unidirectional or bidirectional  when work with join
        */