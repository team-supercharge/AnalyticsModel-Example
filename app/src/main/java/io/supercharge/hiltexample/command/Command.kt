package io.supercharge.hiltexample.io.supercharge.hiltexample.command

import kotlinx.coroutines.flow.Flow

interface Command {

    fun execute()

    fun getExecutedEvents(): Flow<Any>
}
