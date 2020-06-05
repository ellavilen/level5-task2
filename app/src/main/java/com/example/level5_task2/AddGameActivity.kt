package com.example.level5_task2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception
import java.time.LocalDate
import kotlinx.android.synthetic.main.activity_add_game.*
import kotlinx.android.synthetic.main.content_add_game.*
import java.util.*

const val EXTRA_GAME ="EXTRA_GAME"

class AddGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_game)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Add game"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        fab.setOnClickListener{
            onSaveClick()
        }
    }

    private fun onSaveClick() {
        if (etTitle.text.toString().isNotBlank() &&
            etPlatform.text.toString().isNotBlank() &&
            etDay.text.toString().isNotBlank() &&
            etMonth.text.toString().isNotBlank() &&
            etYear.text.toString().isNotBlank()) {
            try {
                val cal = Calendar.getInstance()
                val year = etYear.text.toString().toInt()
                val month = etMonth.text.toString().toInt()
                val day = etDay.text.toString().toInt()
                if (month !in 1..12 || day !in 1..31) throw Exception()
                cal.set(year, month - 1, day)
                val game = Game(etTitle.text.toString(), etPlatform.text.toString(), cal.time)
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_GAME, game)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            } catch(e: Exception) {
                Toast.makeText(this, "Invalid date", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this,"The game cannot be empty"
                , Toast.LENGTH_SHORT).show()
        }
    }
    companion object {
        const val EXTRA_NOTE = "EXTRA_NOTE"
    }
}
