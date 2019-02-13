package com.example.a17259211.helloworld.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.a17259211.helloworld.data.repository.UsuarioRepositoryImpl
import com.example.a17259211.helloworld.data.retrofit.RetrofitFactory
import com.example.a17259211.helloworld.domain.repository.UsuarioRepository
import com.example.a17259211.helloworld.domain.useCases.CadastrarUsuario
import com.example.a17259211.helloworld.model.ApiResult
import com.example.a17259211.helloworld.model.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CadastroViewModel : ViewModel(){

    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<Boolean>()
    val sucesso = MutableLiveData<ApiResult>()


    private  val apiService =  RetrofitFactory().createApiService()


    private val repository: UsuarioRepository = UsuarioRepositoryImpl(apiService)




    val cadastrarusuario = CadastrarUsuario(repository, callback())

    inner class callback : Callback<ApiResult>{
        override fun onResponse(call: Call<ApiResult>?, response: Response<ApiResult>?) {
            val retornoApi = response?.body()
            cadastrarUsuarioSucesso(retornoApi) // duas exclamações faz com quepegue o valor caso venha nulo, dando assim null pointer exception
        }

        override fun onFailure(call: Call<ApiResult>?, t: Throwable?) {
            Log.e("CadastroViewModel", t?.message)
            error.postValue(true)
        }

    }

    fun cadastrarUsuario(user:Usuario){

        loading.postValue(true)
        error.postValue(false)


//        //Efetuar o cadastro

        cadastrarusuario.execute(user)

            //codigo fakie
//        doAsync { //cria Uma thread e roda o  que tem no bloco em background
//            SystemClock.sleep(2000)
//
//            uiThread { //
//                //cadastrarUsuarioSucesso()
//                error.postValue(true)
//            }
//        }


    }

    fun cadastrarUsuarioSucesso(result: ApiResult?){
        loading.postValue(false)

        result?.let {
            sucesso.postValue(result)
        }
    }


}