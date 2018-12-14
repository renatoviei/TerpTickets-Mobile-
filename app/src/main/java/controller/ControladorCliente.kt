package controller

import model.Cliente


class ControladorCliente{
//Os controladores serão ligados aos services
    init {
//        this.repositorio = RepositorioCliente.getInstance()
    }


    fun loginCliente(login: String, senha: String): Boolean {
        var logado = false
//        if (repositorio.existe(login) && repositorio.buscarCliente(login).senha.equals(senha)) {
//
//            logado = true
//            println("Login realizado com sucesso!")
//        } else {
//            println("LOGIN NÃO REALIZADO. CONTA NAO EXISTE!")
//        }
        return logado
    }


}