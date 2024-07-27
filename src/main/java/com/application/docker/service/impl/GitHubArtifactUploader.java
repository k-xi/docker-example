/*
package com.application.docker.service.impl;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class GitHubArtifactUploader {

    private static final String GITHUB_API_ENDPOINT = "https://api.github.com";
    private static final String OWNER = "harisha3193";
    private static final String REPO_NAME = "docker-example";
    private static final String RELEASES_URL = GITHUB_API_ENDPOINT + "/repos/" + OWNER + "/" + REPO_NAME + "/releases";


    public void uploadArtifact() throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(RELEASES_URL);
        httpPost.setHeader(HttpHeaders.AUTHORIZATION, "token " + "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");

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();

        File artifactFile = new File("");

        builder.addBinaryBody("file", artifactFile);

        httpPost.setEntity(builder.build());

        HttpResponse response = httpClient.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();

        if (statusCode == 201) {
            System.out.println("Artifact uploaded successfully!");
        } else {
            System.err.println("Failed to upload artifact. Status code: " + statusCode);
        }
    }
}
*/
