package com.petproject.voting.web.admin;

import com.petproject.voting.model.Vote;
import com.petproject.voting.service.VoteService;
import com.petproject.voting.to.VoteTo;
import com.petproject.voting.util.VotesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import static com.petproject.voting.util.ValidationUtil.assureIdConsistent;
import static com.petproject.voting.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = VoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {
    public static final String REST_URL = "/admin/votes";
    private static final Logger log = LoggerFactory.getLogger(VoteRestController.class);
    private final VoteService service;

    public VoteRestController(VoteService service) {
        this.service = service;
    }

    @GetMapping
    public List<VoteTo> getAll() {
        log.info("getAll");
        return VotesUtil.getTos(service.getAll());
    }

    @GetMapping(value = "/byRest")
    public List<VoteTo> getByRestId(
            @RequestParam int id) {
        log.info("getAll by restaurantId {}", id);
        return VotesUtil.getTos(service.getAllByRestaurantId(id));
    }

    @GetMapping(value = "/byDate")
    public List<VoteTo> getByDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("getAll by date {}", date);
        return VotesUtil.getTos(service.getAllByDate(date));
    }

    @GetMapping(value = "/byUser")
    public List<VoteTo> getByUserId(
            @RequestParam int id) {
        log.info("getAll by userId {}", id);
        return VotesUtil.getTos(service.getAllByUserId(id));
    }

    @GetMapping("/{id}")
    public VoteTo get(@PathVariable int id) {
        log.info("get voteTo {}", id);
        return VotesUtil.createTo(service.get(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("delete vote {}", id);
        service.delete(id);
    }
}
