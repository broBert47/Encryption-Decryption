package encryptdecrypt

import java.io.File
import java.lang.Exception

fun main(args: Array<String>) {
   // val mojArraj = arrayOf("-mode", "-data", "nesto", "-in", "in.txt")
    val argsMap = args.toList().chunked(2).associate { it[0] to it[1] }.toMutableMap()

    /* TEST
    //region test data
    argsMap.put("-mode", "enc")
    argsMap.put("-key", "5")
    argsMap.put("-in", "in.txt")
    argsMap["-out"] = "output.txt"




    val document = File("in.txt")
    document.createNewFile()
    document.writeText("Welcome to hyperskill!")
*/

    val mode: Mode = Mode.getValue(argsMap[Parameters.MODE.value])
    val key: EncryptionKey = EncryptionKey.getKey(argsMap[Parameters.KEY.value])
    val data: Data? = Data.getValue(argsMap[Parameters.DATA.value])
    val docIn: DocIn? = DocIn.getvalue(argsMap[Parameters.IN.value])
    val docOut: DocOut? = DocOut.getvalue(argsMap[Parameters.OUT.value])

    if(docIn != null){
        val file = File(docIn.path)
        val text = file.readText()
        if(text == ""){
            println("Error")
            return
        }
    }

    if (mode == Mode.ENC) {
        if(data != null){
            //imamo tekst (i nema dokumenta ili imamo i tekst i dokument)
            val encryptedMessage = encryptMessage(data.message, key.key)
            if(docOut == null){
                println(encryptedMessage)
            } else {
                createFile(docOut.path)
                writeToFile(docOut.path, encryptedMessage)
            }
        } else if(docIn == null){
            //nemamo tekst, nema dokumenta
            val encryptedMessage = encryptMessage("", key.key)
            if(docOut == null){
                println(encryptedMessage)
            } else {
                createFile(docOut.path)
                writeToFile(docOut.path, encryptedMessage)
            }
        } else{
            // nemamo tekst, imamo dokument
            val readText = readingFiles(docIn.path)
            val encryptedMessage = encryptMessage(readText, key.key)
            if(docOut == null){
                println(encryptedMessage)
            } else {
                createFile(docOut.path)
                writeToFile(docOut.path, encryptedMessage)
            }
        }
    }else if (mode == Mode.DEC) {
        if(data != null){
            //imamo tekst (i nema dokumenta ili imamo i tekst i dokument)
            val decryptedMessage = decryptMessage(data.message, key.key)
            if(docOut == null){
                println(decryptedMessage)
            } else {
                createFile(docOut.path)
                writeToFile(docOut.path, decryptedMessage)
            }
        } else if(docIn == null){
            //nemamo tekst, nema dokumenta
            val decryptedMessage = decryptMessage("", key.key)
            if(docOut == null){
                println(decryptedMessage)
            } else {
                createFile(docOut.path)
                writeToFile(docOut.path, decryptedMessage)
            }
        } else{
            // nemamo tekst, imamo dokument
            val readText = readingFiles(docIn.path)
            val decryptedMessage = decryptMessage(readText, key.key)
            if(docOut == null){
                println(decryptedMessage)
            } else {
                createFile(docOut.path)
                writeToFile(docOut.path, decryptedMessage)
            }
        }
    }
}


fun encryptMessage(message: String, key: Int): String {

    message.toCharArray()
    val firstArray = mutableListOf<Char>()
    for (i in message) {
        firstArray.add(i)
    }

    val secondArray = mutableListOf<Char>()
    for (i in firstArray) {
        val newChar = (i.code + key)
        secondArray.add(newChar.toChar())
    }

    return secondArray.joinToString("")
}

fun decryptMessage(message: String, key: Int): String {

    message.toCharArray()
    val firstArray = mutableListOf<Char>()
    for (i in message) {
        firstArray.add(i)
    }

    val secondArray = mutableListOf<Char>()
    for (i in firstArray) {
        val newChar = (i.code - key)
        secondArray.add(newChar.toChar())
    }

    return secondArray.joinToString("")
}

fun readingFiles(fileName: String): String {
    val fileToRead = File(fileName)
    if (!fileToRead.exists()) {
        throw Exception()
    }
    return fileToRead.readText()
}

fun createFile(fileName: String) {
    val fileToCreate = File(fileName)
    fileToCreate.createNewFile()
}

fun writeToFile(fileName: String, message: String){
    val fileToWrite = File(fileName)
    fileToWrite.writeText(message)
}