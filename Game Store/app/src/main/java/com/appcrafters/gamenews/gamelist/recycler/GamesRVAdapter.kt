package com.appcrafters.gamenews.gamelist.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.appcrafters.gamenews.R
import com.example.games.model.Game

class GamesRVAdapter(private val games: List<Game>, private val onItemClicked: (Int) -> Unit) :
    Adapter<GameRVViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = GameRVViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
    )

    override fun onBindViewHolder(holder: GameRVViewHolder, position: Int) {
        holder.bind(games[position], onItemClicked)
    }

    override fun getItemCount() = games.size
}