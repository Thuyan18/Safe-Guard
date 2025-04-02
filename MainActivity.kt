package com.hungn.tracklocation2

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.hungn.tracklocation2.ui.theme.Tracklocation2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tracklocation2Theme {
                MapScreen()
            }
        }
    }

    // Chuyển hàm này vào MainActivity để có thể truy cập context
    fun bitmapDescriptorFromVector(vectorResId: Int): BitmapDescriptor {
        val vectorDrawable = ContextCompat.getDrawable(this, vectorResId)
        vectorDrawable?.setBounds(0, 0, vectorDrawable.intrinsicWidth, vectorDrawable.intrinsicHeight)
        val bitmap = Bitmap.createBitmap(
            vectorDrawable?.intrinsicWidth ?: 1,
            vectorDrawable?.intrinsicHeight ?: 1,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        vectorDrawable?.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }
}

@Composable
fun MainActivity.MapScreen() {
    val userLocation = LatLng(16.0544, 108.2022)
    val friends = listOf(
        Pair(LatLng(16.0604, 108.2202), R.drawable.friend1), // Bạn bè 1
        Pair(LatLng(16.0484, 108.2102), R.drawable.friend2)  // Bạn bè 2
    )

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(userLocation, 15f)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { cameraPositionState.move(CameraUpdateFactory.newLatLng(userLocation)) }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_gps),
                    contentDescription = "GPS"
                )
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState
            ) {
                // Marker của người dùng
                Marker(
                    state = MarkerState(position = userLocation),
                    title = "Vị trí của tôi",
                    icon = bitmapDescriptorFromVector(R.mipmap.my_avatar)
                )

                // Marker bạn bè
                friends.forEach { (location, iconRes) ->
                    Marker(
                        state = MarkerState(position = location),
                        title = "Bạn bè",
                        icon = bitmapDescriptorFromVector(iconRes)
                    )
                }
            }
        }
    }
}