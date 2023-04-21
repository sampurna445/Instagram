package com.vipulasri.jetinstagram.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun HeadingsImage(imageUrl: String, weight: Modifier) {
    val shape = CircleShape
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color(0xFFA7A7A7),
                shape = shape
            )
    ) {
        Box(
            modifier = Modifier
                .size(66.dp)
                .padding(3.dp)
                .background(color = Color.LightGray, shape = shape)
                .clip(shape),

            ) {
            Image(
                painter = rememberImagePainter(imageUrl),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}
