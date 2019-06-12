package com.github.unishako.demo.users

import javax.validation.constraints.NotEmpty

data class UsersRequestDto(
        @get:NotEmpty
        var name: String
)