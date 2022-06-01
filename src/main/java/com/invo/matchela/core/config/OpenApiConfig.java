package com.invo.matchela.core.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Matchella spring rest api",
                version = "v2",
                description = "This app provides REST APIs for matchella  ",
                contact = @Contact(
                        name = "",
                        email = "",
                        url = ""
                )
        ),
        servers = {
                @Server(
                        url = "<dev url>",
                        description = "DEV Server"
                ),
                @Server(
                        url = "<prod url>",
                        description = "PROD Server"
                )
        }
)
public class OpenApiConfig {

}
