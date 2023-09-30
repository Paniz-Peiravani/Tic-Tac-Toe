package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 *
 * This activity allows users to input the names of two players before starting a Tic-Tac-Toe game.
 * It captures the names and passes them to the main game activity MainActivity.java.
 *
 * @author Paniz Peiravani
 * @version 1.0
 */

public class AddPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        // Initialize UI elements
        EditText playerOne = findViewById(R.id.playerOne);
        EditText playerTwo = findViewById(R.id.playerTwo);
        Button startGameButton = findViewById(R.id.startGameBottom);

        // Set a click listener for the "Start Game" button
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get player names from EditText fields
                String getPlayerOneName = playerOne.getText().toString();
                String getPlayerTwoName = playerTwo.getText().toString();

                // Check if either player name is empty
                if (getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()) {

                    // Display a toast message if player names are not provided
                    Toast.makeText(AddPlayers.this, "Please enter player name", Toast.LENGTH_SHORT).show();
                } else {

                    // Create an intent to start the main game activity
                    Intent intent = new Intent(AddPlayers.this, MainActivity.class);

                    // Pass player names as extras to the main game activity
                    intent.putExtra("playerOne", getPlayerOneName);
                    intent.putExtra("playerTwo", getPlayerTwoName);

                    // Start the main game activity
                    startActivity(intent);
                }


            }

        });
    }
}