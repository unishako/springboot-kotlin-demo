package com.github.unishako.demo.users

import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class UsersService(private val repository: UsersRepository) {

    fun getUser(id: BigDecimal): Optional<Users> = repository.findById(id)

    fun getUsers(name: String): List<Users> {
        return if (name.isEmpty())
            repository.findAllByOrderById()
        else
            repository.findByNameContainingOrderByIdAsc(name)
    }

    fun addUser(users: Users) {
        repository.save(users)
    }
}

