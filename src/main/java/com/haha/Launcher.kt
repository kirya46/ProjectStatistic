package com.haha

import java.io.File

class Launcher {
    fun launch(args: ArrayList<String>) {
        println("Args: $args")

        val fileUtil = FileUtil()


        var launchDirectory: File =File("/Users/kirillstoianov/Android/Projects/real-android/app/src")// fileUtil.getJarLaunchDirectory()
        var fileExtension: ArrayList<String> = arrayListOf(".java")

        when {
            args.contains("-f") -> {
                val filePath = args.getOrNull(args.indexOf("-f") + 1)
                if (filePath != null) {
                    launchDirectory = File(filePath)
                }
            }

            args.contains("-ext") -> {
                args.getOrNull(args.indexOf("-ext") + 1)?.apply { fileExtension.add(this) }
            }
        }


        println("\n\n-----------------------------------------")
        println("Launch directory: ${launchDirectory.path}")

        var filesCount = 0
        val lineCount = fileUtil.getFilesList(launchDirectory)
            .filter { it.isFile }
            .filter { fileExtension.contains(fileUtil.getFileExtension(it))}
            .map {
                filesCount += 1
                return@map it.useLines { line -> line.toList() }.size
            }
            .sumBy { it }

        println("Files count = $filesCount")
        println("Line count = $lineCount")
    }
}
