package nabeel.composepracticeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import nabeel.composepracticeproject.ui.theme.ComposePracticeProjectTheme

/*fun main() {
    val array = arrayOf(1, 2, 3, 4, 5)
    array.reverse()
    var firstElement: Int
    var lastElement: Int
    var currIndex = array.size - 1
    val div = array.size / 2
    for (i in array.indices) {
        firstElement = array[i]
        lastElement = array[currIndex]
        if ( i <= div){
            array[i] = lastElement
            array[currIndex] = firstElement
        }
        currIndex--
    }
    array.forEach {
        println(it)
    }
}*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeProjectTheme {
                val navController = rememberNavController()
                NavigationView(navController = navController)
            }
        }
    }
}

@Composable
fun NavigationView(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "listScreen") {
        composable("listScreen") {
            ListScreen(navController)
        }
        composable("unlockScreen") {
            UnlockScreen()
        }
    }
}

@Composable
fun ListScreen(navController: NavHostController) {
    val list = listOf("Swipe to Unlock", "Task 1", "Task 2", "Task 3", "Task 4", "Task 5")
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp)
    ) {
        items(list) { item ->
            if (item == "Swipe to Unlock") {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray, RoundedCornerShape(20.dp))
                        .padding(20.dp)
                        .clickable {
                            navController.navigate("unlockScreen")
                        }
                ) {
                    Text(
                        text = item,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray, RoundedCornerShape(20.dp))
                        .padding(20.dp)
                ) {
                    Text(
                        text = item,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun UnlockScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        val coroutineScope = rememberCoroutineScope()
        val (isComplete, setIsComplete) = remember {
            mutableStateOf(false)
        }

        SwipeButton(
            modifier = Modifier.align(Alignment.Center),
            text = "slide To unlock",
            isComplete = isComplete,
            onSwipe = {
                coroutineScope.launch {
                    delay(2000)
                    setIsComplete(true)
                }
            },
        )
    }
}