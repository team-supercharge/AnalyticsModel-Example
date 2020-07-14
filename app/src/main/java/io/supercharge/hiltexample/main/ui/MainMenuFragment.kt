package io.supercharge.hiltexample.main.ui

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asFlow
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import io.supercharge.hiltexample.R
import io.supercharge.hiltexample.main.model.MainMenuViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class MainMenuFragment : Fragment() {

    private val viewModel: MainMenuViewModel by viewModels()

    @Inject
    lateinit var notificationManager: NotificationManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val textView = view.findViewById<TextView>(R.id.text)

        viewModel.textValue.asFlow()
            .onEach { text ->
                textView.text = text
                createNotification(text)
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)

        return view
    }

    private fun createNotification(text: String) {
        val channelId = "hilt"

        val builder = NotificationCompat.Builder(requireContext(), channelId)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(text)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel(channelId, text, NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(text.hashCode(), builder.build())
    }
}
