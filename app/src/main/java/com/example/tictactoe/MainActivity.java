package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tictactoe.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * This class defines the logic for a Tic-Tac-Toe game.
 * It manages winning combinations, player turns, and game results.
 *
 * @author Paniz Peiravani
 * @version 1.0
 */

public class MainActivity extends AppCompatActivity {

    // Binding to the layout elements in the XML layout file
    ActivityMainBinding binding;
    private final List<int[]> combinationList = new ArrayList<>();

    private int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int playerTurn = 1;
    private int totalSelectedBoxes = 1;

    /**
     * Initialize the game board and UI elements.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Define winning combinations (rows, columns, diagonals)
        combinationList.add(new int[]{0, 1, 2});
        combinationList.add(new int[]{3, 4, 5});
        combinationList.add(new int[]{6, 7, 8});
        combinationList.add(new int[]{0, 3, 6});
        combinationList.add(new int[]{1, 4, 7});
        combinationList.add(new int[]{2, 5, 8});
        combinationList.add(new int[]{2, 4, 6});
        combinationList.add(new int[]{0, 4, 8});

        // Get player names from intent
        String getPlayerOneName = getIntent().getStringExtra("playerOne");
        String getPlayerTwoName = getIntent().getStringExtra("playerTwo");

        // Set player names in the UI
        binding.playerOneName.setText(getPlayerOneName);
        binding.playerTwoName.setText(getPlayerTwoName);

        // Set click listeners for each grid box
        // Each listener handles a specific box
        binding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxSelectable(0)) {
                    performAction((ImageView) view, 0);
                }
            }
        });

        // Set click listeners for each grid box
        // Each listener handles a specific box
        binding.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxSelectable(1)) {
                    performAction((ImageView) view, 1);
                }
            }
        });

        // Set click listeners for each grid box
        // Each listener handles a specific box
        binding.image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxSelectable(2)) {
                    performAction((ImageView) view, 2);
                }
            }
        });

        // Set click listeners for each grid box
        // Each listener handles a specific box
        binding.image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxSelectable(3)) {
                    performAction((ImageView) view, 3);
                }
            }
        });

        // Set click listeners for each grid box
        // Each listener handles a specific box
        binding.image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxSelectable(4)) {
                    performAction((ImageView) view, 4);
                }
            }
        });

        // Set click listeners for each grid box
        // Each listener handles a specific box
        binding.image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxSelectable(5)) {
                    performAction((ImageView) view, 5);
                }
            }
        });

        // Set click listeners for each grid box
        // Each listener handles a specific box
        binding.image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxSelectable(6)) {
                    performAction((ImageView) view, 6);
                }
            }
        });

        // Set click listeners for each grid box
        // Each listener handles a specific box
        binding.image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxSelectable(7)) {
                    performAction((ImageView) view, 7);
                }
            }
        });

        // Set click listeners for each grid box
        // Each listener handles a specific box
        binding.image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBoxSelectable(8)) {
                    performAction((ImageView) view, 8);
                }
            }
        });
    }

    // Handle the logic when a player clicks on a grid box
    private void performAction(ImageView imageView, int selectedBoxPosition) {

        // Logic for player's move and game state
        boxPositions[selectedBoxPosition] = playerTurn;

        if (playerTurn == 1) {
            imageView.setImageResource(R.drawable.ximage);

            // Check if Player 1 has won or if the game is a draw
            if (checkResults()) {

                // Player has won, show victory dialog
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, binding.playerOneName.getText().toString()
                        + " is a Winner!", MainActivity.this);

                resultDialog.setCancelable(false);
                resultDialog.show();

            //if it's match
            } else if (totalSelectedBoxes == 9) {

                // It's a draw, show draw dialog
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, "Match Draw", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();


            } else {

                // Switch to the other player's turn
                changePlayerTurn(2);
                totalSelectedBoxes++;
            }
        } else {

            // Player 2's turn
            imageView.setImageResource(R.drawable.oimage);

            // Check if Player 2 has won or if the game is a draw
            if (checkResults()) {

                // Display a dialog for Player 2's victory
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, binding.playerTwoName.getText().toString()
                        + " is a Winner!", MainActivity.this);

                resultDialog.setCancelable(false);
                resultDialog.show();

            //if it's a match drew
            } else if (totalSelectedBoxes == 9) {

                // Display a dialog for a draw
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, "Match Draw", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();

            } else {

                // Switch to Player 1's turn
                changePlayerTurn(1);
                totalSelectedBoxes++;
            }
        }
    }

    // Change the current player's turn and update UI accordingly
    private void changePlayerTurn(int currentPlayerTurn) {

        // Switch player turn and update UI
        playerTurn = currentPlayerTurn;

        // Update UI to indicate the current player's turn
        if (playerTurn == 1) {

            // Highlight Player 1's turn
            binding.playerOneLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerTwoLayout.setBackgroundResource(R.drawable.white_box);

        } else {

            // Highlight Player 2's turn
            binding.playerTwoLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerOneLayout.setBackgroundResource(R.drawable.white_box);
        }
    }

    // Check if the current player has won the game
    private boolean checkResults() {

        // Check for winning combinations
        boolean response = false;

        for (int i = 0; i < combinationList.size(); i++) {
            final int[] combination = combinationList.get(i);

            // Check if the current player has formed a winning combination
            if (boxPositions[combination[0]] == playerTurn && boxPositions[combination[1]] == playerTurn &&
                    boxPositions[combination[2]] == playerTurn) {
                response = true;
            }
        }
        return response;
    }

    // Check if a box is empty - has not been selected
    private boolean isBoxSelectable(int boxPosition) {
        boolean response = false;

        // Check if the box is not already occupied
        if (boxPositions[boxPosition] == 0) {
            response = true;
        }
        return response;
    }

    // Reset the game when a new match is started
    public void restartMatch() {

        boxPositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        playerTurn = 1;
        totalSelectedBoxes = 1;

        // Reset UI for all grid boxes
        // (Set them back to initial state)
        binding.image1.setImageResource(R.drawable.white_box);
        binding.image2.setImageResource(R.drawable.white_box);
        binding.image3.setImageResource(R.drawable.white_box);
        binding.image4.setImageResource(R.drawable.white_box);
        binding.image5.setImageResource(R.drawable.white_box);
        binding.image6.setImageResource(R.drawable.white_box);
        binding.image7.setImageResource(R.drawable.white_box);
        binding.image8.setImageResource(R.drawable.white_box);
        binding.image9.setImageResource(R.drawable.white_box);
    }
}
