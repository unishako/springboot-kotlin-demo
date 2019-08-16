package com.github.unishako.demo.users

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table
data class Users(
        @Id @GeneratedValue(strategy =  GenerationType.IDENTITY) var id: BigDecimal? = null,
        var name: String = "")