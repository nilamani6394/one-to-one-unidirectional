package com.nilmani.onetooneunidirectional.entiry

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
data class Organization(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long=-1,
    var name:String="",
    var orgId:String="",
    @JsonBackReference
    @OneToOne(targetEntity = Address::class,cascade = [CascadeType.ALL])
    var address: Address
)
