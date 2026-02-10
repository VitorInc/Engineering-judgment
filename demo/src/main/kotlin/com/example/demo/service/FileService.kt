package com.example.demo.service

import com.example.demo.dto.FileDTO
import com.example.demo.exceptionhandler.exception.DocumentNotFoundException
import org.springframework.stereotype.Service
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.IllegalArgumentException

@Service
class FileService(private val metricService: MetricService) {

    private val storageDir = Paths.get("C:/storage")
    init {
        if(Files.notExists(storageDir)) {
            Files.createDirectories(storageDir)
        }
    }


    fun persistFileInDirectory(fileInputed: FileDTO): String {

        if(fileInputed.filename.isBlank() || fileInputed.content.isBlank()){
            metricService.incrementErros()

            throw IllegalArgumentException("Not possible to persist the file without the filename or content")
        }

        val filePath = storageDir.resolve(fileInputed.filename)
        Files.writeString(filePath, fileInputed.content)
        metricService.incrementUploads()

        return "The file $fileInputed was persisted in the directory $storageDir"
    }

    fun fetchFileWithFileName(fileName: String) : FileDTO{
        if(fileName.isEmpty()) {
            metricService.incrementErros()

            throw IllegalArgumentException("file name can not be null or empty!")
        }

        val filePath = storageDir.resolve(fileName)

        if(Files.notExists(filePath)) {
            metricService.incrementErros()

            throw DocumentNotFoundException("No such file was found")
        }

        val content = Files.readString(filePath)
        metricService.incrementReads()

        return FileDTO(
            filename = fileName,
            content = content
        )

    }
}