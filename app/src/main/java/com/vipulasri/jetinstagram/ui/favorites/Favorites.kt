package com.vipulasri.jetinstagram.ui.favorites

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import com.vipulasri.jetinstagram.ui.components.icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.*
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.data.StoriesRepository
import com.vipulasri.jetinstagram.model.Story

import com.vipulasri.jetinstagram.ui.home.StoryImage

@Composable
fun Favorites(){
    val favorites by StoriesRepository.observeStories()
    Scaffold (
        topBar = { Toolbar()}
            ){
        val favorites by StoriesRepository.observeStories()
        Column {
            Divider()
            FavoritesInfo()
            Divider()
            SearchBar()
            LazyColumn (
                modifier = Modifier
                    .padding(top = 10.dp)
            ){
                itemsIndexed(favorites) { _, fav ->
                    StoriesSection(fav)
                }
            }
        }

    }

}

@Composable
fun Toolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            Icons.Default.Close,
            modifier = Modifier.icon(),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.favourites_title),
            fontWeight = FontWeight.Bold
        )
        Icon(
            Icons.Default.Add,
            modifier = Modifier.icon(),
            contentDescription = null
        )


    }
}
@Composable
fun FavoritesInfo(modifier: Modifier = Modifier){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(56.dp)
        .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(modifier = Modifier.weight(2f)){
            Text(
                text = stringResource(R.string.favInfoText)
            )

        }
    }
}
@Composable
fun SearchBar(
        modifier: Modifier = Modifier
    ) {
        TextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(
                     Icons.Default.Search,
                    contentDescription = null
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface
            ),
            placeholder = {
                Text(stringResource(R.string.placeholder_search))
            },
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp)
        )
}



@Composable
fun StoriesSection(story: Story) {
    Column {
        FavouriteView(story)
       // Spacer(modifier = Modifier.height(10.dp))
    }
}
@Composable
fun FavouriteView(
    fav: Story
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp, horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        StoryImage(
            imageUrl = fav.image,

        )
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(5.dp)
                .align(Alignment.Top)
                .weight(2f),
            horizontalAlignment = Alignment.Start
        ){
            Text(
                text = "${fav.name}",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${fav.name}"
            )
        }
        Button(
            onClick = {},
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = "Add"
            )
        }
    }
}