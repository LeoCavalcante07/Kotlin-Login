package com.example.a17259211.helloworld.data.service

import com.example.a17259211.helloworld.model.ApiResult
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded // faz com que as informações sejam enviadas como um formulario do html, e nao em formato JSON
    //pois o PHP não interpreta JSON automaticamente, diferente do node.js que interpreta
    @POST("/leonardo/inserir_usuario.php")
    fun cadastrarUsuario(
            @Field("nome") nome: String,
            @Field("email") email: String,
            @Field("senha") senha: String

    ): Call<ApiResult>

    @FormUrlEncoded
    @POST
    fun logar(@Field("email") email:String, @Field("senha") senha: String): Call<ApiResult>




}