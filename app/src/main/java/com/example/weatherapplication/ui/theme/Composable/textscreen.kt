import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.R

val fakeWeather = WeatherFake1(
    condition = Weather.Condition.Clear,
    temperature = Weather.Temperature(25, "°C")
)
val fakeCityName = "Amarah"
val fakeIsDay = true

sealed class Weather {
    data class Temperature(val value: Int, val unit: String)
    enum class Condition { Clear, Cloudy, Rain, Snow, Thunderstorm }
}
@Composable
fun CurrentWeatherHeaderold(
    modifier: Modifier = Modifier,
    isCollapsed: Boolean,
    cityName: String,
    weatherCondition: Weather.Condition,
    currentTemperature: Weather.Temperature,
    isDay: Boolean
) {
    val iconRes = when (weatherCondition) {
        Weather.Condition.Clear -> if (isDay) R.drawable.clearsky1 else R.drawable.clearsky
        Weather.Condition.Cloudy -> R.drawable.mainlyclear1
        Weather.Condition.Rain -> R.drawable.rainshowermoderate1
        Weather.Condition.Snow -> R.drawable.snowgrains
        Weather.Condition.Thunderstorm -> R.drawable.thunderstromwithheavyhail
    }

    Column(
        modifier = modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = cityName, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(if (isCollapsed) 80.dp else 120.dp)
        )
        Text(
            text = "${currentTemperature.value}${currentTemperature.unit}",
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = weatherCondition.name,
            fontSize = 16.sp
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun WeatherScreen() {

    val listState = rememberLazyListState()
    val isCollapsed by derivedStateOf {
        listState.firstVisibleItemIndex > 0 || listState.firstVisibleItemScrollOffset > 0
    }

    LazyColumn(state = listState) {
        item {
            CurrentWeatherHeaderold(
                isCollapsed = isCollapsed,
                cityName = fakeCityName,
                weatherCondition = fakeWeather.condition,
                currentTemperature = fakeWeather.temperature,
                isDay = fakeIsDay
            )
        }

        // Add more items here...
        items(20) {
            Text("Item $it", modifier = Modifier.padding(16.dp))
        }
    }
}
@Composable
fun LocationLabel(modifier: Modifier = Modifier, cityName: String) {
    Text(
        text = cityName,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}
@Composable
fun CurrentTemperatureIcon(
    modifier: Modifier = Modifier,
    size: Dp,
    isDay: Boolean,
    weatherCondition: Weather.Condition
) {
    val iconRes = when (weatherCondition) {
        Weather.Condition.Clear -> if (isDay) R.drawable.clearsky1 else R.drawable.clearsky
        Weather.Condition.Cloudy -> R.drawable.mainlyclear1
        Weather.Condition.Rain -> R.drawable.rainshowermoderate1
        Weather.Condition.Snow -> R.drawable.snowgrains
        Weather.Condition.Thunderstorm -> R.drawable.thunderstromwithheavyhail
    }

    Image(
        painter = painterResource(id = iconRes),
        contentDescription = null,
        modifier = modifier.size(size)
    )
}
@Composable
fun TemperatureInfoSection(
    modifier: Modifier = Modifier,
    temperature: Weather.Temperature,
    weatherCondition: Weather.Condition
) {
    Column(modifier = modifier) {
        Text(
            text = "${temperature.value}${temperature.unit}",
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = when (weatherCondition) {
                Weather.Condition.Clear -> "Clear Sky"
                Weather.Condition.Cloudy -> "Cloudy"
                Weather.Condition.Rain -> "Rain"
                Weather.Condition.Snow -> "Snow"
                Weather.Condition.Thunderstorm -> "Thunderstorm"
            },
            fontSize = 16.sp
        )
    }
}