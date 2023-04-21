package com.vipulasri.jetinstagram.ui.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
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
import com.vipulasri.jetinstagram.data.ProfileRepository
import com.vipulasri.jetinstagram.data.StoriesRepository
import com.vipulasri.jetinstagram.model.Story
import com.vipulasri.jetinstagram.ui.components.icon
import com.vipulasri.jetinstagram.ui.home.StoryImage

@Composable
fun Profile(){
    val profile by StoriesRepository.observeStories()
    //val highlights by ProfileRepository.observeHighlights()

    Scaffold(topBar = { Toolbar(profile[2])         }
            ) {
                 Column {
                     LazyColumn{
                         item {
                             PicInfo(profile[2])
                             Info(profile[2])
                             ButtonsRow()
                             HeadingsSection(profile)
                             PostsTypeSection()
                         }
                     }

                     ProfilePostsSection()

        }

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
            Text(text = "133", fontWeight = FontWeight.Bold)
            Text(text = "Posts")
        }
        Column()
        {
            Text(text = "2.2K", fontWeight = FontWeight.Bold)
            Text(text = "Followers")
        }
        Column()
        {
            Text(text = "3.5k", fontWeight = FontWeight.Bold)
            Text(text = "Following")
        }
    }

}
@Composable
fun ButtonsRow(
    modifier: Modifier = Modifier
){
    Row (
        modifier = Modifier
            .fillMaxHeight()
            .padding(vertical = 5.dp, horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Button(
            onClick = {},
            modifier = Modifier
                .weight(2.5f)
                .padding(start = 10.dp)
                .background(color = Color(0xFF00A7E9))
        ) {
            Text(
                text = "Follow"
            )
        }
        Button(
            onClick = {},
            modifier = Modifier
                .weight(2.5f)
                .padding(start = 10.dp)
                .background(color = Color(0xFFD1D1D1))
        ) {
            Text(
                text = "Message"
            )
        }
        IconButton(
            onClick = {},
            modifier = Modifier
                .weight(1f)
                .padding(end = 10.dp, start = 10.dp)
                .background(color = Color(0xFFD1D1D1))
        ) {
            Icon(imageVector = Icons.Default.Person , contentDescription = "")
        }
    }
}


@Composable
private fun HeadingsSection(profiles: List<Story>) {
    LazyRow {
        itemsIndexed(profiles) { index, profile ->

            if (index == 0) {
                Spacer(modifier = Modifier.width(6.dp))
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 5.dp, horizontal = 6.dp)
            ) {
                HeadingsImage(
                    imageUrl = profile.image, weight = Modifier
                        .weight(1f)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text("h$index", style = MaterialTheme.typography.caption)
            }

            if (index == profiles.size.minus(1)) {
                Spacer(modifier = Modifier.width(6.dp))
            }
        }
    }
}
@Composable
fun PostsTypeSection(
    modifier: Modifier = Modifier
){
    Row (
        modifier = Modifier
            .fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically
    ){
        IconButton(
            onClick = {},
            modifier = Modifier
                .weight(1f)
                .padding(end = 10.dp, start = 10.dp)
        ) {
            Icon(imageVector = Icons.Default.DateRange , contentDescription = "")
        }
        IconButton(
            onClick = {},
            modifier = Modifier
                .weight(1f)
                .padding(end = 10.dp, start = 10.dp)
        ) {
            Icon(imageVector = Icons.Default.Person , contentDescription = "")
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfilePostsSection(
    modifier: Modifier = Modifier
){
    val post by ProfileRepository.observeProfilePosts()
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier
    ){
        items(post.size){item->
            ProfilePostView(post.get(item))
        }
    }

}