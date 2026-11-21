package com.example.mysports.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SportsBaseball
import androidx.compose.material.icons.filled.SportsBasketball
import androidx.compose.material.icons.filled.SportsGolf
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material.icons.filled.SportsTennis
import androidx.compose.material.icons.filled.SportsVolleyball
import androidx.compose.ui.graphics.vector.ImageVector

data class Sport(
    val id: String,
    val name: String,
    val category: String,
    val icon: ImageVector,
    val description: String,
    val history: String,
    val rules: String,
    val popularLeagues: List<String>,
    val playersCount: String
)

object SportRepository {
    val sportsList = listOf(
        Sport(
            id = "soccer",
            name = "Soccer / Football",
            category = "Team Sports",
            icon = Icons.Default.SportsSoccer,
            description = "The world's most popular sport, played between two teams of 11 players with a spherical ball on a rectangular field.",
            history = "Modern football originated in England in the 19th century. The Football Association was founded in 1863, establishing the standardized rules used today.",
            rules = "Matches consist of two 45-minute halves. Players (except goalkeepers) cannot use hands or arms. The goal is to kick or head the ball into the opponent's net.",
            popularLeagues = listOf("FIFA World Cup", "UEFA Champions League", "Premier League", "La Liga", "MLS"),
            playersCount = "11 players per team"
        ),
        Sport(
            id = "basketball",
            name = "Basketball",
            category = "Team Sports",
            icon = Icons.Default.SportsBasketball,
            description = "A fast-paced court game where two teams score points by shooting a ball through an elevated hoop.",
            history = "Invented in 1891 by Canadian physical education instructor Dr. James Naismith in Springfield, Massachusetts, as an indoor winter sport.",
            rules = "Played over four quarters (10-12 minutes each). Field goals count for 2 or 3 points, free throws count for 1 point. Players advance by dribbling or passing.",
            popularLeagues = listOf("NBA", "EuroLeague", "FIBA World Cup", "NCAA March Madness"),
            playersCount = "5 players per team"
        ),
        Sport(
            id = "tennis",
            name = "Tennis",
            category = "Racket Sports",
            icon = Icons.Default.SportsTennis,
            description = "A precision racket sport played individually against a single opponent (singles) or between two teams of two (doubles).",
            history = "Evolved from real tennis in England during the late 19th century. The inaugural Wimbledon Championship was held in 1877.",
            rules = "Scoring follows 15, 30, 40, Game. Sets are won by getting to 6 games with a 2-game margin. Matches are best of 3 or 5 sets.",
            popularLeagues = listOf("Wimbledon", "US Open", "French Open (Roland Garros)", "Australian Open", "ATP / WTA Tour"),
            playersCount = "1 vs 1 or 2 vs 2"
        ),
        Sport(
            id = "baseball",
            name = "Baseball",
            category = "Bat & Ball",
            icon = Icons.Default.SportsBaseball,
            description = "A bat-and-ball sport where teams alternate between batting to score runs and fielding to record outs.",
            history = "Evolved in the United States from older bat-and-ball games like rounders in the mid-19th century.",
            rules = "Games consist of 9 innings. The batter tries to hit the thrown ball and run around four bases to score a run. Three outs end half an inning.",
            popularLeagues = listOf("MLB (Major League Baseball)", "NPB (Japan)", "KBO League", "World Baseball Classic"),
            playersCount = "9 players per team"
        ),
        Sport(
            id = "volleyball",
            name = "Volleyball",
            category = "Team Sports",
            icon = Icons.Default.SportsVolleyball,
            description = "A dynamic net game where two teams hit a ball back and forth over a high net trying to ground it on the opponent's side.",
            history = "Invented in 1895 by William G. Morgan in Holyoke, Massachusetts, originally called 'Mintonette'.",
            rules = "Matches are best-of-5 sets to 25 points (15 in final set). Teams have up to 3 touches to return the ball over the net without letting it touch the ground.",
            popularLeagues = listOf("FIVB World Championship", "Olympic Volleyball", "CEV Champions League", "Nations League"),
            playersCount = "6 players per team"
        ),
        Sport(
            id = "golf",
            name = "Golf",
            category = "Precision",
            icon = Icons.Default.SportsGolf,
            description = "A precision sport where players stroke balls into a series of holes on a course using as few strokes as possible.",
            history = "Modern golf originated in Scotland during the 15th century. The Old Course at St Andrews is considered the birthplace of golf.",
            rules = "Standard rounds consist of 18 holes. Stroke play counts total strokes; match play counts holes won. Lowest total score wins.",
            popularLeagues = listOf("The Masters", "PGA Tour", "The Open Championship", "US Open", "LIV Golf"),
            playersCount = "Individual or Pairs"
        )
    )

    fun getSportById(id: String): Sport? {
        return sportsList.find { it.id == id }
    }
}
