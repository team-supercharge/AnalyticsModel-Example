package io.supercharge.hiltexample.io.supercharge.hiltexample.command

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("command")
fun View.bindCommandToButton(command: Command?) {
    setOnClickListener {
        command?.execute()
    }
}
