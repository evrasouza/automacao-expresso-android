package com.example.myapplication19.pageObjects.Login

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.myapplication19.MainActivity
import com.example.myapplication19.pageObjects.Login.robot.RobotLogin
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TesteLogin {

    private val robot = RobotLogin()

    @get:Rule
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testLoginModeloPage() {
        robot.validarTituloNaTela()
        robot.realizarLogin()
        robot.validarUsuarioLogado()
        robot.clicarBtnVoltar()
        robot.validarTituloNaTela()
    }

}