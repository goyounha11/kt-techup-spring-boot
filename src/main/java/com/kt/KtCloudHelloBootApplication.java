package com.kt;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.MediaType;

import com.kt.controller.HelloTomcatController;
import com.kt.controller.PlayTomcatController;
import com.kt.notice.NoticeController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.val;

@SpringBootApplication
public class KtCloudHelloBootApplication {

	public static void main(String[] args) {
		GenericApplicationContext context = new GenericApplicationContext();
		context.registerBean(HelloTomcatController.class);
		context.registerBean(PlayTomcatController.class);
		context.refresh();

		// 내장된 톰캣을 이용해서 스프링 부트를 실행볼까함
		var tomcat = new TomcatServletWebServerFactory();

		var webServer = tomcat.getWebServer(servletContext -> {
			servletContext.addServlet("frontcontroller", new HttpServlet() {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					// /hello 라는 요청을보내면 HelloBootController가 처리하도록 Hello World가 출력되도록
					// http://localhost:8080/hello?name=ktcloud
					// name의 값을 콘솔에 출력
					if (req.getRequestURI().equals("/notice") && req.getMethod().equals("POST")) {
						var controller = context.getBean(NoticeController.class);


						resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
						resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
						resp.getWriter().println();
					}

					if(req.getRequestURI().equals("/play") && req.getMethod().equals("GET")) {
						var controller = context.getBean(PlayTomcatController.class);

						var game = req.getParameter("game");

						var result = controller.play(game);

						resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
						resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
						resp.getWriter().println(result);
					}
				}

				// 뭐할건지
			}).addMapping("/*");
		});

		webServer.start();
	}
}
