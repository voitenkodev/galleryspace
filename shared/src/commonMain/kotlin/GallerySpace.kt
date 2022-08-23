import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.ExperimentalUnitApi
import designsystem.common.GallerySpaceTheme
import screens.PreviewScreen

@OptIn(ExperimentalUnitApi::class)
@Composable
fun GallerySpace() {
    GallerySpaceTheme {
        Surface {
            PreviewScreen()
        }
    }
}