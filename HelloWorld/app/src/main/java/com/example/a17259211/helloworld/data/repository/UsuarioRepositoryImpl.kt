package com.example.a17259211.helloworld.data.repository

import com.example.a17259211.helloworld.data.service.ApiService
import com.example.a17259211.helloworld.domain.repository.UsuarioRepository
import com.example.a17259211.helloworld.model.ApiResult
import com.example.a17259211.helloworld.model.Usuario
import retrofit2.Call

class UsuarioRepositoryImpl(val apiService: ApiService) : UsuarioRepository{

    override fun logar(email: String, senha: String): Call<ApiResult> {
        return apiService.logar(email, senha)
    }

    override fun insert(usuairo: Usuario): Call<ApiResult> {
        return apiService.cadastrarUsuario(usuairo.nome, usuairo.email, usuairo.senha)
    }



}