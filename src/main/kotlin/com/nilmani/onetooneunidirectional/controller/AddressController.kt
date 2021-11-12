package com.nilmani.onetooneunidirectional.controller
import com.nilmani.onetooneunidirectional.entiry.Address
import com.nilmani.onetooneunidirectional.service.AddressService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/add")
class AddressController {
    @Autowired
    private lateinit var  addressService: AddressService
    @PostMapping("/newAddress")
    fun saveAddress(@ModelAttribute address: Address):ResponseEntity<*>{
        val newAddress = addressService.createAddress(address)
        val respAddress = Address(
            newAddress.id,
            newAddress.building,
            newAddress.street,
            newAddress.city,
            newAddress.state,
            newAddress.country,
            newAddress.zipCode,
            //newAddress.organization
        )
        return ResponseEntity(respAddress,HttpStatus.OK)
    }
}
