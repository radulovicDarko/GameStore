package com.appcrafters.gamenews.gamedetails.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.appcrafters.gamenews.R
import com.appcrafters.gamenews.base.data.ApiServiceProvider
import com.appcrafters.gamenews.base.data.GamesDataSource
import com.appcrafters.gamenews.base.functional.ViewModelFactoryUtil
import com.appcrafters.gamenews.gamedetails.viewmodel.GameDetailsViewModel
import com.bumptech.glide.Glide
import com.example.games.model.GameDetails
import com.example.games.model.MockDataProvider
import com.example.games.model.Review
import kotlinx.android.synthetic.main.fragment_game_details.*

class GameDetailsFragment : Fragment() {

    var gameId: Int = -1
    private lateinit var _viewModel: GameDetailsViewModel

    companion object {

        private const val GAME_ID_KEY = "GAME_ID"

        fun newInstance(gameId: Int): GameDetailsFragment {

            return GameDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(GAME_ID_KEY, gameId)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gameId = arguments?.getInt(GAME_ID_KEY) ?: -1
        _viewModel = ViewModelProvider(this, ViewModelFactoryUtil.viewModelFactory {
            GameDetailsViewModel(GamesDataSource(ApiServiceProvider.gamesApiService))
        }).get(GameDetailsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindFromViewModel()
        _viewModel.getGameById(gameId)
    }

    private fun bindFromViewModel() {
        _viewModel.state.observe(viewLifecycleOwner) { state ->

            gameDetailsProgressBar.isVisible = state is GameDetailsViewState.Proccessing

            when (state) {
                is GameDetailsViewState.DataReceived -> {
                    setUpView(state.game)
                }
                is GameDetailsViewState.ErrorReceived -> {
                    showError(state.message)
                }
            }
        }
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    fun bindScreenshot(game: GameDetails) {
        game.screenshots.forEach { screenshot ->
            val view = ScreenshotView(requireContext())
            view.bind(screenshot.image)
            screenshotsLayout.addView(view)

        }
    }

    fun bindReviews(reviews: List<Review>) {
        reviews.forEach { review ->
            val view = ReviewView(requireContext())
            view.bind(review)
            reviewsLayout.addView(view)
        }
    }

    private fun setUpView(game: GameDetails) {
        gameDetailsNameTxt.text = game.title
        Glide.with(this).load(game.thumbnail).into(this.logo)
        gameDetailsNameTxt.text = game.title + ":"
        gameDetailsPublisherTxt.text = game.publisher
        gameDetailsAboutTextTxt.text = game.short_description
        gameDetailsDescription.setContent(game.description)

        bindScreenshot(game)
        bindReviews(MockDataProvider.getGameReviews())

        for (i in 5 downTo 1) {
            val view = RatingView(requireContext())
            view.bind(i,5,20)
            ratingLayout.addView(view)
        }
    }
}