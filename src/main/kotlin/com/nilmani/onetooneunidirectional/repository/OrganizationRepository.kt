package com.nilmani.onetooneunidirectional.repository

import com.nilmani.onetooneunidirectional.entiry.Organization
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.web.bind.annotation.RequestParam

interface OrganizationRepository : JpaRepository<Organization,Long> {
//    @Query("SELECT Organization .id,Organization .name,Address .building,Address .city FROM  Organization INNER JOIN Address WHERE Organization.address=  :Address")
//    @Query("select o from Organization o inner join fetch o.address")
//    fun findSomeRelationalFeatures(@RequestParam("id")id:Long):Long?
}