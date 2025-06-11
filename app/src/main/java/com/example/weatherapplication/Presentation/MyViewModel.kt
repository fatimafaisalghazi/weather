import android.content.Context
import android.location.Geocoder
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.example.weatherapplication.Data.Module.LocationImpl
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MyViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    private val locationImpl by lazy {
        val fusedLocation = LocationServices.getFusedLocationProviderClient(appContext)
        val geocoder = Geocoder(appContext)
        LocationImpl(fusedLocation, geocoder)
    }

    fun getLocation(context: Context, lifecycleOwner: LifecycleOwner) {
        lifecycleScope.launch {
            val permissionStatus = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            )

            if (permissionStatus != PackageManager.PERMISSION_GRANTED) {
                _uiState.value = UiState.Error("Permission denied")
                return
            }

            val settingsClient = LocationServices.getSettingsClient(context)
            val locationSettings = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 1000).build()
            val builder = LocationSettingsRequest.Builder().addLocationRequest(locationSettings)

            settingsClient.checkLocationSettings(builder.build()).addOnSuccessListener {
                // ✅ الموقع مفعل
                launchAndObserveLocation()
            }.addOnFailureListener {
                // ❌ الموقع معطل
                _uiState.value = UiState.Error("Location disabled. Please enable it in settings.")
            }
        }
    }

    private suspend fun launchAndObserveLocation() {
        val result = locationImpl.getCurrentLocation()
        result.onSuccess { location ->
            val address = locationImpl.getAddressFromLocation(location)
            _uiState.value = UiState.Success(address)
        }.onFailure {
            _uiState.value = UiState.Error(it.localizedMessage ?: "Unknown error")
        }
    }
}