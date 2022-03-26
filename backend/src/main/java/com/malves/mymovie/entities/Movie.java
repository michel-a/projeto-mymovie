package com.malves.mymovie.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "filmes")
public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "titulo_traduzido")
	private String translatedTitle;
	
	@Column(name = "titulo_original")
	private String originalTitle;
	
	@Column(name = "ano_de_lancamento")
	private LocalDate releaseYear;
	
	@Column(name = "genero")
	private String genre;
	
	@Column(name = "audio")
	private String audio;
	
	@Column(name = "tamanho")
	private Float size;
	
	@Column(name = "duracao")
	private Short duration;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTranslatedTitle() {
		return translatedTitle;
	}
	
	public void setTranslatedTitle(String translatedTitle) {
		this.translatedTitle = translatedTitle;
	}
	
	public String getOriginalTitle() {
		return originalTitle;
	}
	
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}
	
	public LocalDate getReleaseYear() {
		return releaseYear;
	}
	
	public void setReleaseYear(LocalDate releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getAudio() {
		return audio;
	}
	
	public void setAudio(String audio) {
		this.audio = audio;
	}
	
	public Float getSize() {
		return size;
	}
	
	public void setSize(Float size) {
		this.size = size;
	}
	
	public Short getDuration() {
		return duration;
	}
	
	public void setDuration(Short duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", translatedTitle=" + translatedTitle + ", originalTitle=" + originalTitle
				+ ", releaseYear=" + releaseYear + ", genre=" + genre + ", audio=" + audio + ", size=" + size
				+ ", duration=" + duration + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, translatedTitle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(id, other.id) && Objects.equals(translatedTitle, other.translatedTitle);
	}
	
	
}
