package com.vipulasri.jetinstagram.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.vipulasri.jetinstagram.model.ProfileHeadings
import com.vipulasri.jetinstagram.model.ProfilePosts
import com.vipulasri.jetinstagram.model.headingsNames


object ProfileRepository {

    private val headings = mutableStateOf<List<ProfileHeadings>>(emptyList())
    private val posts = mutableStateOf<List<ProfilePosts>>(emptyList())

    private fun populateHeadings() {

        val _headings = ArrayList<ProfileHeadings>()

        (0..8).forEach { index ->
            val heading = ProfileHeadings(
                image = "https://source.unsplash.com/random/400x300?${index + 1}",
                name = headingsNames[index]
            )
            _headings.add(heading)
        }

        headings.value = _headings
    }

    init {
        populateHeadings()
    }

    fun observeHeadings(): MutableState<List<ProfileHeadings>> = headings

    private fun populatePosts() {

        val _posts = ArrayList<ProfilePosts>()

        (0..29).forEach { index ->
            val profilePost = ProfilePosts(
                image = "https://source.unsplash.com/random/400x300?${index + 1}",
            )
            _posts.add(profilePost)
        }

        posts.value = _posts
    }

    init {
        populatePosts()
    }

    fun observeProfilePosts(): MutableState<List<ProfilePosts>> = posts
}