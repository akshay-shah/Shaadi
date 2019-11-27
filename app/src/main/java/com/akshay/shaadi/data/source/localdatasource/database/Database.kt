package com.akshay.shaadi.data.source.localdatasource.database

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

    @Query("SELECT * FROM user")
    suspend fun getAllUsers(): List<User>

    @Query("SELECT COUNT(*) from user")
    suspend fun countUsers(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(users: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllOrders(listUsers: List<User>)

    @Delete
    suspend fun delete(user: User)
}

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}