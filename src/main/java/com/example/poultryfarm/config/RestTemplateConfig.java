// package com.example.poultryfarm.config;

// import org.springframework.boot.web.client.RestTemplateBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.client.RestTemplate;

// import javax.net.ssl.HostnameVerifier;
// import javax.net.ssl.SSLContext;
// import javax.net.ssl.TrustManager;
// import javax.net.ssl.X509TrustManager;
// import java.security.cert.X509Certificate;

// @Configuration
// public class RestTemplateConfig {

//     @Bean
//     public RestTemplate restTemplate(RestTemplateBuilder builder) {
//         return builder
//             .requestFactory(() -> new HttpComponentsClientHttpRequestFactory(httpClient()))
//             .build();
//     }

//     private CloseableHttpClient httpClient() {
//         try {
//             TrustManager[] trustAllCerts = new TrustManager[]{
//                 new X509TrustManager() {
//                     public X509Certificate[] getAcceptedIssuers() { return null; }
//                     public void checkClientTrusted(X509Certificate[] certs, String authType) { }
//                     public void checkServerTrusted(X509Certificate[] certs, String authType) { }
//                 }
//             };

//             SSLContext sslContext = SSLContext.getInstance("SSL");
//             sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
//             HostnameVerifier hostnameVerifier = (hostname, session) -> true;

//             return HttpClients.custom()
//                 .setSSLContext(sslContext)
//                 .setSSLHostnameVerifier(hostnameVerifier)
//                 .build();
//         } catch (Exception e) {
//             throw new RuntimeException(e);
//         }
//     }
// }
