package encryptdecrypt

data class Data(val message: String) {

    companion object {
        fun getValue(value: String?): Data? {
            return if (value == null) {
                null
            } else {
                Data(value)
            }
        }
    }
}
