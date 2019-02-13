package com.example.a17259211.helloworld.domain.useCases

import com.example.a17259211.helloworld.domain.repository.UsuarioRepository
import com.example.a17259211.helloworld.model.ApiResult
import com.example.a17259211.helloworld.model.Usuario
import retrofit2.Callback

class CadastrarUsuario (val repository: UsuarioRepository, val callback: Callback<ApiResult>){


    fun execute(usuario: Usuario){

        repository.insert(usuario).enqueue(callback)

    }
}