package com.vipulasri.jetinstagram.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.vipulasri.jetinstagram.model.ProfilePosts

@Composable
fun ProfilePostView(
    post: ProfilePosts
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(2.dp)
    ) {
        Image(
            painter = rememberImagePainter(post.image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}