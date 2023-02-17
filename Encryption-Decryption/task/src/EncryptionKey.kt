package encryptdecrypt

class EncryptionKey(val key: Int) {

    companion object {
        fun getKey(value: String?): EncryptionKey {
            return if (value == null) {
                defaultKey()
            } else {
                EncryptionKey(value.toInt())
            }
        }

        fun defaultKey(): EncryptionKey {
            return EncryptionKey(0)
        }
    }

}
