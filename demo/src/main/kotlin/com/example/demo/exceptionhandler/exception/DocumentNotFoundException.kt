package com.example.demo.exceptionhandler.exception

class DocumentNotFoundException(fileName: String): RuntimeException("File not found: $fileName") {
}