import androidx.compose.ui.graphics.ImageBitmap
import io.ktor.client.*
//import androidx.compose.ui.graphics.toComposeImageBitmap
//import io.ktor.client.call.*
//import io.ktor.client.request.*
//import org.jetbrains.skia.Image

val ktorClient = HttpClient()

suspend fun loadImage(url: String): ImageBitmap {
    return ImageBitmap(0,0)
}

//suspend fun loadImage(url: String): ImageBitmap {
//    val response = ktorClient.get(url).body<ByteArray>()
//    return Image.makeFromEncoded(response).toComposeImageBitmap()
//}