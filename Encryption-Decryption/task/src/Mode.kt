package encryptdecrypt

enum class Mode {
    ENC,
    DEC;

    companion object{
        fun getValue(value: String?): Mode{
            return when(value){
                "enc" -> ENC
                "dec" -> DEC
                else -> ENC
            }
        }
    }
}
