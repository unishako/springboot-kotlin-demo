package com.github.unishako.demo.users

import org.springframework.web.bind.annotation.*
import java.math.BigDecimal
import java.util.*

@RestController
@RequestMapping("/users")
class UsersController(private val service: UsersService) {

    @GetMapping
    fun users(@RequestParam name: String?): List<Users> = service.getUsers(name.orEmpty())

    @GetMapping("/{id}")
    fun users(@PathVariable id: BigDecimal): Optional<Users> = service.getUser(id)

    @PostMapping
    fun users(@RequestBody users: Users) = service.addUser(users)
}