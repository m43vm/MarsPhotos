import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsphotos.marsphotos.ui.screens.MarsUiState
import kotlinx.coroutines.launch
import java.io.IOException

class MarsViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    /*var marsUiState: String by mutableStateOf("")
        private set*/
    var marsUiState: MarsUiState by mutableStateOf(MarsUiState.Loading)
        private set


    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getMarsPhotos()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [MutableList].
     */
    fun getMarsPhotos() {
        //marsUiState = "Set the Mars API status response here!"
        viewModelScope.launch {
            try {
                val listResult = MarsApi.retrofitService.getPhotos()
                //marsUiState = listResult
                marsUiState = MarsUiState.Success(listResult)
            } catch (e: IOException) {
                Log.v("TAG", "Excepcion de internet")
                Log.v("TAG", e.localizedMessage)
                marsUiState = MarsUiState.Error
            }
        }
    }
}