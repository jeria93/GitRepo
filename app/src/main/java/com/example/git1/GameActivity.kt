package com.example.git1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.git1.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        binding.buttonHigher.setOnClickListener {
            val deck = createDeck()
            val randomCard = drawRandomCard(deck)
            val image = showCardImage1(randomCard)
            binding.randomCardImage.setImageResource(image)

        }

    }

    fun drawRandomCard(deck: List<Card>) : Card {
        return deck.random()
    }

    fun showCardImage1(card: Card) : Int {
        val resourceName = "card_${card.suit}_${card.value}"
        return resources.getIdentifier(resourceName, "drawable", packageName)

    }

    fun showCardImage(card: Card,context: Context): Int {
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