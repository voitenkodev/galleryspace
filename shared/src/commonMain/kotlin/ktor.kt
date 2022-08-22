//import androidx.compose.ui.graphics.ImageBitmap
//import androidx.compose.ui.graphics.toComposeImageBitmap
//import io.ktor.client.*
//import io.ktor.client.call.*
//import io.ktor.client.request.*
//import org.jetbrains.skia.Image

//val ktorClient = HttpClient()

//suspend fun loadImage(url: String): ImageBitmap {
//    val response = ktorClient.get(url).body<ByteArray>()
//    val response = ByteArray(0)
//    return Image.makeFromEncoded(response).toComposeImageBitmap()
//}