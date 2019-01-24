package model

data class Usuario (val login: String,
                   val senha: String,
                   val ingressos: LongArray,
                   val favoritos: Array<Evento>)
