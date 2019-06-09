package com.github.unishako.demo.users

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/users")
class UsersController(private val service: UsersService) {

    @GetMapping
    fun users(@RequestParam name: String?): List<Users> = service.getUsers(name.orEmpty())

    @GetMapping("/{id}")
    fun users(@PathVariable id: BigDecimal): Users? = service.getUser(id)

    @PostMapping
    fun users(@RequestBody @Validated dto: UsersRequestDto) = service.addUser(dto)
}