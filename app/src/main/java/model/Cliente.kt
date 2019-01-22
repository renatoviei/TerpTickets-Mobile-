package model

data class Cliente(val login: String,
                   val tickets: LongArray?,
                   val favoritos: Array<Evento>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cliente

        if (login != other.login) return false
        if (tickets != null) {
            if (other.tickets == null) return false
            if (!tickets.contentEquals(other.tickets)) return false
        } else if (other.tickets != null) return false
        if (!favoritos.contentEquals(other.favoritos)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = login.hashCode()
        result = 31 * result + (tickets?.contentHashCode() ?: 0)
        result = 31 * result + favoritos.contentHashCode()
        return result
    }
}

