package com.example.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 *
 * This custom dialog class displays a result message in a dialog box.
 * It allows the user to restart the game when they click the "Start Again".
 *
 * @author Paniz Peiravani
 * @version 1.0
 */

public class ResultDialog extends Dialog {

    // The message to be displayed in the dialog
    private final String message;

    // Reference to the main game activity for restarting the match
    private final MainActivity mainActivity;

    // Constructor for the ResultDialog class
    public ResultDialog(@NonNull Context context, String message, MainActivity mainActivity) {
        super(context);
        this.message = message;
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_dialog);

        // Initialize UI elements
        TextView messageText = findViewById(R.id.messageText);
        Button startAgainButton = findViewById(R.id.startAgainButton);

        // Set the message text in the dialog
        messageText.setText(message);

        // Set a click listener for the "Start Again" button
        startAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Restart the match in the main game activity
                mainActivity.restartMatch();

                // Dismiss the dialog
                dismiss();
            }
        });
    }
}