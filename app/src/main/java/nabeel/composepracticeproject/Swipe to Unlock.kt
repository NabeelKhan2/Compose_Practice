package nabeel.composepracticeproject

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.changedToDown
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SlideToUnlockDialog(onUnlock: () -> Unit) {
    var offsetX by remember { mutableStateOf(0f) }
    var isUnlocked by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
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
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(Color.White)
                .offset(x = offsetX.dp)
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
        ) {
            if (!isUnlocked) {
                Text(
                    text = "►",
                    fontSize = 24.sp,
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        if (isUnlocked) {
            AlertDialog(
                onDismissRequest = { isUnlocked = false },
                title = { Text(text = "Dialog Title") },
                text = { Text(text = "Dialog Content") },
                confirmButton = {
                    TextButton(
                        onClick = {
                            isUnlocked = false
                            /* do something on confirm button click */
                        }
                    ) {
                        Text(text = "OK")
                    }
                }
            )
        }
    }
}