package encryptdecrypt

data class DocOut(val path: String) {
    companion object {
        fun getvalue(value: String?): DocOut? {
            return if (value == null) {
                null
            } else {
                DocOut(value)
            }
        }
    }
}
