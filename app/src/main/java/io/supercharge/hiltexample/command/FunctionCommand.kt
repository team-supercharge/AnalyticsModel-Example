package io.supercharge.hiltexample.io.supercharge.hiltexample.command

import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

class FunctionCommand(
    private val function: () -> Unit
) : Command {
    private val eventChannel = BroadcastChannel<Any>(Channel.BUFFERED)

    override fun execute() {
        function.invoke()
        eventChannel.offer(Any())
    }

    override fun getExecutedEvents(): Flow<Any> {
        return eventChannel.asFlow()
    }
}
