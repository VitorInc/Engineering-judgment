package com.example.demo.controller

import com.example.demo.dto.FileDTO
import com.example.demo.service.FileService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/files")
class FilesController(private val fileService: FileService) {



    @PostMapping()
    fun generateFile(@RequestBody file : FileDTO): ResponseEntity<String> {

        return ResponseEntity.status(HttpStatus.CREATED).body(fileService.persistFileInDirectory(file))

    }

    @GetMapping("/{fileName}")
    fun fetchFile(@PathVariable fileName : String): ResponseEntity<FileDTO> {

        return ResponseEntity.ok(fileService.fetchFileWithFileName(fileName))

    }

}