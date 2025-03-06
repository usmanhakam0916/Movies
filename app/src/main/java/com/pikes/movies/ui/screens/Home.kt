package com.pikes.movies.ui.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.pikes.movies.R
import com.pikes.movies.ui.theme.MoviesTheme
import com.pikes.movies.ui.viewmodel.MoviesViewModel

@Composable
fun HomeScreen(
    moviesViewModel: MoviesViewModel,
    modifier: Modifier = Modifier,
) {
    val movies by moviesViewModel.moviesUiState.collectAsState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TrendingMoviesCarousel()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrendingMoviesCarousel(
    modifier: Modifier = Modifier
) {
    val items = listOf(
        R.drawable.movie, R.drawable.movie, R.drawable.movie, R.drawable.movie, R.drawable.movie
    )

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp  // Get screen width

    HorizontalMultiBrowseCarousel(
        state = rememberCarouselState { items.count() },
        modifier = modifier
            .width(412.dp)
            .height(221.dp),
        preferredItemWidth = screenWidth,
        itemSpacing = 16.dp,
        contentPadding = PaddingValues(16.dp)
    ) { i ->
        val item = items[i]
        Image(
            modifier = Modifier
                .height(205.dp)
                .maskClip(MaterialTheme.shapes.extraLarge),
            painter = painterResource(item),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}


@Composable
fun MoviesCategoryTitle(
    @StringRes text: Int, modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = stringResource(text),
        style = MaterialTheme.typography.headlineMedium
    )
}

@Composable
fun MoviesBannerCard(
    imageUrl: String, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(12.dp)
            .width(150.dp)
            .height(200.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp, pressedElevation = 8.dp
        )
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://image.tmdb.org/t/p/w500${imageUrl}").crossfade(true).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun MoviesRow(
    bannerUrlList: List<String>, modifier: Modifier = Modifier
) {
    LazyRow(modifier = modifier) {
        items(bannerUrlList) { bannerUrl ->
            MoviesBannerCard(imageUrl = bannerUrl)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MoviesTheme {

    }
}