package com.example.demo.controller

import com.example.demo.service.MetricService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/metrics")
class MetricsController(private val metricsService: MetricService) {

    @GetMapping
    fun getMetrics(): Map<String, Int> {
        return metricsService.getMetrics()
    }

}