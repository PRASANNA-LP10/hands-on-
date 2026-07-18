import React, { useState } from 'react';
import { useEffect } from 'react';
function Posts() {

    const [posts, setPosts] = useState([]);
     
    const loadPosts = async () => {
        try {
        const response = await fetch('https://jsonplaceholder.typicode.com/posts');
         if (!response.ok) {
        throw new Error('Failed to fetch posts from the server.');
      }
        const data = await response.json();
        setPosts(data);
    }
    catch (error) {
        console.error('Error fetching posts:', error);
    }
    finally {
        console.log('Fetch operation completed.');
    }
};
    console.log(posts);
useEffect(() => {
    loadPosts();
  }, []);

  return (
    <div>
      <h1>Posts</h1>
      {posts.length > 0 ? (
        <div>
          {posts.map((post) => (
            
            <h4 key={post.id}>
              <h2>{post.title}</h2>
              <p>{post.body}</p>
              </h4>
           
          ))}
        </div>
      ) : (
        <p>No posts available.</p>
      )}
    </div>
  );
}


export default Posts;