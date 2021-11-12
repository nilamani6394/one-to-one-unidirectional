package com.nilmani.onetooneunidirectional.entiry

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long=-1,
    var building:String="",
    var street:String="",
    var city:String="",
    var state:String="",
    var country:String="",
    var zipCode:String="",
//    @JsonManagedReference
//    @OneToOne(targetEntity = Organization::class,mappedBy = "address")
//    val organization: Organization?=null
)
