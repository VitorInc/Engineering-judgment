package com.example.demo.service

import com.example.demo.dto.FileDTOInput
import org.springframework.stereotype.Service
import java.nio.file.Files
import java.nio.file.Paths

@Service
class FileService {

    private val storageDir = Paths.get("C:/storage")
    init {
        if(Files.notExists(storageDir)) {
            Files.createDirectories(storageDir)
        }
    }


    fun persistFileInDirectory(fileInputed: FileDTOInput): String {

        if(fileInputed.filename.isBlank() || fileInputed.content.isBlank()){
            throw RuntimeException("Not possible to persist the file without the filename or content")
        }

        val filePath = storageDir.resolve(fileInputed.filename)
        Files.writeString(filePath, fileInputed.content)

        return "The file $fileInputed was persisted in the directory $storageDir"
    }
}