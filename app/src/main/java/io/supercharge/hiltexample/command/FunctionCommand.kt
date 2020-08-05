package io.supercharge.hiltexample.io.supercharge.hiltexample.command

class FunctionCommand(
    private val function: () -> Unit
) : Command {

    override fun execute() {
        function.invoke()
    }
}
