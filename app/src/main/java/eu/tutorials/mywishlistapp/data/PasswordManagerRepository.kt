package eu.tutorials.mywishlistapp.data

import kotlinx.coroutines.flow.Flow


class PasswordManagerRepository(private val wishDao: WishDao) {

    suspend fun addPassword(password:Wish){
        wishDao.addPassword(password)
    }

    fun getPassword(): Flow<List<Wish>> = wishDao.getAllPassword()

    fun getAPasswordById(id:Long) :Flow<Wish> {
        return wishDao.flow(id)
    }

    suspend fun updateAPassword(wish:Wish){
        wishDao.updateAPassword(wish)
    }

    suspend fun deleteAPassword(wish: Wish){
        wishDao.deleteAPassword(wish)
    }

}