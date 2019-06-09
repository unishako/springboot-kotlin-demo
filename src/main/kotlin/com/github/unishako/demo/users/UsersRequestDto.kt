package com.github.unishako.demo.users

import javax.validation.constraints.NotBlank

data class UsersRequestDto(
        @get:NotBlank
        var name: String
)