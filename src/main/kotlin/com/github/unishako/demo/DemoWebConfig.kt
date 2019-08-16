package com.github.unishako.demo

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class DemoWebConfig(private val it: DemoHandlerInterceptor): WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(it)
        super.addInterceptors(registry)
    }
}