package com.example.demo.controller

import com.example.demo.dto.FileDTOInput
import com.example.demo.service.FileService

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController()
class FilesController(var fileService: FileService) {



    @PostMapping("/files")
    fun generateFile(@RequestBody file : FileDTOInput): String {

        return fileService.persistFileInDirectory(file)

    }
}