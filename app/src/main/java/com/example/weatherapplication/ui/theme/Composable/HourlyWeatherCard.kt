import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.ui.theme.Composable.Blurrey
import com.example.weatherapplication.ui.theme.SecondryBlack
import com.example.weatherapplication.ui.theme.blurColor

@Composable
fun HourlyWeatherCard(
    Icon: Int,
    temper: String,
    hour: String
) {
    Box(
        modifier = Modifier
            .height(120.dp)
            .width(88.dp),
        contentAlignment = Alignment.TopCenter
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = SecondryBlack,
                    shape = RoundedCornerShape(20.dp)
                )
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(20.dp)
                )
        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Box(
                modifier = Modifier
                    .offset(y = -20.dp),
                contentAlignment = Alignment.Center
            ) {

                Blurrey(
                    size = 60.dp,
                    color = blurColor,
                )

                Image(
                    painter = painterResource(Icon),
                    contentDescription = null,
                    modifier = Modifier.size(58.dp)
                )
            }

            Text(
                text = temper,
                fontWeight = FontWeight(500),
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
            )

            Text(
                text = hour,
                fontWeight = FontWeight(400),
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
            )
        }
    }
}