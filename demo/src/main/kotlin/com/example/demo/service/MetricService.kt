package com.example.demo.service

import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicInteger

@Service
class MetricService {

    private val uploads = AtomicInteger(0)
    private val reads = AtomicInteger(0)
    private val errors = AtomicInteger(0)

    fun incrementUploads() {
        uploads.incrementAndGet()
    }

    fun incrementReads() {
        reads.incrementAndGet()
    }

    fun incrementErros() {
        errors.incrementAndGet()
    }

    fun getMetrics()= mapOf(
        "uploads" to uploads.get(),
        "reads" to reads.get(),
        "errors" to errors.get(),
    )
}