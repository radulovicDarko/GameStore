package com.appcrafters.gamenews.gamelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.appcrafters.gamenews.R
import com.appcrafters.gamenews.base.ICoordinator
import com.appcrafters.gamenews.base.data.ApiServiceProvider
import com.appcrafters.gamenews.base.data.GamesDataSource
import com.appcrafters.gamenews.base.functional.ViewModelFactoryUtil
import com.appcrafters.gamenews.gamelist.recycler.GamesRVAdapter
import com.appcrafters.gamenews.gamelist.viewmodel.GameListViewModel
import com.example.games.model.Game
import kotlinx.android.synthetic.main.fragment_game_list.*

class GameListFragment : Fragment() {

    lateinit var viewModel: GameListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, ViewModelFactoryUtil.viewModelFactory {
            GameListViewModel(GamesDataSource(ApiServiceProvider.gamesApiService))
        }).get(GameListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindFromViewModel()
        viewModel.getGames()
    }

    private fun setUpRecyclerView(games: List<Game>) {
        gameListRV.adapter = GamesRVAdapter(games) { id ->
            (activity as ICoordinator).showDetailsFragment(id)
        }
    }

    private fun bindFromViewModel() {
        viewModel.state.observe(viewLifecycleOwner) { state ->

            gameListProgressBar.isVisible = state is GameListViewState.Proccessing

            when (state) {
                is GameListViewState.DataReceived -> { setUpRecyclerView(state.games) }
                is GameListViewState.ErrorReceived -> showError(state.message)
            }

        }
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}