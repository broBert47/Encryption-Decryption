package encryptdecrypt

enum class Method {
    SHIFT,
    UNICODE;

    companion object{
        fun getValue(value: String?): Method{
            return when(value){
                "shift" -> SHIFT
                "unicode" -> UNICODE
                else -> SHIFT
            }
        }
    }



}