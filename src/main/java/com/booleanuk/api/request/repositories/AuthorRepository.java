package com.booleanuk.api.request.repositories;

import com.booleanuk.api.request.models.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {
    public ArrayList<Author> authors;
    public AuthorRepository(){
        authors = new ArrayList<>();
        this.authors.add(new Author("Roald Dahl","roald@gmail.com"));
        this.authors.add(new Author("Noah Trevor","noah@gmail.com"));

    }

    public List<Author> getAll(){
        return this.authors;
    }
    public Author getOne(int id){
        return this.authors.stream()
                .filter(author -> author.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Author create(Author author){
//         this.authors.add(author);
//         return author;
        boolean created = this.authors.add(author);
        if(created){
            return author;
        }
        return null;

    }
//    public Author update(int id){
//        for (Author author : authors){
//            if (author.getId() == id){
//                int index = this.authors.indexOf(author);
//                this.authors.get(index).setEmail(author.getEmail());
//                this.authors.get(index).setName(author.getName());
//                return this.authors.set(index, author);
//            }
//        }
//        return null;
//    }

    public Author update(int id, Author updatedAuthor){
        Author authorToUpdate = this.authors.stream()
                .filter(author -> author.getId() == id)
                .findFirst()
                .orElse(null);

        if(authorToUpdate != null){
            authorToUpdate.setName(updatedAuthor.getName());
            authorToUpdate.setEmail(updatedAuthor.getEmail());
        }
        authorToUpdate = this.getOne(id);
        return authorToUpdate;
    }
    public Author delete(int id){
//        for (Author author : authors){
//            if (author.getId() == id){
//                int index = authors.indexOf(author);
//                return this.authors.remove(index);
//            }
//        }
//        return null;
        Author authorToDelete = this.authors.stream()
                .filter(author -> author.getId() == id)
                .findFirst()
                .orElse(null);

        if(authorToDelete != null){
            this.authors.remove(authorToDelete);
        }
        return authorToDelete;
    }

}
