package dao;

//import android.arch.persistence.room.*;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.facebookapplication.entity.Product;

import java.util.List;
@Dao
public interface ProductDao {
    @Insert
    void insert(Product product);

    @Update
    void update(Product product);

    @Query("DELETE FROM product WHERE id = :id")
    void delete(int id);

    @Query("SELECT * FROM product")
    List<Product> getAllProducts();
}
