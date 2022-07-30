package com.example.myposts

import android.net.DnsResolver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
//    binding =ActivityMainBinding.inflate(layoutInflater)
//    setContentView(binding.root)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchPosts()
    }

fun fetchPosts(){
    var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
    var request = apiClient.getPosts()

    request.enqueue(object : Callback<List<Post>> {
        override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
            if (response.isSuccessful){
                var posts = response.body()
                 Toast.makeText(baseContext,"fetched ${posts!!.size} posts",Toast.LENGTH_LONG).show()
                var postsadapter = PostsRvAdapter(posts)
                binding.rvPost.layoutManager=LinearLayoutManager(this@MainActivity)
                binding.rvPost.adapter = postsadapter



            }
        }

        override fun onFailure(call: Call<List<Post>>, t: Throwable) {

        }
    })
}
}

//fun displayTweets () {
//    var tweetOne = Peopletweets("Shirleen","9h","@shirleengathungu"
//        ,"Hello Alien lovers!,See you at the eighth ring!Finally after ages!",8000,900,100,"shirleen.jpg")
//    var tweetTwo  = Peopletweets("Mira Nurasky","1m","@miraNu"
//        ,"Made Ravioli today and it was delightful! Italian food enthusiast",900,90,90,"shirleen.jpg")
//    var tweetThree  = Peopletweets("Dave Karagas"," 2 days ago","@kardave"
//        ,"Yeah! I am gonna take my horse to the old town road.Hello Texas!",700000,8,55,"shirleen.jpg")
//    var tweetFour = Peopletweets("Emma Mackey","2m","@emmamackey"
//        ,"Return of SE season 4.Get ready everyone! I really missed the crew!",80908,7000000,40,"shirleen.jpg")
//    var tweetFive = Peopletweets("Josey Oduhachi","11h","@odujo"
//        ,"Had amazing with @Shirleen Gathungu at the eigth ring watch.Bonded over telescopes and space suits",11111100,4500,900,"shirleen.jpg")
//    var tweetSix  = Peopletweets("Locke&Key","5m","@locke&key"
//        ,"Fasten your seatbelts everyone,The Lockes are back.Filming of season 4 in progress",9009090,876,45678,"shirleen.jpg")
//
//    var tweetsList= listOf(tweetOne,tweetTwo,tweetThree,tweetFour,tweetFive,tweetSix)
//
//    var tweetsAdapter = TweetsAdapter(tweetsList)
//    binding.rvTweets.layoutManager = LinearLayoutManager(this)
//    binding.rvTweets.adapter = tweetsAdapter
