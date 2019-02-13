package com.example.a17259211.helloworld.domain.repository

import com.example.a17259211.helloworld.model.ApiResult
import com.example.a17259211.helloworld.model.Usuario
import retrofit2.Call

interface UsuarioRepository {

    fun insert(usuairo: Usuario): Call<ApiResult>

    fun logar(email: String, senha: String): Call<ApiResult>

}