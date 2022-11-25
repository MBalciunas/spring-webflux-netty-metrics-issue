package com.example.spring.webflux.netty.metrics.issue

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/hello")
class TestController {

    @GetMapping
    suspend fun hello() = "Hello"
}
