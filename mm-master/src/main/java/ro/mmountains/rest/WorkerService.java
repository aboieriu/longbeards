package ro.mmountains.rest;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.mmountains.view.MessageView;

import java.io.IOException;
import java.util.List;

/**
 * Created by aboieriu on 7/13/16.
 */
@RestController
@RequestMapping("/cache-worker.js")
public class WorkerService {
    @RequestMapping
    public ResponseEntity<InputStreamResource> getCacheWorker() throws IOException {
        ClassPathResource file = new ClassPathResource("cache-worker.js");

        return ResponseEntity
                .ok()
                .contentLength(file.contentLength())
                .contentType(
                        MediaType.parseMediaType("application/javascript"))
                .body(new InputStreamResource(file.getInputStream()));
    }
}
