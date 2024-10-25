package eu.tutorials.mywishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.tutorials.mywishlistapp.data.Wish
import eu.tutorials.mywishlistapp.data.PasswordManagerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PasswordViewModel(
    private val PasswordRepository: PasswordManagerRepository = Graph.wishRepository
):ViewModel() {

    var PasstitleState by mutableStateOf("")
    var PasswordDescriptionState by mutableStateOf("")



    fun onWishTitleChanged(newString:String){
        PasstitleState = newString
    }

    fun onWishDescriptionChanged(newString: String){
        PasswordDescriptionState = newString
    }

    lateinit var getAllPassword: Flow<List<Wish>>

    init {
        viewModelScope.launch {
            getAllPassword = PasswordRepository.getPassword()
        }
    }

    fun addWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            PasswordRepository.addPassword(password= wish)
        }
    }

    fun getAWishById(id:Long):Flow<Wish> {
        return PasswordRepository.getAPasswordById(id)
    }

    fun updateWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            PasswordRepository.updateAPassword(wish= wish)
        }
    }

    fun deletePassword(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            PasswordRepository.deleteAPassword(wish= wish)
            getAllPassword = PasswordRepository.getPassword()
        }
    }
}