package com.vipulasri.jetinstagram.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.data.StoriesRepository
import com.vipulasri.jetinstagram.model.Story
import com.vipulasri.jetinstagram.ui.components.icon
import com.vipulasri.jetinstagram.ui.home.StoryImage

@Composable
fun Profile(){
    val profile by StoriesRepository.observeStories()
    Column {
        Toolbar(profile[2])
        PicInfo(profile[2])
        Info(profile[2])

    }

}

@Composable
fun Info(profile: Story) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Column() {
            Text(text = profile.name, fontWeight = FontWeight.Bold, color = Color.Blue)
            Text(text = "Marketing Lead", fontWeight = FontWeight.Bold, color = Color.Black)
            Text(text = "Travelling,Watching Football,Gardening,Running and more......")
            
        }
    }
    

}

@Composable
fun Toolbar(profile: Story) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            ImageVector.vectorResource(id = R.drawable.backarrow),
            contentDescription = ""
        )
        Text(
            text = profile.name,
            fontWeight = FontWeight.Bold
        )
        Icon(
            ImageVector.vectorResource(id = R.drawable.three_dots),
            contentDescription = ""
        )


    }
}
@Composable
fun PicInfo(profile:Story){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically)
    {
        StoryImage(
            imageUrl = profile.image,

            )
        Column()
        {
            Text(text = "1332", fontWeight = FontWeight.Bold)
            Text(text = "Posts")
        }
        Column()
        {
            Text(text = "211332", fontWeight = FontWeight.Bold)
            Text(text = "Followers")
        }
        Column()
        {
            Text(text = "21332", fontWeight = FontWeight.Bold)
            Text(text = "Following")
        }
    }

}