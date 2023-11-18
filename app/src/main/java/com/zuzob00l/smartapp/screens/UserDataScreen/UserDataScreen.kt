package com.zuzob00l.smartapp.screens.UserDataScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.zuzob00l.smartapp.R
import com.zuzob00l.smartapp.firebaseAuth.presentation.UserData_ViewModel

/*@Composable
fun UserDataScreen(
    userData_viewModel: UserData_ViewModel = viewModel(),
    onBackClicked: () -> Unit = {})
{
    val getData = userData_viewModel.state.value

    BackArrow(onBackClicked = {/*TODO*/})
    DisplayUserPic(userProfilePic = getData.profilePicture)

    UserInfoCard(
        userName = getData.name,
        userSurname = getData.surname,
        userMemberShip = getData.membership,)
}

@Composable
fun BackArrow(onBackClicked: () -> Unit)
{
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically)
    {
        IconButton(onClick = { /*TODO*/ })
        {
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = Icons.Filled.ArrowBack,
                tint = Color.LightGray,
                contentDescription = "arrow_back")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun UserInfoCard(
    userName: String,
    userSurname: String,
    userMemberShip: String?)
{
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.4f),
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        color = Color.DarkGray)
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp, bottom = 20.dp, start = 16.dp),
            verticalArrangement = Arrangement.Top)
        {
            DataRow(userName, edit = true, onEditClicked = {/*TODO*/})
            CustomDivider()
            DataRow(userSurname, edit = true, onEditClicked = {/*TODO*/})
            CustomDivider()
            DataRow(userMemberShip, onEditClicked = {/*TODO*/})
        }
    }
}
@Composable
fun CustomDivider() {
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .alpha(0.7f),
        thickness = 1.dp,
        color = Color.LightGray)
}

@Composable
fun DataRow(
    text: String?,
    edit: Boolean = false,
    onEditClicked: () -> Unit)
{
    var text: String = text ?: "None"

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start)
    {
        Text(
            modifier = Modifier.weight(1f),
            text = text,
            fontSize = 20.sp,
            color = Color.LightGray)

        if(edit) {
            Row(
                modifier = Modifier.clickable {/*TODO*/},
                verticalAlignment = Alignment.CenterVertically)
            {
                Text(
                    text = stringResource(R.string.edytuj),
                    fontSize = 20.sp,
                    color = Color.LightGray)

                Icon(
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .size(20.dp),
                    imageVector = Icons.Filled.Edit,
                    tint = Color.LightGray,
                    contentDescription = stringResource(R.string.edit_icon))
            }
        }
    }
}

@Composable
fun DisplayUserPic(userProfilePic: String)
{

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        val borderWidth = 4.dp
        val borderColor =  com.zuzob00l.smartapp.ui.theme.YellowLight

        Image(
            modifier = Modifier
                .padding(vertical = 40.dp)
                .clip(CircleShape)
                .size(200.dp)
                .border(
                    BorderStroke(borderWidth, borderColor)
                ),
            painter = rememberAsyncImagePainter(model = userProfilePic),
            contentScale = ContentScale.Crop,
            contentDescription = "user_profile_pic")
    }
}
*///