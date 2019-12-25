package com.haha

import java.nio.file.Files
import java.util.*
import kotlin.collections.ArrayList

class Launcher {
    fun launch(args: Array<String>) {
        println("Args: ${args.contentToString()}")
        val fileUtil = FileUtil()
        val launchDirectory = fileUtil.getJarLaunchDirectory()
        println("\n\n-----------------------------------------")
        println("Launch directory: ${launchDirectory.path}")

        fileUtil.getFilesList(launchDirectory).filter { it.isFile }.forEach {

            if (fileUtil.getFileExtension(it) == ".kt") {
                it.useLines { it.toList() }.forEach { println(it) }
            }
        }
    }
}
