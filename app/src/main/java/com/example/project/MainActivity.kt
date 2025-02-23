package com.example.project

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project.ui.theme.ProjectTheme
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.Credentials
import kotlinx.coroutines.runBlocking

val ThemeColor = Color(213, 191, 160)//0xFFD5BFA0
val LightColor = ThemeColor.copy(alpha = 0.2f) //原0xFFE9E8E5

class MainActivity : ComponentActivity() {
    private lateinit var app: App
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = App.create("application-0-fbwwmjb")
        runBlocking {
            val credentials = Credentials.anonymous(true)
            val user = app.login(credentials)

            Log.i("TAG", "onCreate: user logged in successfully uid = ${user.id}")
        }
        setContent {
            ProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { Home(navController) }
        composable("mode") { ChoosingMode(navController) }
        composable("cards") { ChoosingCards() }
        composable("owningCards") { OwningCards() }
        composable("chatting") { Chatting() }
//
        composable("month") { MonthScreen(navController) }
        composable("search") { SearchScreen(navController) }
        composable("MonthSelection") { MonthSelectionScreen(navController) }
        composable("Record") { RecordScreen(navController)}
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjectTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MyApp()
        }
    }
}
