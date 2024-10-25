package eu.tutorials.mywishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addPassword(wishEntity: Wish)

    // Loads all wishes from the wish table
    @Query("Select * from `wish-table`")
    abstract fun getAllPassword(): Flow<List<Wish>>

    @Update
    abstract suspend fun updateAPassword(wishEntity: Wish)

    @Delete
    abstract suspend fun deleteAPassword(wishEntity: Wish)

    @Query("Select * from `wish-table` where id=:id")
    abstract fun flow(id:Long): Flow<Wish>


}