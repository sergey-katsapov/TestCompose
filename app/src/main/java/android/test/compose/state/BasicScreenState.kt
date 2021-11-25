package android.test.compose.state

/**
 * Screen state with common variables for all screen states
 */
abstract class BasicScreenState {
    abstract var areMainViewsVisible: Boolean
    open var isLoading: Boolean = false
}