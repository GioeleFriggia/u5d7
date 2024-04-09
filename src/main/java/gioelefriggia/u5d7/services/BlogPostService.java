package gioelefriggia.u5d7.services;

import gioelefriggia.u5d7.entities.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogPostService {
    private final List<BlogPost> blogPosts = new ArrayList<>();
    private int nextId = 1;

    public List<BlogPost> getAllBlogPosts() {
        return blogPosts;
    }

    public BlogPost getBlogPostById(int id) {
        for (BlogPost blogPost : blogPosts) {
            if (blogPost.getId() == id) {
                return blogPost;
            }
        }
        return null; // Ritorna null se non viene trovato alcun blog post con l'ID specificato
    }

    public BlogPost createBlogPost(BlogPost blogPost) {
        blogPost.setId(nextId++);
        blogPosts.add(blogPost);
        return blogPost;
    }

    public BlogPost updateBlogPost(int id, BlogPost updatedBlogPost) {
        for (BlogPost blogPost : blogPosts) {
            if (blogPost.getId() == id) {
                blogPost.setTitle(updatedBlogPost.getTitle());
                blogPost.setContent(updatedBlogPost.getContent());
                return blogPost;
            }
        }
        return null;
    }

    public void deleteBlogPost(int id) {
        blogPosts.removeIf(blogPost -> blogPost.getId() == id);
    }
}
