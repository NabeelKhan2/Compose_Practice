package nabeel.composepracticeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.changedToDown
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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

/*@Composable
fun SlideToUnlockDialog(onUnlock: () -> Unit) {
    var offsetX by remember { mutableStateOf(0f) }
    var isUnlocked by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .offset(x = offsetX.dp)
            .background(Color.Black)
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    if (change.changedToDown()) {
                        offsetX = 0f
                        isUnlocked = false
                    } else if (offsetX + dragAmount.x >= 0) {
                        offsetX += dragAmount.x
                    } else {
                        offsetX = 0f
                    }
                    if (offsetX >= size.width * 0.7f) {
                        isUnlocked = true
                        onUnlock()
                    }
                }
            }
            .padding(20.dp)
    ) {
        Text(
            text = "Slide to unlock",
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )

        if (isUnlocked) {
            AlertDialog(
                onDismissRequest = { isUnlocked = false },
                title = { Text(text = "Dialog Title") },
                text = { Text(text = "Dialog Content") },
                confirmButton = {
                    TextButton(
                        onClick = {
                            isUnlocked = false
                            *//* do something on confirm button click *//*
                        }
                    ) {
                        Text(text = "OK")
                    }
                }
            )
        }
    }
}*/

@Preview(showBackground = true)
@Composable
fun MyPreview() {
    SlideToUnlockDialog {

    }
}

@Composable
fun UnlockScreen() {

}