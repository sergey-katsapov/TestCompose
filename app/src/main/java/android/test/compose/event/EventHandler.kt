package android.test.compose.event

interface EventHandler<T> {
    fun onEvent(event: T)
}