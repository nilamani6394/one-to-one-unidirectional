package com.nilmani.onetooneunidirectional.controller

import com.nilmani.onetooneunidirectional.entiry.Organization
import com.nilmani.onetooneunidirectional.repository.OrganizationRepository
import com.nilmani.onetooneunidirectional.service.OrganizationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class OrganizationController {
    @Autowired
    private lateinit var organizationService: OrganizationService
    @Autowired
    private lateinit var organizationRepository: OrganizationRepository

    @PostMapping("/organization/create")
    fun createOrganization(@RequestBody organization: Organization):ResponseEntity<*>{
        return  organizationService.createOrganization(organization)
    }
   /** @GetMapping("/organization/get/{id}")
    fun getOrganization(@PathVariable id:Long):Organization?{
       if (organizationRepository.findSomeRelationalFeatures(id) != null)
           return organizationRepository.findById(id).get()
        else
            return null
    }*/

   @GetMapping("/organization/get/{id}")
    fun getOrganization(@ModelAttribute id:Long):Organization?{
       return if(organizationRepository.findById(id).isPresent)
           organizationRepository.findById(id).get()
       else
           null
    }
    /**Get all The Organization*/
    @GetMapping("/organization/get")
    fun getAllOrganization():List<Organization>{
        return organizationRepository.findAll()
    }
    @PutMapping("/organization/update/{id}")
    fun updateOrganization(@RequestBody organization: Organization,@PathVariable id:Long):ResponseEntity<*>{
        return organizationService.updateOrganization(id, organization)
    }
}

