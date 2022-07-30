package com.example.myposts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

//class TweetsAdapter(var tweetsList: List<Peopletweets>): RecyclerView.Adapter<PeopletweetsViewHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopletweetsViewHolder {
//        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.twitter_app,parent,false)
//        return PeopletweetsViewHolder(itemView)
//    }

class PostsRvAdapter(var postList:List<Post>): RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var PostView = LayoutInflater.from(parent.context).inflate(R.layout.post_list_item,parent,false)
        return PostViewHolder(PostView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
//        var currentTweets = tweetsList.get(position)
//
//        holder.tvNameOne.text =currentTweets.name
//        holder.tvatOne.text =currentTweets.at
//        holder.tvTimeOne.text =currentTweets.time.toString()
//        holder.tvTweet.text =currentTweets.tweet


        var posts = postList.get(position)

        holder.tvUserId.text = posts.userId.toString()
        holder.tvId2.text = posts.id.toString()
        holder.tvTitle.text = posts.title
        holder.tvBody.text = posts.body




    }

    override fun getItemCount(): Int {
        return postList.size
    }
}

class PostViewHolder(itemView: View):  RecyclerView.ViewHolder(itemView){
    var tvUserId = itemView.findViewById<TextView>(R.id.tvUserId)
    var tvId2 = itemView.findViewById<TextView>(R.id.tvId2)
    var tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
    var tvBody = itemView.findViewById<TextView>(R.id.tvBody)
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
