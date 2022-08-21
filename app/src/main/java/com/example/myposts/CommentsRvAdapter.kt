package com.example.myposts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.databinding.CommentsListItemBinding
import com.example.myposts.databinding.PostListItemBinding

class CommentsRvAdapter(var commentsList: List<Comments>):
    RecyclerView.Adapter<CommentViewHolder> ()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var binding = CommentsListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentComment = commentsList.get(position)
        holder.binding.tvPostId.text = currentComment.PostId.toString()
        holder.binding.tvCommentId.text = currentComment.id.toString()
        holder.binding.tvName.text = currentComment.name
        holder.binding.tvEmail.text = currentComment.email
        holder.binding.tvBody.text = currentComment.body


    }

    override fun getItemCount(): Int {
        return commentsList.size

    }

}class CommentViewHolder(var binding: CommentsListItemBinding) : RecyclerView.ViewHolder(binding.root) {

}