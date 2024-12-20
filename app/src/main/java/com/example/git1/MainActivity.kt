package com.example.git1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.git1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnStartGame.setOnClickListener {

            val intent = Intent(this,GameActivity::class.java)
            startActivity(intent)

//            finish() -> quits the app

        }




    }

    fun showCardImage1(card: Card) : Int {
        val resourceName = "card_${card.suit}_${card.value}"
        return resources.getIdentifier(resourceName, "drawable", packageName)

    }

    fun showCardImage(card: Card,context: Context ): Int {
        val resourceName = "card_${card.suit}_${card.value}"
        return context.resources.getIdentifier(resourceName, "drawable", context.packageName)
    }

//    Creates the deck
    fun createDeck() : MutableList<Card> {

//        Define the 4 suits of the deck
        val suits = listOf("heart", "spade", "diamond", "club")
//    Define the card values in deck (ace = 1, king = 13)
        val values = (1..13)

//    Add an empty list that represents the deck
        val deck = mutableListOf<Card>()

//    Add all the cards by combining the suits and the values
        for (suit in suits ) {
            for (value in values) {
//                Creates a fresh new card with a suits and value
                deck.add(Card(suit, value))
            }
        }
//    Shuffle the deck
        deck.shuffle()

//    Return the complete new deck for later usage ->
        return deck

    }


}

//TODO
// Compare deck/card with each-other for values, is card 1 bigger than 2 etc
// Create function that separates the image resource from its map,
// Create function that guesses if the card is either higher or lower
// Declare variables for tracking score, tracking deck, showingCard? (current card that you se/that you have in front of you tex. card-diamond-2)
// Create function that handles the images for tracking/comparing
// Create function that updates the UI/Game-play?, if guessing right = score +1
// Use binding for less code
// -----------------------------------------------------------------------------------
// Create function that finds respective card image with respective card value, for instance = card_club_1
// (combine resource material with function/code -> google it, its possible),
// needs to return a value for later comparison if card 1 > card 2, cards are set as in Int in ImageViews
// this way you COULD / be able to extract the images in resource file/package "drawable"
// needs to match exactly this the format card_heart_13
// When game activity starts -> first card that shows up, needs to be set with a value, else no point
