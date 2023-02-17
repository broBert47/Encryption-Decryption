package encryptdecrypt

class DocIn(val path: String) {
    companion object {
        fun getvalue(value: String?): DocIn? {
            return if (value == null) {
                null
            } else {
                DocIn(value)
            }
        }
    }
}