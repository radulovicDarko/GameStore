package com.example.games.model

object MockDataProvider {

    fun getGamesList(): List<Game> {
        val games = mutableListOf<Game>()

        for (i in 1..20) {
            val game = Game(
                i,
                "Dauntless",
                "https://www.freetogame.com/g/1/thumbnail.jpg",
                "A free-to-play, co-op action RPG with gameplay similar to Monster Hunter.",
                "https://www.freetogame.com/open/dauntless",
                "MMORPG",
                "PC (Windows)",
                "Phoenix Labs",
                "Phoenix Labs, Iron Galaxy",
                "2019-05-21",
                "https://www.freetogame.com/dauntless"
            )
            games.add(game)
        }
        return games
    }

    fun getGameDetails() = Game(
        1,
        "Dauntless",
        "https://www.freetogame.com/g/1/thumbnail.jpg",
        "A free-to-play, co-op action RPG with gameplay similar to Monster Hunter.",
        "https://www.freetogame.com/open/dauntless",
        "MMORPG",
        "PC (Windows)",
        "Phoenix Labs",
        "Phoenix Labs, Iron Galaxy",
        "2019-05-21",
        "https://www.freetogame.com/dauntless"
    )

    fun getRandomIndexes(length: Int): MutableList<Int> {
        val indexes: MutableList<Int> = mutableListOf()

        val numOfReviews: Int = (1 until length).random()

        for (i in 0 until numOfReviews) {
            var num: Int

            do {
                num = (0 until length).random()
            } while (indexes.contains(num))

            indexes.add(num)
        }

        return indexes
    }

    fun getGameReviews(): MutableList<Review> {
        val reviews: MutableList<Review> = mutableListOf()

        reviews.add(
            Review(
                "Brandon Gill",
                "https://images.unsplash.com/photo-1534030347209-467a5b0ad3e6?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80",
                4,
                "20.02.2021.",
                "It's a good game like the guns and ammo because it's based on real gun and ammo but what I dont like is that the sandbox or for say practice mode the vehicles when you get in one eather some one pops my tires or blows up my car and when you get stuck in the middle of the tunnel with the car is so irritating and cant get out and have to get out the car and leave it there and walk or run up it just to get out. So can you please fix this.",
            )
        )

        reviews.add(
            Review(
                "Ashton Perry",
                "https://images.unsplash.com/photo-1540569014015-19a7be504e3a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=735&q=80",
                3,
                "22.03.2021.",
                "Love this game. BUT. stop taking down portions of the game like metro royale so we will play your new game modes. That's annoying. The increase in cheating and aimbotters in this game is killing it for people who actually play the game. Ruined my perfect streak today because I got shot immediately when I landed games dead."
            )
        )

        reviews.add(
            Review(
                "Ethan Poole",
                "https://images.unsplash.com/photo-1474313438662-85ce389c174a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80",
                5,
                "05.04.2021.",
                "My friends told me that it is an good game so I am downloading this game",
            )
        )

        reviews.add(
            Review(
                "Zachary Khan",
                "https://images.unsplash.com/photo-1461800919507-79b16743b257?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80",
                5,
                "17.04.2021.",
                "nice game.. all the way nice experience☺️☺️",
            )
        )

        reviews.add(
            Review(
                "Theo Harrison",
                "https://images.unsplash.com/photo-1523419409543-a5e549c1faa8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=697&q=80",
                1,
                "29.04.2021.",
                "I used to enjoy the game not any more full of hackers when i report them always i get a message that you didnt find any thing wrong the game is full of them i cant even play plus since your last update the game is very choppy i hit players with 40 bullets they never die! I get hit once boom iam down i dont feel the game is fair anymore need alotttt of improvements",
            )
        )

        reviews.add(
            Review(
                "Megan Richards",
                "https://images.unsplash.com/photo-1520423465871-0866049020b7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80",
                5,
                "08.05.2021.",
                "Love it. It's a blast. Like tons of maps with different game play. Themed or not, cheer park or Metro, payload or against AI teams and way more. Have a slight picture glitch here and there but I'm on a pixel without the best network so no biggie. Don't get rid of Metro.",
            )
        )

        reviews.add(
            Review(
                "Adele Craft",
                "https://images.unsplash.com/photo-1544005313-94ddf0286df2?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=688&q=80",
                4,
                "11.06.2021.",
                "I'm only giving it a four because because there are so many different kinds of currency and different stores and a lot of confusing stuff where Idk how to spend them, if they organized the store more so it seems organized and easy to learn I would be completely fine with giving it a 5 star because it's a really fun game to play and I love how they don't really use fake guns and fake ammo.",
            )
        )

        reviews.add(
            Review(
                "Millie Turner",
                "https://images.unsplash.com/photo-1516195851888-6f1a981a862e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=705&q=80",
                3,
                "30.09.2021.",
                "Great game maybe like the glitch when u land on the island and u land on the ledge and it glitches u off and also the no sound glitch in tdm all those need to be fixed but overall great game the season pass skins they haven't been great u guys can do better and bring runic power back in the point system but after all that I'd say it's the number 1 game I've ever played",
            )
        )

        val indexes: MutableList<Int> = getRandomIndexes(reviews.size)

        val listToReturn: MutableList<Review> = mutableListOf()

        indexes.forEach {
            listToReturn.add(reviews[it])
        }

        return listToReturn
    }
}