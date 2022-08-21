import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.ExperimentalUnitApi
import common.GallerySpaceTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

data class TeslaModel(
    val title: String, val subtitle: String
)

@ExperimentalUnitApi
@Composable
fun TeslaApp() {
    GallerySpaceTheme {
        Column {
            val img = remember { mutableStateOf<ImageBitmap?>(null) }
            LaunchedEffect(Unit) {
                withContext(Dispatchers.Default) {
                    img.value = loadImage("https://upload.wikimedia.org/wikipedia/commons/a/ad/Philip_K._Howard.jpg")
                }
            }
            img.value?.let { image ->
                Image(bitmap = image, contentDescription = null)
            }
        }
    }
}

