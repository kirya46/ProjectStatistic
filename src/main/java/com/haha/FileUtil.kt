package com.haha

import java.io.File
import java.nio.file.Files
import kotlin.streams.toList


class FileUtil {

    fun getJarLaunchDirectory(): File {
        return File(
            this::class.java.protectionDomain.codeSource.location.toURI()
        ).parentFile
    }

    fun getFilesList(file: File): ArrayList<File> {
        return ArrayList(file.walkTopDown().toList())
    }

    fun getFileExtension(file: File): String? {
        val path = file.path
        val startIndex = path.toString().lastIndexOf(".")
        if (startIndex < 0) return null
        return path.substring(startIndex, path.length)
    }

    fun getFileName(file: File): String? {
        val directory = file.path.substringBeforeLast("/")
        val fullName = file.path.substringAfterLast("/")
        val fileName = fullName.substringBeforeLast(".")
        val extension = fullName.substringAfterLast(".")
        return fileName + "." + extension
    }
}