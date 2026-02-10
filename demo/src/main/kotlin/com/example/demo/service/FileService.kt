package com.example.demo.service

import com.example.demo.dto.FileDTO
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


    fun persistFileInDirectory(fileInputed: FileDTO): String {

        if(fileInputed.filename.isBlank() || fileInputed.content.isBlank()){
            throw RuntimeException("Not possible to persist the file without the filename or content")
        }

        val filePath = storageDir.resolve(fileInputed.filename)
        Files.writeString(filePath, fileInputed.content)

        return "The file $fileInputed was persisted in the directory $storageDir"
    }

    fun fetchFileWithFileName(fileName: String) : FileDTO{
        if(fileName.isEmpty()) {
            throw RuntimeException("file name can not be null or empty!")
        }

        val filePath = storageDir.resolve(fileName)

        if(Files.notExists(filePath)) {
            throw RuntimeException("No such file was found")
        }

        val content = Files.readString(filePath)

        return FileDTO(
            filename = fileName,
            content = content
        )

    }
}