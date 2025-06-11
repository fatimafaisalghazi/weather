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