package com.example.myapplication19

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class TesteFormatoBasico {

    @get:Rule
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testLogin() {
        onView(withText("Aplicativo de Testes")).check(matches(isDisplayed()))
        onView(withId(R.id.fieldEmail)).perform(typeText("everton@teste.com.br"))
        onView(withId(R.id.fieldPass)).perform(typeText("pwd123"))
        closeSoftKeyboard()
        onView(withId(R.id.button_first1)).perform(click())

        // Segunda Tela, com o usuário já logado
        onView(withText("Logado com sucesso")).check(matches(isDisplayed()))
        onView(withText("VOLTAR")).perform(click())
        onView(withText("Aplicativo de Testes")).check(matches(isDisplayed()))
    }

    @Test
    fun testLoginFalha() {
        onView(withText("Aplicativo de Testes")).check(matches(isDisplayed()))
        onView(withId(R.id.fieldEmail)).perform(typeText("everton@teste.com.br"))
        onView(withId(R.id.fieldPass)).perform(typeText("pwd123"))
        closeSoftKeyboard()
        onView(withText("LOGIN")).perform(click())

        // Segunda Tela, com o usuário já logado
        onView(withText("Logado com sucesso")).check(matches(isDisplayed()))
        onView(withText("VOLTAR")).perform(click())
        onView(withText("Aplicativo de Teste")).check(matches(isDisplayed()))
    }
}