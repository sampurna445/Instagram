package com.vipulasri.jetinstagram.ui.newpost

import android.annotation.SuppressLint
import android.provider.Contacts
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.model.places
import java.util.*


@Composable
fun NewPost(){
Scaffold(topBar = { Toolbar()}
) {
    Column(modifier = Modifier.padding(all = 5.dp)) {

        CaptionSection()
        Divider()
        TagPeopleAddFundRaiser(title = "Tag People")
        Divider()
        AddLocation()
        Divider()
        TagPeopleAddFundRaiser(title = "Add Fund Raiser")
        Divider()
        AddMedia()
        Divider()
        TagPeopleAddFundRaiser(title = "Advanced Settings")

    }
}



}
@Composable
fun Toolbar(modifier:Modifier = Modifier) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray)
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
            text = stringResource(R.string.new_post).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.h5,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 18.dp)
                .padding(horizontal = 66.dp)

        )
        Text(
            text = "Share",
            style = MaterialTheme.typography.button,
            color = Color.Blue

        )


    }

}
@Composable
fun HyperLink() {
    val annotatedLinkString = buildAnnotatedString {
        val str = "Share"
        val startIndex = str.indexOf("link")
        val endIndex = startIndex + 4
        append(str)
        addStyle(
            style = SpanStyle(
                color = Color(0xff64B5F6),
                textDecoration = TextDecoration.Underline
            ), start = startIndex, end = endIndex
        )
    }
}

@Composable
fun CaptionSection(
    modifier: Modifier = Modifier
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier){
        Image(
            painter = painterResource(R.drawable.fc2_nature_meditations),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp, 150.dp)
                .padding(vertical = 10.dp)
        )}
        Column() {
            TextField(
                value = "",
                onValueChange = {},
                label = {Text("Write a caption")},
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface
                )

                )
        }
    }


}
@Composable
fun TagPeopleAddFundRaiser(
    @SuppressLint("SupportAnnotationUsage") @StringRes title: String,
    modifier:Modifier = Modifier){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(56.dp)
        .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically){
        Text(text = title)
        Icon(
            ImageVector.vectorResource(id = R.drawable.chevron_right),
            contentDescription = ""
        )
    }


}
@Composable
fun AddLocation(modifier:Modifier = Modifier){

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Add location",
                style = MaterialTheme.typography.h6.copy(fontSize = 16.sp),
                color = Color.Black
            )
            Icon(
                Icons.Default.KeyboardArrowRight,
                contentDescription = "My Drawable",
                modifier = Modifier.size(24.dp)
            )
        }
        LocationsRow()
}
@Composable
fun LocationsRow() {
    LazyRow(
        Modifier
            .padding(horizontal = 12.dp),
        contentPadding = PaddingValues(horizontal = 0.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(places) { place ->
            Card(
                elevation = 5.dp,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.padding(start = 4.dp, end = 4.dp, bottom = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = place,
                        style = MaterialTheme.typography.body1,
                        color = Color.Black,
                        modifier = Modifier.padding(
                            horizontal = 12.dp,
                            vertical = 5.dp
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun AddMedia(modifier:Modifier = Modifier){
    val mCheckedState = remember{ mutableStateOf(false)}
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .padding(vertical = 10.dp)
    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically)
        {
            Text("Facebook")
            Switch(checked = mCheckedState.value,
                enabled = false,
                onCheckedChange = {mCheckedState.value = it})
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically)
        {
            Text("Twitter")
            Switch(checked = mCheckedState.value,
                    enabled = false,
                    onCheckedChange = {mCheckedState.value = it})
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically)
        {
            Text("Thumbir")
            Switch(checked = mCheckedState.value,
                    enabled = false,
                onCheckedChange = {mCheckedState.value = it})
        }

    }


}