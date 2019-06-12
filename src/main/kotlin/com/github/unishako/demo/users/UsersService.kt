package com.github.unishako.demo.users

import org.springframework.stereotype.Service
import java.math.BigDecimal
import javax.transaction.Transactional

@Service
class UsersService(private val repository: UsersRepository) {

    fun getUser(id: BigDecimal): Users? = repository.findById(id).orElse(Users())

    fun getUsers(name: String): List<Users> =
            if (name.isEmpty())
                repository.findAllByOrderById()
            else
                repository.findByNameContainingOrderByIdAsc(name)

    @Transactional
    fun addUser(dto: UsersRequestDto) = repository.save(Users(name = dto.name))
}

