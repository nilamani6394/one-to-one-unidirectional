package com.nilmani.onetooneunidirectional.repository

import com.nilmani.onetooneunidirectional.entiry.Address
import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepository : JpaRepository<Address?,Long?> {
}