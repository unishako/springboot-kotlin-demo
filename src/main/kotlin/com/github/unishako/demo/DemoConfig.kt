package com.github.unishako.demo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.BeanCreationException
import org.springframework.beans.factory.InjectionPoint
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

@Configuration
class DemoConfig {

    @Bean
    @Scope("prototype")
    fun logger(ip : InjectionPoint): Logger {
        return LoggerFactory.getLogger(
                ip.methodParameter?.containingClass
                        ?: ip.field?.declaringClass
                        ?: throw BeanCreationException("Cannot find type for Logger")
        )
    }
}