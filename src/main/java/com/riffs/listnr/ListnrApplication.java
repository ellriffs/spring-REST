package com.riffs.listnr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.riffs.listnr.domain.Albums;
import com.riffs.listnr.domain.AlbumRepository;

@SpringBootApplication
public class ListnrApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(ListnrApplication.class);

	private final AlbumRepository repository;

	public ListnrApplication(AlbumRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ListnrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Albums(
				"Permission To Land",
				"The Darkness",
				"https://media.pitchfork.com/photos/64a61949cf2fafdbddfaebbb/master/pass/The-Darkness-Permission-to-Land.jpg",
				2003));

		repository.save(new Albums(
				"Black Album",
				"Metallica",
				"https://townsquare.media/site/295/files/2016/08/metallica-blackalbum.jpg?w=1200&h=0&zc=1&s=0&a=t&q=89",
				1991));

		repository.save(new Albums(
				"Images and Words",
				"Dreamtheater",
				"https://m.media-amazon.com/images/W/MEDIAX_792452-T2/images/I/91peiIHOUTL._UF1000,1000_QL80_.jpg",
				1992));

		for (Albums albums : repository.findAll()) {
			logger.info("album: {}, artist, {}",
					albums.getName(), albums.getArtist());
		}

	}
}
