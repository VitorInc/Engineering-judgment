package com.example.demo.controller

import com.example.demo.service.MetricService
import org.springframework.web.bind.annotation.RestController

@RestController("/metrics")
class MetricsController(metricsService: MetricService) {

}