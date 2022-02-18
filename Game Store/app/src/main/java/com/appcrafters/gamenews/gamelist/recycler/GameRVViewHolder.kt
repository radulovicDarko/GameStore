package com.appcrafters.gamenews.gamelist.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.games.model.Game
import kotlinx.android.synthetic.main.item_game.view.*;

class GameRVViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(game: Game, onItemClicked: (Int) -> Unit) {
        itemView.gameNameTxt.text = game.title
        itemView.gameDescriptionTxt.text = game.short_description
        Glide.with(itemView).load(game.thumbnail).into(itemView.gameImg)

        itemView.setOnClickListener {
            onItemClicked.invoke(game.id)
        }
    }
}