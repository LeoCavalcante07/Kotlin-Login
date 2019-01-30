package com.example.a17259211.helloworld

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.widget.Button
import android.widget.EditText
import org.hamcrest.CoreMatchers.equalTo
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java)

    lateinit var activity: MainActivity

    @Before
    fun a_setUp(){
        activity = rule.activity

    }


    @Test
    fun b_activityCarregaHintCorretamente(){

        val userName = activity.findViewById<EditText>(R.id.edNome)
        val email = activity.findViewById<EditText>(R.id.edEmail)
        val senha = activity.findViewById<EditText>(R.id.edSenha)
        val botaoEntrar = activity.findViewById<Button>(R.id.btnEntrar)

        Assert.assertThat(botaoEntrar.text.toString(), equalTo("Entrar"))
        Assert.assertThat(userName.hint.toString(), equalTo("Nome do usuário"))
        Assert.assertThat(email.hint.toString(), equalTo("Email"))
        Assert.assertThat(senha.hint.toString(), equalTo("Senha"))


    }



    @Test
    fun c_testeNomeDoisCaracteres(){

        val nome = onView(withHint("Nome do usuário"))
        val email = onView(withId(R.id.edEmail))
        val senha = onView(withId(R.id.edSenha))

        nome.perform(typeText("a"))
        email.perform(typeText("aaaa@a"))
        senha.perform(typeText("aaa12aa"))


        val btnEntrar = onView((withId(R.id.btnEntrar)))

        btnEntrar.perform(click())

        val textErro = "Senha deve conter mais de 3 caracteres"

        //nome.check(ViewAssertions.matches(ViewMatchers.hasErrorText(textErro)))


        nome.check(matches(hasErrorText(textErro)))
       // email.check(matches(hasErrorText(textErro)))

    }


}
