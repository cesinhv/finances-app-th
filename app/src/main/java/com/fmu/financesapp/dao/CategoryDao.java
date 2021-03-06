package com.fmu.financesapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.fmu.financesapp.model.Category;

import java.util.ArrayList;

public class CategoryDao extends SQLiteOpenHelper {

        private final static ArrayList<Category> categories = new ArrayList<>();
        private static int interableId = 0;
        private static final int VERSAO_BANCO = 1;
        private static final String BANCO_CLIENTE = "bd_projeto.db";
        private static final String TABELA = "Usuarios";

    public CategoryDao(Context context) {
        super(context, BANCO_CLIENTE,null, VERSAO_BANCO);
    }


    void addCategoria(Category account){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("nome", account.getName());

        db.insert(TABELA, null, values);
        db.close();
    }

    public void save(Category account){
        account.setId(interableId);
        categories.add(account);
        interableId++;
        addCategoria(account);
    }





    public void remove(Category category )
    {
        Category categoryFinded = searchCategory(category);
        if(categoryFinded != null){
            //findedCategory.getId(); ID PARA COLOCAR NO WHERE

            categories.remove(categoryFinded);
        }

    }

    public void edit(Category category) {

        Category findedCategory = searchCategory(category);
        if(findedCategory != null){
            //findedCategory.getId(); ID PARA COLOCAR NO WHERE

            int psCategory = categories.indexOf(findedCategory);
            categories.set(psCategory, category);
        }

    }

    private Category searchCategory(Category category) {
             Category findedCategory = null;
             for(Category c: categories){
                 if(c.getId() == category.getId()){
                     return c;
                 }
             }
             return findedCategory;
    }

    public ArrayList<Category> all(){ return new ArrayList<>(categories);}

    public Double userBudgetCateories(){
        Double value = 0.0;
                for (Category c: categories){
                    value += c.getBudget();
                }
        return value;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
