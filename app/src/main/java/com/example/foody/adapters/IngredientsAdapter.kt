package com.example.foody.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.foody.R
import com.example.foody.models.ExtendedIngredient
import com.example.foody.util.Constants.Companion.BASE_IMAGE_URL
import com.example.foody.util.RecipesDiffUtil
import kotlinx.android.synthetic.main.ingredients_row_layout.view.*

class IngredientsAdapter : RecyclerView.Adapter<IngredientsAdapter.MyViewHolder>() {

    private var ingredientList = emptyList<ExtendedIngredient>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.ingredients_row_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return ingredientList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val ingredient = ingredientList[position]
        holder.itemView.apply {
            ingredient_imageView.load(BASE_IMAGE_URL + ingredient.image) {
                crossfade(600)
                error(R.drawable.ic_error_placeholder)
            }
            ingredient_name.text = ingredient.name.capitalize()
            ingredient_amount.text = ingredient.amount.toString()
            ingredient_unit.text = ingredient.unit
            ingredient_consistency.text = ingredient.consistency
            ingredient_original.text = ingredient.original
        }
    }

    fun setData(newIgredients: List<ExtendedIngredient>) {
        val ingredientsDiffUtil = RecipesDiffUtil(ingredientList, newIgredients)
        val result = DiffUtil.calculateDiff(ingredientsDiffUtil)
        ingredientList = newIgredients
        result.dispatchUpdatesTo(this)
    }

}