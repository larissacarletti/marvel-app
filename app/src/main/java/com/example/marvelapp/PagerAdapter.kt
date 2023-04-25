package com.example.marvelapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.marvelapp.data.model.Characters
import com.example.marvelapp.databinding.ListItemBinding

class PagerAdapter (private val viewPager2: ViewPager2) :
    RecyclerView.Adapter<PagerAdapter.PagerViewHolder>() {

    private val characterList = ArrayList<Characters>()
    private val runnable = Runnable {
        characterList.addAll(characterList)
        notifyDataSetChanged()
    }

    class PagerViewHolder(binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val characterPoster = binding.heroBanner
        val characterName = binding.heroName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PagerViewHolder(binding)
    }

    override fun getItemCount(): Int = characterList.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.run {
            Glide.with(characterPoster)
                .load("${characterList[position].path}/portrait_fantastic/${characterList[position].extension}")
                .into(characterPoster)

                characterName.text = characterList[position].name

            if(position == characterList.size-1) {
                viewPager2.post(runnable)
            }

        }
    }


}