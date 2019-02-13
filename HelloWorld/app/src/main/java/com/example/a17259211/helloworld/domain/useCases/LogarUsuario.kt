package com.example.a17259211.helloworld.domain.useCases

import com.example.a17259211.helloworld.domain.repository.UsuarioRepository
import com.example.a17259211.helloworld.model.ApiResult
import javax.security.auth.callback.Callback

class LogarUsuario(val repository: UsuarioRepository, val callback: Callback<ApiResult>) {

    fun execute(email: String, senha: String){
        repository.logar(email, senha).enqueue(callback)
    }

}