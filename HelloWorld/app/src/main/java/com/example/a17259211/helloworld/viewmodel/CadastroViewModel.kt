package com.example.a17259211.helloworld.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.SystemClock
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CadastroViewModel : ViewModel(){

    val loading = MutableLiveData<Boolean>()

    fun cadastrarUsuario(){

        loading.postValue(true)

        //Efetuar o cadastro
        doAsync { //cria Uma thread e roda o  que tem no bloco em background
            SystemClock.sleep(2000)

            uiThread { //
                cadastrarUsuarioSucesso()
            }
        }


    }

    fun cadastrarUsuarioSucesso(){
        loading.postValue(false)
    }


}