package com.book.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		@Column(name="name")
		private String name;
		
		@Column(name="author")
		private String author;
		
		@Column(name="genre")
		private String genre;
		
		@Column(name="availability")
		private int availability;
		
		public Book() {
			
		}
		public Book(String name, String author, String genre, int availability) {
			super();
			this.name = name;
			this.author = author;
			this.genre = genre;
			this.availability = availability;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getgenre() {
			return genre;
		}
		public void setgenre(String genre) {
			this.genre = genre;
		}
		public int getAvailability() {
			return availability;
		}
		public void setAvailability(int availability) {
			this.availability = availability;
		}
		
		
		}

