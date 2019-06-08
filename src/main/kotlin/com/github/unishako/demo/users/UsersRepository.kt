package com.github.unishako.demo.users

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
interface UsersRepository: JpaRepository<Users, BigDecimal> {

    fun findAllByOrderById(): List<Users>

    fun findByNameContainingOrderByIdAsc(name: String): List<Users>
}