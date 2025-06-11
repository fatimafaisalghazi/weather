//
//@OptIn(ExperimentalPermissionsApi::class)
//@Composable
//fun LocationRequestScreen() {
//    val context = LocalContext.current
//    val fusedLocationClient = remember {
//        LocationServices.getFusedLocationProviderClient(context)
//    }
//
//    // إدارة الأذونات
//    val permissions = rememberMultiplePermissionsState(
//        listOf(
//            Manifest.permission.ACCESS_FINE_LOCATION,
//            Manifest.permission.ACCESS_COARSE_LOCATION
//        )
//    )ACCESS_COARSE_LOCATION
//
//    when (permissions.allPermissionsGranted) {
//        true -> {
//            // الأذونات ممنوحة، نحصل على الموقع
//            LaunchedEffect(Unit) {
//                fusedLocationClient.lastLocation
//                    .addOnSuccessListener { location ->
//                        if (location != null) {
//                            Log.d("MyLocation", "Latitude: ${location.latitude}, Longitude: ${location.longitude}")
//                        } else {
//                            Log.d("MyLocation", "Location is null")
//                        }
//                    }
//                    .addOnFailureListener { exception ->
//                        Log.e("MyLocation", "Failed to get location: ${exception.message}")
//                    }
//            }
//
//            Text(text = "Location requested. Check Logcat for result.")
//        }
//
//        false -> {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(16.dp),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                Text(text = "Location permission required.")
//                Spacer(modifier = Modifier.height(16.dp))
//                Button(onClick = {
//                    permissions.launchMultiplePermissionRequest()
//                }) {
//                    Text(text = "Request Location Permissions")
//                }
//            }
//        }
//    }
//}


//https://www.google.com/url?source=meet&sa=D&q=https%3A%2F%2Fapi.open-meteo.com%2Fv1%2Fforecast%3Flatitude%3D30.0626%26longitude%3D31.2497%26daily%3Dtemperature_2m_max%2Ctemperature_2m_min%2Cweather_code%2Cuv_index_max%26hourly%3Dtemperature_2m%2Cweather_code%2Cis_day%26current%3Dtemperature_2m%2Cwind_speed_10m%2Crelative_humidity_2m%2Crain%2Cweather_code%2Capparent_temperature%2Cpressure_msl%2Cis_day%2Cprecipitation&hl=en-US