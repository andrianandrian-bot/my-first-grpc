package com.example.myspring.config

import com.example.myspring.grpc.MyGrpcServiceIml
import io.grpc.ServerBuilder
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder
import net.devh.boot.grpc.server.serverfactory.GrpcServerConfigurer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import java.util.concurrent.TimeUnit


@Configuration
class SwaggerConfig {

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.example.myspring.controller"))
            .paths(PathSelectors.any())
            .build()
    }

//    @Bean
//    fun keepAliveServerConfigurer(): GrpcServerConfigurer? {
//        return GrpcServerConfigurer { serverBuilder: ServerBuilder<*>? ->
//            if (serverBuilder is NettyServerBuilder) {
//                serverBuilder
//                    .keepAliveTime(30, TimeUnit.SECONDS)
//                    .keepAliveTimeout(5, TimeUnit.SECONDS)
//                    .permitKeepAliveWithoutCalls(true)
//            }
//        }
//    }

}