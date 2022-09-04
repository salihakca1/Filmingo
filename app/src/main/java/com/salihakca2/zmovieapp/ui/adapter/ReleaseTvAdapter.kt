package com.salihakca2.zmovieapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.salihakca2.zmovieapp.R
import com.salihakca2.zmovieapp.data.entity.ResultXXX
import com.salihakca2.zmovieapp.databinding.ReleaseTvItemBinding
import com.salihakca2.zmovieapp.ui.fragment.ReleasePageFragmentDirections
import com.squareup.picasso.Picasso

class ReleaseTvAdapter(var mContext: Context, var releaseTvList:List<ResultXXX> )
    :RecyclerView.Adapter<ReleaseTvAdapter.CardBindingHolderTv>(){
    inner class CardBindingHolderTv(binding: ReleaseTvItemBinding): RecyclerView.ViewHolder(binding.root){
        var binding: ReleaseTvItemBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardBindingHolderTv {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: ReleaseTvItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.release_tv_item,parent,false)

        return CardBindingHolderTv(binding)
    }

    override fun onBindViewHolder(holder: CardBindingHolderTv, position: Int) {
        val releaseTv = releaseTvList.get(position)
        val t = holder.binding

        t.releaseTvObject = releaseTv
        t.textViewDetailReleaseTvRate.text =  releaseTv.voteAverage.toString() + "/ 10"
        Picasso.get().load("https://image.tmdb.org/t/p/w342/" + releaseTv.posterPath).into(t.imageViewReleaseTvView)
        t.imageViewReleaseTvView.setOnClickListener {
           val transition = ReleasePageFragmentDirections.actionReleasePageFragmentToReleaseDetailTvFragment(releaseTv = releaseTv)
            Navigation.findNavController(it).navigate(transition)
        }

    }

    override fun getItemCount(): Int {
        return releaseTvList.size
    }
}