package com.akshay.shaadi.data.database

import androidx.lifecycle.LiveData
import androidx.room.*


@Entity(tableName = "User")
data class User(
    @PrimaryKey(autoGenerate = true) var uid: Int = 0,

    @ColumnInfo(name = "name") var name: String? = null,

    @ColumnInfo(name = "age") var age: Int = 0,

    @ColumnInfo(name = "image_url") var imageUrl: String? = null
)

@Dao
interface UserDao {

    @get:Query("SELECT * FROM user")
    val getAllUsers: LiveData<List<User>>

    @Query("SELECT COUNT(*) from user")
    fun countUsers(): Int

    @Insert
    fun insert(users: User)

    @Delete
    fun delete(user: User)
}

@Database(entities = [User::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}