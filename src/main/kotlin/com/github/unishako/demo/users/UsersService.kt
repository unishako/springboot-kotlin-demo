package com.github.unishako.demo.users

import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*
import javax.transaction.Transactional

@Service
class UsersService(private val repository: UsersRepository) {

    fun getUser(id: BigDecimal): Users? = repository.findById(id).orElse(Users())

    fun getUsers(name: String): List<Users> {
        return if (name.isEmpty())
            repository.findAllByOrderById()
        else
            repository.findByNameContainingOrderByIdAsc(name)
    }

    @Transactional
    fun addUser(users: Users) {
        repository.save(users)
    }
}

