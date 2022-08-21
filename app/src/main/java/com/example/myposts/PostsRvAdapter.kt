package com.example.myposts

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.databinding.PostListItemBinding

//class TweetsAdapter(var tweetsList: List<Peopletweets>): RecyclerView.Adapter<PeopletweetsViewHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopletweetsViewHolder {
//        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.twitter_app,parent,false)
//        return PeopletweetsViewHolder(itemView)
//    }

class PostsRvAdapter(var postList:List<Post>): RecyclerView.Adapter<PostViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
            var binding = PostListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return PostViewHolder(binding)
        }

        override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
//
            var posts = postList.get(position)
            holder.binding.tvUserId.text = posts.userId.toString()
            holder.binding.tvId2.text = posts.id.toString()
            holder.binding.tvTitle.text = posts.title
            holder.binding.tvBody.text = posts.body

            val context = holder.itemView.context
            holder.binding.cvPost.setOnClickListener {
                val intent = Intent(context, CommentsActivity::class.java)
                intent.putExtra("POST_ID", posts.id)
                context.startActivity(intent)
            }


        }

        override fun getItemCount(): Int {
            return postList.size
        }
    }

    class PostViewHolder(var binding:PostListItemBinding) : RecyclerView.ViewHolder(binding.root) {

}

//
//class PeopletweetsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//    var tvNameOne= itemView.findViewById<TextView>(R.id.tvNameOne)
//    var tvatOne = itemView.findViewById<TextView>(R.id.tvatOne)
//    var  tvTimeOne =itemView.findViewById<TextView>(R.id.tvTimeOne)
//    var tvTweet= itemView.findViewById<TextView>(R.id.tvTweet)
//    var ivReply =itemView.findViewById<ImageView>(R.id.ivReply)
//    var ivRetweet =itemView.findViewById<ImageView>(R.id.ivRetweet)
//    var ivShare =itemView.findViewById<ImageView>(R.id.ivShare)
//    var ivShirleen= itemView.findViewById<ImageView>(R.id.ivShirleen)
//
