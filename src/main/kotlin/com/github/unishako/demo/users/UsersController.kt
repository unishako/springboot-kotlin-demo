package com.github.unishako.demo.users

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/users")
class UsersController(private val service: UsersService) {

    @GetMapping
    fun getUsers(@RequestParam name: String?): List<Users> = service.getUsers(name.orEmpty())

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: BigDecimal): Users? = service.getUser(id)

    @PostMapping
    fun addUser(@RequestBody @Validated dto: UsersRequestDto) = service.addUser(dto)

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: BigDecimal) = service.deleteUser(id)

}