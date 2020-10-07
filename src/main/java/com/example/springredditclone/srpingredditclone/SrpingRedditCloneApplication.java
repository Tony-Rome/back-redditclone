package com.example.springredditclone.srpingredditclone;

import com.example.springredditclone.srpingredditclone.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import(SwaggerConfiguration.class)
public class SrpingRedditCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrpingRedditCloneApplication.class, args);
	}

}
