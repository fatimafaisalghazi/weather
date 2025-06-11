sealed class UiState {
    data object Loading : UiState()
    data class Success(val address: String) : UiState()
    data class Error(val message: String) : UiState()
}