package com.nilmani.onetooneunidirectional.service

import com.nilmani.onetooneunidirectional.entiry.Address
import com.nilmani.onetooneunidirectional.entiry.Organization
import com.nilmani.onetooneunidirectional.repository.AddressRepository
import com.nilmani.onetooneunidirectional.repository.OrganizationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType


@Service
class OrganizationService {
    @Autowired
    private lateinit var organizationRepository: OrganizationRepository
    @Autowired
    private lateinit var  addressRepository: AddressRepository

    @Transactional
    fun createOrganization(organization: Organization):ResponseEntity<*>{
        val org = Organization(
            name = organization.name,
            orgId = organization.orgId,
            address = organization.address
        )
//        org.name = organization.name
//        org.orgId = organization.orgId
//        org.address = organization.address
        val saveOrg = organizationRepository.save(org)
        return if (organizationRepository.findById(saveOrg.id).isPresent)
            ResponseEntity.ok().body("Organization create successful")
        else
            ResponseEntity.unprocessableEntity().body("Organization create failed............")
    }
    @Transactional
    fun updateOrganization(id:Long,organization: Organization):ResponseEntity<*>{
        if (organizationRepository.findById(id).isPresent){
            val orga:Organization = organizationRepository.findById(id).get()
            organization.name = orga.name
            organization.orgId=orga.orgId
            val address: Address = addressRepository?.findById(organization.address.id)?.get()
            address?.building = organization.address.building
            address?.street =organization.address.street
            address?.city = organization.address.city
            address?.state = organization.address.state
            address?.country = organization.address.country
            address?.zipCode = organization.address.zipCode
            val saveAddress:Address = addressRepository.save(address)
            organization.address = saveAddress
            val saveOrganization:Organization = organizationRepository.save(organization)
            if (organizationRepository.findById(saveOrganization.id).isPresent)
                return  ResponseEntity.ok().body("Organization update success full")
            else
                return ResponseEntity.unprocessableEntity().body("Failed to update the specified organization")
        }else
            return ResponseEntity.unprocessableEntity().body("Specified organization Not found")
    }
}

