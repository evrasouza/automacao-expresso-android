package com.example.myapplication19.pageObjects.Login.robot

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.myapplication19.R
import com.example.myapplication19.pageObjects.Login.constants.ConstantsLogin.BTN_VOLTAR
import com.example.myapplication19.pageObjects.Login.constants.ConstantsLogin.EMAIL_SUCESSO
import com.example.myapplication19.pageObjects.Login.constants.ConstantsLogin.PASSWORD_SUCESSO
import com.example.myapplication19.pageObjects.Login.constants.ConstantsLogin.TEXTO_LOGADO
import com.example.myapplication19.pageObjects.Login.constants.ConstantsLogin.TITULO_APLICATIVO

class RobotLogin {

    fun validarTituloNaTela() {
        onView(withText(TITULO_APLICATIVO)).check(matches(isDisplayed()))
    }

    fun preencherEmail() {
        onView(withId(CAMPO_EMAIL)).perform(typeText(EMAIL_SUCESSO))
    }

    fun preencherPassword() {
        onView(withId(R.id.fieldPass)).perform(typeText(PASSWORD_SUCESSO))
    }

    fun fecharTeclado() {
        Espresso.closeSoftKeyboard()
    }

    fun clicarBtnLogin() {
        onView(withId(R.id.button_first1)).perform(click())
    }

    fun realizarLogin() {
        preencherEmail()
        preencherPassword()
        fecharTeclado()
        clicarBtnLogin()
    }

    fun validarUsuarioLogado() {
        onView(withText(TEXTO_LOGADO)).check(matches(isDisplayed()))
    }

    fun clicarBtnVoltar() {
        onView(withText(BTN_VOLTAR)).perform(click())
    }

    companion object {
        private val CAMPO_EMAIL = R.id.fieldEmail
    }

}