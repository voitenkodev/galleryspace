import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import io.ktor.client.call.*
import io.ktor.client.request.*
import org.jetbrains.skia.Image

actual suspend fun loadImage(url: String): ImageBitmap {
    val response = ktorClient.get(url).body<ByteArray>()
    return Image.makeFromEncoded(response).toComposeImageBitmap()
}